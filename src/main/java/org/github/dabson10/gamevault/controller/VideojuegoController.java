package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoUpdateDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.service.VideojuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Controlador para crear un videojuego nuevo.
     * @param videojuego : Objeto con el atributo del nuevo juego.
     * @return : Regresará el objeto de videojuego.
     */
    @PostMapping("/create")
    public ResponseEntity<VideojuegoCompletoDTO> crearVideojuego(
            @RequestBody @Valid Videojuego videojuego
    ){
        VideojuegoCompletoDTO vid = viSe.crearVideojuego(videojuego);
        return new ResponseEntity<>(vid, HttpStatus.CREATED);
    }

    /**
     * Controlador que traerá el videojuego con base a su nombre.
     * @param nombre : Nombre del videojuego.
     * @return : Regresará un DTO, Un desarrolladorDTO, y una lista de plataformaDTO.
     */
    @GetMapping("/{nombre}/traer")
    public ResponseEntity<VideojuegoCompletoDTO> traerVideojuego(
            @PathVariable @Valid String nombre
    ){
        VideojuegoCompletoDTO vid = viSe.traerVideojuego(nombre);
        return new ResponseEntity<>(vid, HttpStatus.ACCEPTED);
    }

    /**
     * Controlador para listar todos los videojuegos.
     * @return :Regresa una lista que tiene de valores un DTO,
     * Un desarrolladorDTO, y una lista de plataformaDTO
     */
    @GetMapping("/list")
    public ResponseEntity<List<VideojuegoCompletoDTO>> listarVideojuegos(){
        List<VideojuegoCompletoDTO> videojuegos =  viSe.listarVideojuegos();
        return new ResponseEntity<>(videojuegos, HttpStatus.ACCEPTED);
    }

    /**
     * Este controlador edita
     * @param videojuego
     * @return
     */
    @PatchMapping("/editar")
    public ResponseEntity<VideojuegoCompletoDTO> editarDatosJuego(
            @RequestBody VideojuegoUpdateDTO videojuego
            ){
        VideojuegoCompletoDTO video = viSe.editarVideojuego(videojuego);
        return new ResponseEntity<>(video, HttpStatus.ACCEPTED);
    }

    //Actualiza un videojuego y agrega plataformas.
    @PatchMapping("/plataforma")
    public ResponseEntity<VideojuegoCompletoDTO> agregarPlataforma(
            @Valid @RequestBody VideojuegoPlataformaDTO videoDTO
            ){
        VideojuegoCompletoDTO vid = viSe.agregarPlataforma(videoDTO);
        return new ResponseEntity<>(vid, HttpStatus.ACCEPTED);
    }

    //Actualiza un videojuego y elimina plataformas.
    @PatchMapping("/plataforma/delete")
    public ResponseEntity<VideojuegoCompletoDTO> eliminarPlataformas(
            @Valid @RequestBody VideojuegoPlataformaDTO videoDTO
    ){
        VideojuegoCompletoDTO video = viSe.eliminarPlataforma(videoDTO);
        return new ResponseEntity<>(video, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{nombre}/delete")
    public ResponseEntity<Map<String, String>> eliminarVideojuego(
            @PathVariable String nombre
    ){
        Map<String, String> mapa = new HashMap<>(viSe.eliminarVideojuego(nombre));
        return new ResponseEntity<>(mapa, HttpStatus.ACCEPTED);
    }

}
