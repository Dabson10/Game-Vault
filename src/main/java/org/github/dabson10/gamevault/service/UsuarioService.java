package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.usuarioDTO.UsuarioCredencialDTO;
import org.github.dabson10.gamevault.dto.usuarioDTO.UsuarioDTO;
import org.github.dabson10.gamevault.entity.Usuario;
import org.github.dabson10.gamevault.exceptions.EmailDuplicateException;
import org.github.dabson10.gamevault.exceptions.EmailNotFoundException;
import org.github.dabson10.gamevault.exceptions.IncorrectPasswordException;
import org.github.dabson10.gamevault.repository.UsuarioRepository;
import org.github.dabson10.gamevault.utility.ClaveHash;
import org.github.dabson10.gamevault.utility.FormatUsuario;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService implements UsuarioServiceImp {

    private final UsuarioRepository usuRe;
    private final ClaveHash claveHash;
    private final FormatUsuario forUser;

    public UsuarioService(UsuarioRepository usuRe, ClaveHash claveHash, FormatUsuario forUser) {
        this.usuRe = usuRe;
        this.claveHash = claveHash;
        Logger log = LoggerFactory.getLogger(UsuarioService.class);
        this.forUser = forUser;
    }

    @Override
    public UsuarioDTO crearUsuario(Usuario usuario) {
        Usuario usu = this.existenciaCorreo(usuario.getCorreo());
        // Si el correo ingresado existe entonces regresamos una excepción
        if (usu != null) {
            throw new EmailDuplicateException("Ingrese un corre electrónico diferente.");
        }
        String contra = claveHash.claveHash(usuario.getClave());
        usuario.setClave(contra);
        usuRe.save(usuario);
        return forUser.formatUsuario(usuario);
    }

    @Override
    public UsuarioDTO loginUsuario(UsuarioCredencialDTO credencial) {
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
        return forUser.formatUsuario(usu);
    }

    @Override
    public Usuario existenciaCorreo(String correo) {
        return usuRe.findUsuarioByCorreo(correo);
    }
}
