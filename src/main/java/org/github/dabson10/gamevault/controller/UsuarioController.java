package org.github.dabson10.gamevault.controller;

import jakarta.validation.Valid;
import org.github.dabson10.gamevault.dto.usuarioDTO.UsuarioCredencialDTO;
import org.github.dabson10.gamevault.dto.usuarioDTO.UsuarioDTO;
import org.github.dabson10.gamevault.entity.Usuario;
import org.github.dabson10.gamevault.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuSe;

    //Inyección de dependencias.
    public UsuarioController(UsuarioService usuSe) {
        this.usuSe = usuSe;
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioDTO> crearUsuario(
            @Valid @RequestBody Usuario usuario
    ) {
        //Mandamos el usuario al service y esperamos que guarde al usuario.
        UsuarioDTO usu = usuSe.crearUsuario(usuario);
        return new ResponseEntity<>(usu, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<UsuarioDTO> traerUsuario(
            @Valid @RequestBody UsuarioCredencialDTO credencial
            ){
         UsuarioDTO usuario = usuSe.loginUsuario(credencial);
         return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }


}
