package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorCompletoDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorSimpleDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;

import java.util.List;

public interface DesarrolladorServiceImp {
    //Crear desarrollador
    DesarrolladorSimpleDTO crearDesarrollador(DesarrolladorSimpleDTO desarrollador);
    //Existencia desarrollador.
    DesarrolladorCompletoDTO traerDesarrollador(String nombre);
    //Buscar un desarrollador.
    Desarrollador existenciaDesarrollador(String nombre);

    //Función que listara a los desarrolladores.
    List<DesarrolladorDTO> listaDesarrollador();

}
