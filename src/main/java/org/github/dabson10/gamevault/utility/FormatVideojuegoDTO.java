package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.dto.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoDTO;
import org.github.dabson10.gamevault.entity.Videojuego;
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

    public List<VideojuegoCompletoDTO> formatLista(List<Videojuego> videojuegos){
        List<VideojuegoCompletoDTO> listaFormat = new ArrayList<>();
        VideojuegoDTO vid = new VideojuegoDTO();
        videojuegos.forEach(video ->{
            listaFormat.add(formatData(video));
        });
        return listaFormat;
    }

    public VideojuegoCompletoDTO formatData(Videojuego video){
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
        videoDTO.setDesarrolladores(desFormat.formatData(video.getDesarrollador()));
        return videoDTO;
    }



}