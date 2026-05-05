package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.generoDTO.GeneroCompletoDTO;
import org.github.dabson10.gamevault.dto.generoDTO.GeneroSimpleDTO;
import org.github.dabson10.gamevault.entity.Genero;

import java.util.List;

public interface GeneroServiceImpl {
    //Funcionalidades del service
    GeneroSimpleDTO crearGenero(GeneroSimpleDTO genero);

    //Función para buscar mas de un género.
    List<GeneroCompletoDTO> buscarVideojuegosConGeneros(List<String> generos);

    //Función que regresa un objeto si existe es un objeto si no un null.
    Genero existenciaGenero(String genero);

}
