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
    VideojuegoCompletoDTO traerVideojuego(String nombre);

    //Agrega plataformas a un videojuego.
    VideojuegoCompletoDTO agregarPlataforma(VideojuegoPlataformaDTO videojuego);
    //Elimina plataformas de un videojuego.
    VideojuegoCompletoDTO eliminarPlataforma(VideojuegoPlataformaDTO videoDTO);
    //Traer una lista de videojuegos.
    List<VideojuegoCompletoDTO> listarVideojuegos();

    //Valida la existencia de un videojuego
    Videojuego existenciaVideojuego(String nombre);
}
