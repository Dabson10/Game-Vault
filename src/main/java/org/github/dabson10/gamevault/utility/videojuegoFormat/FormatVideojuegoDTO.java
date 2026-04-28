package org.github.dabson10.gamevault.utility.videojuegoFormat;

import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.utility.FormatDesarrollador;
import org.github.dabson10.gamevault.utility.FormatPlataforma;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormatVideojuegoDTO {
    private final FormatPlataforma plFormat;
    private final FormatDesarrollador desFormat;
    public FormatVideojuegoDTO(FormatPlataforma plFormat, FormatDesarrollador desFormat){
        this.plFormat = plFormat;
        this.desFormat = desFormat;
    }

    /**
     * Esta función sirve para formatear los datos de una lista de videojuegos y cambiar la plataforma de esta.
     * La unica diferencia es que este regresa una lista con {@code VideojuegoCompletoDTO}.
     * Esta función se utiliza en {@code VideojuegoService}.
     * @param videojuegos : Recibe una lista con los juegos en su clase fundamental.
     * @return : Regresará una lista con los videojuegos formateados del tipo: {@code VideojuegoCompletoDTO}
     */

    public List<VideojuegoCompletoDTO> formatListaVideojuego(List<Videojuego> videojuegos){
        List<VideojuegoCompletoDTO> listaFormat = new ArrayList<>();
        videojuegos.forEach(video -> listaFormat.add(formatDataVideojuego(video)));
        return listaFormat;
    }

    /**
     * Esta función sirve para formatear datos de un objeto del tipo {@code Videojuego} a un DTO llamado
     * {@code VideojuegoCompletoDTO}, esta función es utilizada en {@code VideojuegoService}
     * @param video : Este objeto contendrá los datos fundamentales del videojuego.
     * @return : Regresará un objeto tipo {@code VideojuegoCompletoDTO} con los datos formateados.
     */
    public VideojuegoCompletoDTO formatDataVideojuego(Videojuego video){
        VideojuegoCompletoDTO videoDTO = new VideojuegoCompletoDTO();
        videoDTO.setIdVideojuego(video.getIdVideojuego());
        videoDTO.setNombre(video.getNombre());
        videoDTO.setAutor(video.getAutor());
        videoDTO.setDuracion(video.getDuracion());
        videoDTO.setPorcentajeTotal(video.getPorcentajeTotal());
        videoDTO.setLanzado(video.getLanzado());
        //Ahora de un Videojuego hacer un formato de las plataformas.
        videoDTO.setPlataformas(plFormat.formatLista( video.getPlataforma()));
        //Ahora toca Agregar a los desarrolladores.
        videoDTO.setDesarrolladores(desFormat.formatDataSinVideojuegos(video.getDesarrollador()));
        return videoDTO;
    }




}