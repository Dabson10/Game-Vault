package org.github.dabson10.gamevault.dto.videojuegoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.gamevault.entity.Plataforma;

import java.util.List;

/**
 * Esta clase sirve para ya sea agregar nuevas plataformas
 * a un videojuego o eliminarlas.
 */
@Setter @Getter
public class VideojuegoPlataformaDTO {
    @NotBlank(message = "Ingrese un nombre correcto")
    private String nombre;
    private List<Plataforma> plataforma;
}
