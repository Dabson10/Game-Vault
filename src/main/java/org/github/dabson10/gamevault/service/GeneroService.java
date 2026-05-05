package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.generoDTO.GeneroCompletoDTO;
import org.github.dabson10.gamevault.dto.generoDTO.GeneroSimpleDTO;
import org.github.dabson10.gamevault.entity.Genero;
import org.github.dabson10.gamevault.exceptions.GeneroDuplicateException;
import org.github.dabson10.gamevault.exceptions.GeneroNotFoundException;
import org.github.dabson10.gamevault.repository.GenerosRepository;
import org.github.dabson10.gamevault.utility.generoFormat.GeneroFormatSimple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements GeneroServiceImpl{
    //Inyección de dependencias.

    private final GenerosRepository geRe;
    private final GeneroFormatSimple genFormSimp;

    public GeneroService(GenerosRepository geRe, GeneroFormatSimple genFormSimp){
        this.geRe = geRe;
        this.genFormSimp = genFormSimp;
    }


    @Override
    public GeneroSimpleDTO crearGenero(GeneroSimpleDTO genero) {
        Genero gen = this.existenciaGenero(genero.getGenero());
        if(gen != null){
            //Si encuentrá un género que coincida con el nombre, entonces regresamos
            throw new GeneroDuplicateException("Genero existente. Ingrese otro.");
        }
        //Ahora que el objeto es null toca guardarlo sin antes formatearlo de
        //DTO a Objeto principal.
        gen = geRe.save(genFormSimp.formatDataSimple(genero));
        return genFormSimp.formatDataSimpleDTO(gen);
    }

    @Override
    public List<GeneroCompletoDTO> buscarVideojuegosConGeneros(List<String> generos) {
        //Traemos a los generos que coincidan
        List<Genero> listGenero = geRe.findByGeneroIn(generos);
        if(listGenero.isEmpty()){
            //Si la lista está vacía entonces regresamos una excepción.
            throw new GeneroNotFoundException("No se encontrarón los géneros.");
        }
        //Ahora formatearemos la lista del objeto en un DTO o GeneroCompletoDTO
        return List.of();
    }

    @Override
    public Genero existenciaGenero(String genero) {
        return geRe.findByGenero(genero);
    }
}
