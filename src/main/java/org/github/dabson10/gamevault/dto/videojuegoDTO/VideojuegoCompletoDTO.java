package org.github.dabson10.gamevault.dto.videojuegoDTO;

import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorVideojuegoDTO;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase es un DTO que se utilizara en la mayoría de los {@code controller}
 * para
 * que regrese un valor completo y sin bucles de datos.
 */
@Getter
@Setter
public class VideojuegoCompletoDTO {
    private Long idVideojuego;
    private String nombre;
    private String autor;
    private int duracion;
    private int porcentajeTotal;
    private LocalDate lanzado;
    // DesarrolladorDTO
    DesarrolladorVideojuegoDTO desarrolladores;
    // PlataformaDTO
    private List<PlataformaNombreDTO> plataformas;
}
