package org.github.dabson10.gamevault.dto.videojuegoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Esta clase sirve para ingresar el nombre de un videojuego y los nuevos valores de este.
 * Esta función será llamada para el service {@code #VideojuegoService}.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoUpdateDTO {
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese un nuevo nombre.")
    private String nombreNuevo;
    @NotBlank(message = "Ingrese una nueva duración.")
    private int duracion;
    @NotBlank(message = "Ingrese un nuevo porcentaje.")
    private int porcentajeTotal;
    @NotBlank(message = "Ingrese una fecha de lanzado.")
    private LocalDate lanzado;
}
