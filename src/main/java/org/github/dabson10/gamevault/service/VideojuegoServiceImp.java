package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Videojuego;

import java.util.List;

public interface VideojuegoServiceImp {
    //Creación de un videojuego.
    Videojuego crearVideojuego(Videojuego videojuego);
    //Trae un videojuego.
    Videojuego traerVideojuego(String nombre);

    VideojuegoCompletoDTO agregarPlataforma(VideojuegoPlataformaDTO videojuego);
    //Traer una lista de videojuegos.
    List<VideojuegoCompletoDTO> listarVideojuegos();

    //Valida la existencia de un videojuego
    Videojuego existenciaVideojuego(String nombre);
}
