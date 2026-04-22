package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.service.PlataformaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {
    //Inyección de dependencias.
    private final PlataformaService plaSe;

    public PlataformaController(PlataformaService plaSe){
        this.plaSe = plaSe;
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearPlataforma(
            @RequestBody @Valid Plataforma plata
    ){
        Plataforma plat = plaSe.crearPlataforma(plata);
        return new ResponseEntity<>(plat, HttpStatus.CREATED);
    }

    @GetMapping("/{nombre}/traer")
    public ResponseEntity<?> traerPlataforma(
            @PathVariable @Valid String nombre
    ){
        Plataforma plat = plaSe.buscarPlataforma(nombre);
        return new ResponseEntity<>(plat, HttpStatus.ACCEPTED);
    }

}
