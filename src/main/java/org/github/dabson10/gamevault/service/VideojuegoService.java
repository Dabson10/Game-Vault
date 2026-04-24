package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.exceptions.VideojuegoDuplicate;
import org.github.dabson10.gamevault.exceptions.VideojuegoNotFound;
import org.github.dabson10.gamevault.repository.VideojuegoRepository;
import org.github.dabson10.gamevault.utility.CombinarListas;
import org.github.dabson10.gamevault.utility.FormatVideojuego;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService implements VideojuegoServiceImp {
    //Inyección de dependencias.
    private final VideojuegoRepository viRe;
    private final FormatVideojuego videoFormat;
    private final CombinarListas combListas;


    //Constructor
    public VideojuegoService(VideojuegoRepository viSe, FormatVideojuego videoFormat, CombinarListas combListas){
        this.viRe = viSe;
        this.videoFormat = videoFormat;
        this.combListas = combListas;
    }
    @Override
    public Videojuego crearVideojuego(Videojuego videojuego) {
        Videojuego vid = this.existenciaVideojuego(videojuego.getNombre());
        if(vid != null){
            throw new VideojuegoDuplicate("Videojuego existente.");
        }
        viRe.save(videojuego);
        return videojuego;
    }

    @Override
    public Videojuego traerVideojuego(String nombre) {
        Videojuego vid = this.existenciaVideojuego(nombre);
        if(vid == null){
            throw new VideojuegoNotFound("Videojuego no existente.");
        }
        return vid;
    }

    @Override
    public VideojuegoCompletoDTO agregarPlataforma(VideojuegoPlataformaDTO videojuego) {

        Videojuego video = this.traerVideojuego(videojuego.getNombre());
        if(video == null){
            throw new VideojuegoNotFound("No se encontró el videojuego.");
        }
        //Si se encontró el videojuego entonces lo que haremos es combinar la lista de colecciones de ambas
        List<Plataforma> plat = combListas.combinarColeccionVideojuegos(
                video.getPlataforma(), videojuego.getPlataforma());

        video.getPlataforma().clear();

        video.getPlataforma().addAll(plat);
        viRe.save(video);
        //En esta parte realizo el formato para regresar el objeto de VideojuegoCompletoDTO.
        return videoFormat.formatData(video);
    }

    @Override
    public List<VideojuegoCompletoDTO> listarVideojuegos() {
        //Obtenemos la lista con los videojuegos totales.
        List<Videojuego> video = viRe.findAll();
        //Regresamos una lista con los videojuegos formateados.
        return videoFormat.formatLista(video);
    }

    @Override
    public Videojuego existenciaVideojuego(String nombre) {
        return viRe.findByNombre(nombre);
    }
}
