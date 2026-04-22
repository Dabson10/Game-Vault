package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Plataforma;

public interface PlataformaServiceImp {
    //Crea una nueva plataforma.
    Plataforma crearPlataforma(Plataforma plataforma);

    //Regresa una plataforma.
    Plataforma buscarPlataforma(String nombre);
    //Busca si existe una plataforma.
    Plataforma existenciaPlataforma(String nombre);
}
