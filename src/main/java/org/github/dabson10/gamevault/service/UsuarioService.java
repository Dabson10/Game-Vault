package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.UsuarioCredencialDTO;
import org.github.dabson10.gamevault.entity.Usuario;
import org.github.dabson10.gamevault.exceptions.EmailDuplicateException;
import org.github.dabson10.gamevault.exceptions.EmailNotFoundException;
import org.github.dabson10.gamevault.exceptions.IncorrectPasswordException;
import org.github.dabson10.gamevault.repository.UsuarioRepository;
import org.github.dabson10.gamevault.utility.ClaveHash;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService implements UsuarioServiceImp {

    private final UsuarioRepository usuRe;
    private final ClaveHash claveHash;

    public UsuarioService(UsuarioRepository usuRe, ClaveHash claveHash) {
        this.usuRe = usuRe;
        this.claveHash = claveHash;
        Logger log = LoggerFactory.getLogger(UsuarioService.class);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        Usuario usu = this.existenciaCorreo(usuario.getCorreo());
        // Si el correo ingresado existe entonces regresamos una excepción
        if (usu != null) {
            throw new EmailDuplicateException("Ingrese un corre electrónico diferente.");
        }
        String contra = claveHash.claveHash(usuario.getClave());
        usuario.setClave(contra);
        usuRe.save(usuario);
    }

    @Override
    public Usuario loginUsuario(UsuarioCredencialDTO credencial) {
        Usuario usu = this.existenciaCorreo(credencial.getCorreo());
        // Válida que el usuario exista.
        if (usu == null) {
            throw new EmailNotFoundException("Correo no encontrado.");
        }

        // Válida la contraseña del correo encontrado coincida con la clave ingresada.
        if (!claveHash.compararClave(credencial.getClave(), usu.getClave())) {
            // Si la contraseña es incorrecta.
            throw new IncorrectPasswordException("Contraseña incorrecta.");
        }
        return usu;
    }

    @Override
    public Usuario existenciaCorreo(String correo) {
        return usuRe.findUsuarioByCorreo(correo);
    }
}
