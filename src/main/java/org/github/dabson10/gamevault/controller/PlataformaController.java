package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.service.PlataformaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {
    //Inyección de dependencias.
    private final PlataformaService plaSe;

    public PlataformaController(PlataformaService plaSe){
        this.plaSe = plaSe;
    }

    @PostMapping("/create")
    public ResponseEntity<PlataformaNombreDTO> crearPlataforma(
            @RequestBody @Valid PlataformaNombreDTO plata
    ){
        PlataformaNombreDTO plat = plaSe.crearPlataforma(plata);
        return new ResponseEntity<>(plat, HttpStatus.CREATED);
    }

    @GetMapping("/traer")
    public ResponseEntity<PlataformaNombreDTO> traerPlataforma(
            @RequestBody @Valid PlataformaNombreDTO plataforma
    ){
        PlataformaNombreDTO plat = plaSe.buscarPlataforma(plataforma);
        return new ResponseEntity<>(plat, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PlataformaNombreDTO>> listarPlataformas(){
        List<PlataformaNombreDTO> list = plaSe.listarPlataformas();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

//    @GetMapping("/{autor}/list")
//    public ResponseEntity<?> listarJuegosAutores(
//            @PathVariable String nombre
//    ){
//
//    }

}
