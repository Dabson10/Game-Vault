package org.github.dabson10.gamevault.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VideojuegoCompletoDTO {
    private Long idVideojuego;
    private String nombre;
    private String autor;
    private int duracion;
    private int porcentajeTotal;
    private LocalDate lanzado;
    //ColecciónDTO

    //DesarrolladorDTO
    DesarrolladorDTO desarrolladores;
    //PlataformaDTO
    private List<PlataformaNombreDTO> plataformas;
}
