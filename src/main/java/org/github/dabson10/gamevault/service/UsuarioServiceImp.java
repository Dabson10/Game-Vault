package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.UsuarioCredencialDTO;
import org.github.dabson10.gamevault.entity.Usuario;

public interface UsuarioServiceImp {
    //Función para crear un usuario nuevo.
    public void crearUsuario(Usuario usuario);

    //Función para buscar por correo
    public Usuario loginUsuario(UsuarioCredencialDTO credencial);
    //Función para buscar usuario por correo, este solo es para validar la existencia del usuario.
    Usuario existenciaCorreo(String correo);

}
