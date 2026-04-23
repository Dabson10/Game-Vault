package org.github.dabson10.gamevault.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.gamevault.entity.Coleccion;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private List<Coleccion> coleccion;

}
