package org.github.dabson10.gamevault.utility.generoFormat;

import org.github.dabson10.gamevault.dto.generoDTO.GeneroSimpleDTO;
import org.github.dabson10.gamevault.entity.Genero;
import org.springframework.stereotype.Component;

/**
 * En esta clase se encontrarán todos los format correspondientes al DTO simple de
 * géneros, incluyendo las que son de (DTO -> Género) (DTO <- Género).
 */
@Component
public class GeneroFormatSimple {

    //================= Genero -> GeneroSimpleDTO =================
    public GeneroSimpleDTO formatDataSimpleDTO(Genero genero){
        GeneroSimpleDTO gen = new GeneroSimpleDTO();
        gen.setIdGenero(genero.getIdGenero());
        gen.setGenero(genero.getGenero());
        return gen;
    }


    //=================== GeneroSimpleDTO -> Genero ===============
    public Genero formatDataSimple (GeneroSimpleDTO genDTO){
        Genero gen = new Genero();
        gen.setGenero(genDTO.getGenero());
        return gen;
    }
}
