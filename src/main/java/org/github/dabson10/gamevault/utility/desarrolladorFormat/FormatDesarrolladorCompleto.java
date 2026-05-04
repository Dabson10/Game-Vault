package org.github.dabson10.gamevault.utility.desarrolladorFormat;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorCompletoDTO;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformasDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class FormatDesarrolladorCompleto {


    public DesarrolladorCompletoDTO  formDataDesarrolladorCompletoDTO(Desarrollador desarrollador){
        DesarrolladorCompletoDTO des = new DesarrolladorCompletoDTO();
        des.setIdDesarrollador(desarrollador.getIdDesarrollador());
        des.setNombre(desarrollador.getNombre());
        des.setUbicacion(desarrollador.getUbicacion());
        des.setCreador(desarrollador.getCreador());
        //Ahora llamamos a una función para que formatee los datos de Videojuego a VideojuegoPlataformasDTO
        des.setVideojuego(this.formatListaPlataforma(desarrollador.getVideojuego()));
        return des;
    }



    /**
     * Comprobaremos despues si estas funciones son necesarias si no eliminamos.
     * @param videojuego
     * @return
     */
    public List<VideojuegoPlataformasDTO> formatListaPlataforma(List<Videojuego> videojuego){
        List<VideojuegoPlataformasDTO> list = new ArrayList<>();
        videojuego.forEach(video -> {
            list.add(this.formatDataPlataforma(video));
        });
        return list;
    }

    public VideojuegoPlataformasDTO formatDataPlataforma(Videojuego video){
        VideojuegoPlataformasDTO viPla = new VideojuegoPlataformasDTO();
        viPla.setIdVideojuego(video.getIdVideojuego());
        viPla.setNombre(video.getNombre());
        viPla.setAutor(video.getAutor());
        viPla.setDuracion(video.getDuracion());
        viPla.setPorcentajeTotal(video.getPorcentajeTotal());
        viPla.setLanzado(video.getLanzado());
        viPla.setPlataformas(plataformaVideo(video.getPlataforma()));
        return viPla;
    }

    public List<PlataformaNombreDTO> plataformaVideo(List<Plataforma> plataforma) {
        List<PlataformaNombreDTO> listaN = new ArrayList<>();
        plataforma.forEach( plat ->{
            listaN.add(datosPlatform(plat));
        });
        return listaN;
    }

    public PlataformaNombreDTO datosPlatform(Plataforma plat){
        PlataformaNombreDTO dato = new PlataformaNombreDTO();
        dato.setIdPlataforma(plat.getIdPlataforma());
        dato.setNombrePlataforma(plat.getNombrePlataforma());
        return dato;
    }




}
