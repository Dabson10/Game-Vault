package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.service.VideojuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/juego")
public class VideojuegoController {
    //Inyección de dependencias.
    private final VideojuegoService viSe;

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

}
