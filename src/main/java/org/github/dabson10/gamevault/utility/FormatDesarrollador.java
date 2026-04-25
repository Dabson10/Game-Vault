package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormatDesarrollador {

    private final FormatVideojuegoDTO formatVideo;
    public FormatDesarrollador(FormatVideojuegoDTO formatVideo){
        this.formatVideo = formatVideo;
    }

    public List<DesarrolladorDTO> formatLista(List<Desarrollador> desarrollador){
        List<DesarrolladorDTO> listDes = new ArrayList<>();

        desarrollador.forEach(lista -> {
            listDes.add(formatData(lista));
        });


        return listDes;
    }

    //Formateamos los datos básicos del desarrollador
    public DesarrolladorDTO formatData(Desarrollador desarrollador){
        DesarrolladorDTO desa = new DesarrolladorDTO();
        desa.setIdDesarrollador(desarrollador.getIdDesarrollador());
        desa.setNombre(desarrollador.getNombre());
        desa.setUbicacion(desarrollador.getUbicacion());
        desa.setCreador(desarrollador.getCreador());
        desa.setVideojuegos(formatVideo.formatListaPlataforma(desarrollador.getVideojuego()));
        return desa;
    }
}
