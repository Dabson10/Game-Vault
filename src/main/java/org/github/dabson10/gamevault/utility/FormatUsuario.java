package org.github.dabson10.gamevault.utility;


import org.github.dabson10.gamevault.dto.usuarioDTO.UsuarioDTO;
import org.github.dabson10.gamevault.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FormatUsuario {

    public UsuarioDTO formatUsuario(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellidos(usuario.getApellidos());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setColeccion(usuario.getColeccion());
        return usuarioDTO;
    }


}
