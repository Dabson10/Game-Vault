package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaDTO;
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

    /**
     * Esta función sirve para formatear los datos de una lista de videojuegos y cambiar la plataforma de esta.
     * La unica diferencia es que este regresa una lista con VideojuegoCompletoDTO
     * @param videojuegos : Recibe una lista con los juegos en su clase fundamental.
     * @return
     */
    public List<VideojuegoCompletoDTO> formatListaVideojuego(List<Videojuego> videojuegos){
        List<VideojuegoCompletoDTO> listaFormat = new ArrayList<>();
        videojuegos.forEach(video ->{
            listaFormat.add(formatDataVideojuego(video));
        });
        return listaFormat;
    }

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
        videoDTO.setDesarrolladores(desFormat.formatData(video.getDesarrollador()));
        return videoDTO;
    }


    public List<VideojuegoPlataformaDTO> formatListaPlataforma(List<Videojuego> videojuego){
        List<VideojuegoPlataformaDTO> list = new ArrayList<>();
        videojuego.forEach(video -> {
            list.add(this.formatDataPlataforma(video));
        });
        return list;
    }

    public VideojuegoPlataformaDTO formatDataPlataforma(Videojuego video){
        VideojuegoPlataformaDTO viPla = new VideojuegoPlataformaDTO();
        viPla.setNombre(video.getNombre());
        return viPla;
    }



}