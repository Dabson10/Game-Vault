package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.service.PlataformaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {
    //Inyección de dependencias.
    private final PlataformaService plaSe;

    public PlataformaController(PlataformaService plaSe){
        this.plaSe = plaSe;
    }

    /**
     * Controller para crear nuevas plataformas con base a su nombre.
     * @param plata : DTO que solo contiene el ID de la plataforma y el nombre de esta.
     * @return : Regresará el mismo DTO, solo que con el ID de la plataforma.
     */
    @PostMapping("/create")
    public ResponseEntity<PlataformaNombreDTO> crearPlataforma(
            @RequestBody @Valid PlataformaNombreDTO plata
    ){
        PlataformaNombreDTO plat = plaSe.crearPlataforma(plata);
        return new ResponseEntity<>(plat, HttpStatus.CREATED);
    }

    /**
     * Controller para traer a una plataforma mediante su nombre.
     * @param plataforma : Objeto plataforma que cuenta con el ID y nombre de la plataforma
     * @return : Regresará el valor de base de datos.
     */
    @GetMapping("/traer")
    public ResponseEntity<PlataformaNombreDTO> traerPlataforma(
            @RequestBody @Valid PlataformaNombreDTO plataforma
    ){
        PlataformaNombreDTO plat = plaSe.buscarPlataforma(plataforma);
        return new ResponseEntity<>(plat, HttpStatus.ACCEPTED);
    }

    /**
     * Controller que traerá todas las plataformas de la base de datos, cabe decir
     * que solo traerá los nombres e ID.
     * @return : Regresará solo el nombre de la plataforma e iD.
     */
    @GetMapping("/list")
    public ResponseEntity<List<PlataformaNombreDTO>> listarPlataformas(){
        List<PlataformaNombreDTO> list = plaSe.listarPlataformas();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    /**
     * Controller que buscara y listara a todas las plataformas que no tienen un videojuego enlazado.
     * @return : Traerá solo el ID y el nombre de la plataforma.
     */
    @GetMapping("/list/vacios")
    public ResponseEntity<List<PlataformaNombreDTO>> listarJuegosAutores(){
        List<PlataformaNombreDTO> list = plaSe.listarSinUsar();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    /**
     * Este controller lo que hará es contar cuantas plataformas no tiene videojuegos asociados.
     * @return : Regresará un mapa con la cantidad de plataformas sin videojuegos.
     */
    @GetMapping("/count/vacios")
    public ResponseEntity<Map<String, Long>> cantidadVacios(){
        Map<String, Long> mapa = new HashMap<>();
        mapa.put("Sin videojuegos.", plaSe.cantSinUsar());
        return new ResponseEntity<>(mapa, HttpStatus.ACCEPTED);
    }

}
