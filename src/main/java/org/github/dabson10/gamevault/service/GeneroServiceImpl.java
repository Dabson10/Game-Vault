package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.generoDTO.GeneroSimpleDTO;
import org.github.dabson10.gamevault.entity.Genero;

public interface GeneroServiceImpl {
    //Funcionalidades del service
    GeneroSimpleDTO crearGenero(GeneroSimpleDTO genero);
    Genero existenciaGenero(String genero);

}
