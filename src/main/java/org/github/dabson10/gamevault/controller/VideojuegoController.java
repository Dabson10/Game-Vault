package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoDTO;
import org.github.dabson10.gamevault.dto.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.service.VideojuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/juego")
public class VideojuegoController {
    //Inyección de dependencias.
    private final VideojuegoService viSe;
    private static final Logger log = LoggerFactory.getLogger(VideojuegoController.class);
    public VideojuegoController(VideojuegoService viSe){
        this.viSe = viSe;
    }

    //Controladores.

    @PostMapping("/create")
    public ResponseEntity<?> crearVideojuego(
            @RequestBody @Valid Videojuego videojuego
    ){
        Videojuego vid = viSe.crearVideojuego(videojuego);
        return new ResponseEntity<>(vid, HttpStatus.CREATED);
    }

    @GetMapping("/{nombre}/traer")
    public ResponseEntity<?> traerUsuario(
            @PathVariable @Valid String nombre
    ){
        Videojuego vid = viSe.traerVideojuego(nombre);
        return new ResponseEntity<>(vid, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<VideojuegoCompletoDTO>> listarVideojuegos(){
        List<VideojuegoCompletoDTO> videojuegos =  viSe.listarVideojuegos();
        return new ResponseEntity<>(videojuegos, HttpStatus.ACCEPTED);
    }

    //Actualiza un videojuego y agrega cambios en la lista de plataforma.
    @PutMapping("/plataforma")
    public ResponseEntity<?> agregarPlataforma(
            @Valid @RequestBody VideojuegoPlataformaDTO videoDTO
            ){
        log.warn("El nombre del objeto es: {}, y las plataformas son: {}",videoDTO.getNombre(), videoDTO.getPlataforma() );
        VideojuegoCompletoDTO vid = viSe.agregarPlataforma(videoDTO);
        return new ResponseEntity<>(vid, HttpStatus.ACCEPTED);
    }
}
