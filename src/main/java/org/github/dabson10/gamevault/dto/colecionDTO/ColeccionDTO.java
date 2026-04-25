package org.github.dabson10.gamevault.dto.colecionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ColeccionDTO {
    private Long idColeccion;
    private String progreso;
    private int horasJugadas;
    private String formato;
    private String proposito;

}
