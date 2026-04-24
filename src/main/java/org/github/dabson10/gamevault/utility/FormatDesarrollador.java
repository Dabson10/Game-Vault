package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.springframework.stereotype.Component;

@Component
public class FormatDesarrollador {

    //Formateamos los datos básicos del desarrollador
    public DesarrolladorDTO formatData(Desarrollador desarrollador){
        DesarrolladorDTO desa = new DesarrolladorDTO();
        desa.setIdDesarrollador(desarrollador.getIdDesarrollador());
        desa.setNombre(desarrollador.getNombre());
        desa.setUbicacion(desarrollador.getUbicacion());
        desa.setCreador(desarrollador.getCreador());
        return desa;
    }
}
