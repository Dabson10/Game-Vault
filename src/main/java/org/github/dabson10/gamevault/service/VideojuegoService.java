package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.exceptions.VideojuegoDuplicate;
import org.github.dabson10.gamevault.exceptions.VideojuegoNotFound;
import org.github.dabson10.gamevault.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService implements VideojuegoServiceImp {
    //Inyección de dependencias.
    private final VideojuegoRepository viRe;


    //Constructor
    public VideojuegoService(VideojuegoRepository viSe){
        this.viRe = viSe;
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
    public Videojuego existenciaVideojuego(String nombre) {
        return viRe.findByNombre(nombre);
    }
}
