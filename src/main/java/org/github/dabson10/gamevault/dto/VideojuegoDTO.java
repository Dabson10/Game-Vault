package org.github.dabson10.gamevault.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.gamevault.entity.Coleccion;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoDTO {
    private Long id;
    private String nombre;
    private String autor;
    private int duracion;
    private int porcentajeTotal;
    private LocalDate Lanzado;

}
