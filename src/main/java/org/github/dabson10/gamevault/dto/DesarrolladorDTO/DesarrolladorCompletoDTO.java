package org.github.dabson10.gamevault.dto.DesarrolladorDTO;

import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformasDTO;

import java.util.List;

@Getter @Setter
public class DesarrolladorCompletoDTO {
    private Long idDesarrollador;
    private String nombre;
    private String ubicacion;
    private String creador;
    private List<VideojuegoPlataformasDTO> videojuego;
}
