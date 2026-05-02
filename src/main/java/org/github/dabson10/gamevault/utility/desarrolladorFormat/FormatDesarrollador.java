package org.github.dabson10.gamevault.utility.desarrolladorFormat;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorVideojuegoDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaBasicDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormatDesarrollador {


    public List<DesarrolladorDTO> formatLista(List<Desarrollador> desarrollador){
        List<DesarrolladorDTO> listDes = new ArrayList<>();

        desarrollador.forEach(lista -> listDes.add(formatDataConVideojuegos(lista)));

        return listDes;
    }

    //Formateamos los datos básicos del desarrollador
    public DesarrolladorDTO formatDataConVideojuegos(Desarrollador desarrollador){
        DesarrolladorDTO desa = new DesarrolladorDTO();
        desa.setIdDesarrollador(desarrollador.getIdDesarrollador());
        desa.setNombre(desarrollador.getNombre());
        desa.setUbicacion(desarrollador.getUbicacion());
        desa.setCreador(desarrollador.getCreador());
        desa.setVideojuegos(formatListaPlataforma(desarrollador.getVideojuego()));
        return desa;
    }

    public DesarrolladorVideojuegoDTO formatDataSinVideojuegos(Desarrollador desarrollador){
        DesarrolladorVideojuegoDTO desa = new DesarrolladorVideojuegoDTO();
        desa.setNombre(desarrollador.getNombre());
        desa.setUbicacion(desarrollador.getUbicacion());
        desa.setCreador(desarrollador.getCreador());
        return desa;
    }

    public List<VideojuegoPlataformaBasicDTO> formatListaPlataforma(List<Videojuego> videojuego){
        List<VideojuegoPlataformaBasicDTO> list = new ArrayList<>();
        videojuego.forEach(video -> {
            list.add(this.formatDataPlataforma(video));
        });
        return list;
    }

    public VideojuegoPlataformaBasicDTO formatDataPlataforma(Videojuego video){
        VideojuegoPlataformaBasicDTO viPla = new VideojuegoPlataformaBasicDTO();
        viPla.setNombre(video.getNombre());
        return viPla;
    }
}
