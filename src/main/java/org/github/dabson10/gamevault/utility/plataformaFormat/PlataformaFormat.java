package org.github.dabson10.gamevault.utility.plataformaFormat;

import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contendrá funciones para formatear de Plataforma a PlataformaNombreDTO
 */
@Component
public class PlataformaFormat {


    public List<PlataformaNombreDTO> formatList(List<Plataforma> plataformas){
        List<PlataformaNombreDTO> lista = new ArrayList<>();

        plataformas.forEach(plataforma -> lista.add(platformData(plataforma)) );
        return lista;
    }

    /**
     * Esta función formatea de un PlataformaNombreDTO a una Plataforma,
     * regresando un DTO a su original.
     * @param dato : DTO con los datos.
     * @return : Regresará una Plataforma con los datos del DTO.
     */
    public Plataforma platformDataDTO(PlataformaNombreDTO dato){
        Plataforma plat = new Plataforma();
        plat.setNombrePlataforma(dato.getNombrePlataforma());
        return plat;
    }

    /**
     * Esta función formatea de una Plataforma a un DTO, es la version contraria a
     * {@link #platformDataDTO(PlataformaNombreDTO)}
     * @param plataforma : Objeto que contendrá todos los datos de Plataforma.
     * @return : Regresará el DTO con su atributos llenos.
     */
    public PlataformaNombreDTO platformData(Plataforma plataforma){
        PlataformaNombreDTO plat = new PlataformaNombreDTO();
        plat.setIdPlataforma(plataforma.getIdPlataforma());
        plat.setNombrePlataforma(plataforma.getNombrePlataforma());
        return plat;
    }

}
