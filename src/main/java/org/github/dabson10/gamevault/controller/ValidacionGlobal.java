package org.github.dabson10.gamevault.controller;

import org.github.dabson10.gamevault.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//Esta annotation sirve para capturarlas exceptions de todos los controladores.
@RestControllerAdvice
public class ValidacionGlobal {
    /**
     * Lo que hace esta función es si recibimos algún valor que no corresponde con las validaciones
     * de las entidades, muestra el mensaje de la validación que no se cumplió
     * @param ex : Este parámetro proviene del un objeto del tipo {@code MethodArgumentNotValidException},
     *           el cual captura las exception de las validaciones no cumplidas
     * @return : Regresará un JSON el cual tendrá de parámetro el valor en donde surgió el error y en valor el mismo error.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String> > manejoExcepciones(
            MethodArgumentNotValidException ex){
        Map<String, String > errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
    /*
     *Las siguientes funciones son para capturar exception de manera global, para que
     * en los controller no tener que utilizar try-catch y hacer más simple el manejo de
     * exceptions.
     * */

    /**
     * Esta funcion captura y manda un mensaje cuando se manejan
     * por ejemplo creaciones de cuentas y se encuentra el correo ya registrado.
     * @param email : Excepción
     * @return : Regresa un mensaje con la exception
     */
    @ExceptionHandler(EmailDuplicateException.class)
    public ResponseEntity<Map<String, String>> correoDuplicado(
            EmailDuplicateException email
    ){
        Map<String, String> error = new HashMap<>();
        error.put(email.getClass().getSimpleName(), email.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
    //Correo no encontrado.
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<Map<String, String>> correoNoEncontrado(
            EmailNotFoundException email
    ){
        Map<String, String> error = new HashMap<>();
        error.put(email.getClass().getSimpleName(), email.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
    //Contraseña incorrecta.
    @ExceptionHandler({IncorrectPasswordException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, String>> claveIncorrecta(
            IncorrectPasswordException pass
    ){
        Map<String, String> error = new HashMap<>();
        error.put(pass.getClass().getSimpleName(), pass.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
    //======================================
    //    Sección Desarrollador
    //Desarrollador existente.

    @ExceptionHandler(DeveloperNameDuplicate.class)
    public ResponseEntity<Map<String, String>> desarrolladorDuplicado(
            DeveloperNameDuplicate name
    ){
        Map<String, String> error = new HashMap<>();
        error.put(name.getClass().getSimpleName(), name.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
    //Validación de desarrollador no existente.
    @ExceptionHandler(DeveloperNotFound.class)
    public ResponseEntity<Map<String, String>> desarrolladorNoExistente(
            DeveloperNotFound des
    ){
        Map<String, String> error = new HashMap<>();
        error.put(des.getClass().getSimpleName(), des.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    //============================================
    //         Excepciones de Plataforma
    @ExceptionHandler(PlatformDuplicate.class)
    public ResponseEntity<Map<String, String>> plataformaDuplicada(
            PlatformDuplicate pd
    ){
        Map<String, String> error = new HashMap<>();
        error.put(pd.getClass().getSimpleName(), pd.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

}
