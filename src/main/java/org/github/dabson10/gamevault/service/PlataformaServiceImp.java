package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.entity.Plataforma;

import java.util.List;

public interface PlataformaServiceImp {
    //Crea una nueva plataforma.
    PlataformaNombreDTO crearPlataforma(PlataformaNombreDTO plataforma);

    //Regresa una plataforma.
    PlataformaNombreDTO buscarPlataforma(PlataformaNombreDTO plataforma);
    //Lista las plataformas
    List<PlataformaNombreDTO> listarPlataformas();

    //Lista una plataforma y los videojuegos en esta que contengan cierto autor.
    void listarPorAutor(String nombre);

    //Busca si existe una plataforma.
    Plataforma existenciaPlataforma(String nombre);
}
