package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Videojuego;

public interface VideojuegoServiceImp {
    //Creación de un videojuego.
    Videojuego crearVideojuego(Videojuego videojuego);
    //Trae un videojuego.
    Videojuego traerVideojuego(String nombre);

    //Valida la existencia de un videojuego
    Videojuego existenciaVideojuego(String nombre);
}
