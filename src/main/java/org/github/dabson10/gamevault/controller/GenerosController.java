package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.generoDTO.GeneroSimpleDTO;
import org.github.dabson10.gamevault.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/genero")
public class GenerosController {

    private final GeneroService geSe;

    public GenerosController(GeneroService geSe){
        this.geSe = geSe;
    }

    @PostMapping("/create")
    public ResponseEntity<GeneroSimpleDTO> crearGenero(
            @Valid @RequestBody GeneroSimpleDTO genero
    ){
        GeneroSimpleDTO gen = geSe.crearGenero(genero);
        return new ResponseEntity<>(gen,HttpStatus.CREATED);
    }
}
