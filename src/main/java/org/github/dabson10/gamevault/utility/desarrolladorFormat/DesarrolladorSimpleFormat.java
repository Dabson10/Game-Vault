package org.github.dabson10.gamevault.utility.desarrolladorFormat;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorSimpleDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.springframework.stereotype.Component;

/**
 * Esta clase servirá para formatear de una clase de DTO a un Objeto Desarrollador.
 */
@Component
public class DesarrolladorSimpleFormat {

    /**
     * Este component sirve para formatear de un DesarrolladorSimpleDTO a un Desarrollador.
     * se utiliza en: {@code crearDesarrollador} del service.
     * @param desarrolladorDTO : Valores para formatear
     * @return : Regresará un Objeto formateado.
     */
    public Desarrollador formatDataSimple(DesarrolladorSimpleDTO desarrolladorDTO){
        Desarrollador des = new Desarrollador();
        des.setNombre(desarrolladorDTO.getNombre());
        des.setUbicacion(desarrolladorDTO.getUbicacion());
        des.setCreador(desarrolladorDTO.getCreador());
        return des;
    }

    public DesarrolladorSimpleDTO formatDataSimpleDTO(Desarrollador desarrollador){
        DesarrolladorSimpleDTO des = new DesarrolladorSimpleDTO();
        des.setIdDesarrollador(desarrollador.getIdDesarrollador());
        System.out.println("El ID es: " + des.getIdDesarrollador());
        des.setNombre(desarrollador.getNombre());
        des.setUbicacion(desarrollador.getUbicacion());
        des.setCreador(desarrollador.getCreador());
        return des;
    }


}
