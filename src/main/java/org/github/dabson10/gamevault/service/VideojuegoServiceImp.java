package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCreateDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoUpdateDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Videojuego;

import java.util.List;
import java.util.Map;

public interface VideojuegoServiceImp {
    //Creación de un videojuego.
    VideojuegoCompletoDTO crearVideojuego(VideojuegoCreateDTO videojuego);
    //Trae un videojuego.
    VideojuegoCompletoDTO traerVideojuego(String nombre);

    //Función para editar el nombre de un videojuego.
    VideojuegoCompletoDTO editarVideojuego(VideojuegoUpdateDTO videoCambio);
    //Agrega plataformas a un videojuego.
    VideojuegoCompletoDTO agregarPlataforma(VideojuegoPlataformaDTO videojuego);
    //Elimina plataformas de un videojuego.
    VideojuegoCompletoDTO eliminarPlataforma(VideojuegoPlataformaDTO videoDTO);
    //Función para eliminar un videojuego sin afectar a las plataformas.
    Map<String, String> eliminarVideojuego(String nombre);
    //Traer una lista de videojuegos.
    List<VideojuegoCompletoDTO> listarVideojuegos();
    //Valida la existencia de un videojuego
    Videojuego existenciaVideojuego(String nombre);
}
