package org.github.dabson10.gamevault.dto.videojuegoDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VideojuegoCreateDTO {
    private String nombre;
    private String autor;
    private int duracion;
    private LocalDate lanzado;
    private int porcentajeTotal;
    private Long idDesarrollador;
    private List<Long> plataformas;
}
