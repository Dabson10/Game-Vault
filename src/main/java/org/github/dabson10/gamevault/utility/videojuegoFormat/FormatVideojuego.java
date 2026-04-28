package org.github.dabson10.gamevault.utility.videojuegoFormat;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorVideojuegoDTO;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para formatear de un DTO a una clase tipo {@code videojuego}.
 */
@Component
public class FormatVideojuego {
    /**
     * Esta función sirve para convertir de {@code VideojuegoCompletoDTO} a {@code Videojuego},
     * esta función se utiliza en {@code VideojuegoService} en la parte de {@code CrearVideojuego}.
     * @param videoDTO : Aquí se ingresan los datos del videojuego, incluyendo la plataforma y el desarrollador.
     * @return : Regresará el objeto principal {@code videojuego} para poder guardarlo en la base de datos.
     */
    public Videojuego formatVideojuego(VideojuegoCompletoDTO videoDTO){
        //Guardamos los datos fundamentales del videojuego.
        Videojuego video = new Videojuego();
        video.setNombre(videoDTO.getNombre());
        video.setAutor(videoDTO.getAutor());
        video.setDuracion(videoDTO.getDuracion());
        video.setPorcentajeTotal(videoDTO.getPorcentajeTotal());
        video.setLanzado(videoDTO.getLanzado());
        //Guardamos los datos de las relaciones de otras tablas.
        video.setPlataforma(plataformaFormat(videoDTO.getPlataformas()));
        video.setDesarrollador(desarrolladorFormat(videoDTO.getDesarrolladores()));
        return video;
    }

    public List<Plataforma> plataformaFormat(List<PlataformaNombreDTO> plataforma){
        List<Plataforma> plat = new ArrayList<>();
        plataforma.forEach(p -> plat.add(datosPlataforma(p)));
        return plat;
    }

    public Plataforma datosPlataforma( PlataformaNombreDTO plataforma){
        Plataforma plat = new Plataforma();
        plat.setNombrePlataforma(plataforma.getNombrePlataforma());
        return plat;
    }


    public Desarrollador desarrolladorFormat(DesarrolladorVideojuegoDTO desarrollador){
        Desarrollador des = new Desarrollador();
        des.setNombre(desarrollador.getNombre());
        des.setUbicacion(desarrollador.getUbicacion());
        des.setCreador(desarrollador.getCreador());
        return des;
    }







}
