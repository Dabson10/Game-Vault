package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Desarrollador;

public interface DesarrolladorServiceImp {
    //Crear desarrollador
    Desarrollador crearDesarrollador(Desarrollador desarrollador);
    //Existencia desarrollador.
    Desarrollador traerDesarrollador(String nombre);
    //Buscar un desarrollador.
    Desarrollador existenciaDesarrollador(String nombre);

}
