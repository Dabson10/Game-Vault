package org.github.dabson10.gamevault.dto.videojuegoDTO;

import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class VideojuegoPlataformasDTO {
    private Long idVideojuego;
    private String nombre;
    private String autor;
    private int duracion;
    private int porcentajeTotal;
    private LocalDate lanzado;
    private List<PlataformaNombreDTO> plataformas;
}
