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
    //Lista todas las plataformas que no tienen un videojuego.
    List<PlataformaNombreDTO> listarSinUsar();
    //Regresará la cantidad de plataformas si usar.
    Long cantSinUsar();

    //Busca si existe una plataforma.
    Plataforma existenciaPlataforma(String nombre);
}
