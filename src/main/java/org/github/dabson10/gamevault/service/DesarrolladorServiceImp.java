package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;

import java.util.List;

public interface DesarrolladorServiceImp {
    //Crear desarrollador
    Desarrollador crearDesarrollador(Desarrollador desarrollador);
    //Existencia desarrollador.
    Desarrollador traerDesarrollador(String nombre);
    //Buscar un desarrollador.
    Desarrollador existenciaDesarrollador(String nombre);

    //Función que listara a los desarrolladores.
    List<DesarrolladorDTO> listaDesarrollador();

}
