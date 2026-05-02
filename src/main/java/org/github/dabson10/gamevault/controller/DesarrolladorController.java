package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorSimpleDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.service.DesarrolladorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desarrollador")
public class DesarrolladorController {

    //Inyección de dependencias.
    private final DesarrolladorService deSe;

    public DesarrolladorController(DesarrolladorService deSe){
        this.deSe = deSe;
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearDesarrollador(
            @Valid @RequestBody DesarrolladorSimpleDTO des){
         deSe.crearDesarrollador(des);
         return new ResponseEntity<>(des, HttpStatus.CREATED);
    }
    @GetMapping("/{nombre}/traer")
    public ResponseEntity<?> buscarDesarrollador(
            @PathVariable @Valid String nombre
    ){
        Desarrollador des = deSe.traerDesarrollador(nombre);
        return new ResponseEntity<>(des, HttpStatus.ACCEPTED);
    }
    //Arregla la forma en la que jalas los datos en forma de lista, usando DTO.
    @GetMapping("/list")
    public ResponseEntity<List<DesarrolladorDTO>> listarDesarrolladores(){
        List<DesarrolladorDTO> lista = deSe.listaDesarrollador();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
