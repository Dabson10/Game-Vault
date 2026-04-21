package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.service.DesarrolladorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @Valid @RequestBody Desarrollador des){
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
}
