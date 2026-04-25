package org.github.dabson10.gamevault.dto.DesarrolladorDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaDTO;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class DesarrolladorDTO {
    private Long idDesarrollador;
    private String nombre;
    private String ubicacion;
    private String creador;
    private List<VideojuegoPlataformaDTO> videojuegos;
}
