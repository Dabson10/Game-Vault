package org.github.dabson10.gamevault.dto.DesarrolladorDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class DesarrolladorSimpleDTO {
    private Long idDesarrollador;
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese una ubicación")
    private String ubicacion;
    @NotBlank(message = "Ingrese un creador.")
    private String creador;
}
