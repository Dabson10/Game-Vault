package org.github.dabson10.gamevault.utility.generoFormat;

import org.github.dabson10.gamevault.dto.generoDTO.GeneroCompletoDTO;
import org.github.dabson10.gamevault.entity.Genero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroCompletoFormat {

    // =================== Formatear de Genero a GeneroCompletoDTO ===============

    /**
     *
     * @param generos
     * @return
     */
    public List<GeneroCompletoDTO> formListGenero(List<Genero> generos){
        List<GeneroCompletoDTO> genero = new ArrayList<>();

        return genero;
    }

    public GeneroCompletoDTO formDataGenero(Genero genero){
        GeneroCompletoDTO gen = new GeneroCompletoDTO();


        return gen;
    }


}
