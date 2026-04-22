package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.exceptions.DeveloperNotFound;
import org.github.dabson10.gamevault.exceptions.DeveloperNameDuplicate;
import org.github.dabson10.gamevault.repository.DesarrolladorRepository;
import org.springframework.stereotype.Service;

@Service
public class DesarrolladorService implements DesarrolladorServiceImp {
    //Inyección de dependencias.
    private final DesarrolladorRepository deRe;
    public DesarrolladorService(DesarrolladorRepository deRe){
        this.deRe = deRe;
    }
    @Override
    public Desarrollador crearDesarrollador(Desarrollador desarrollador) {
        Desarrollador desa = existenciaDesarrollador(desarrollador.getNombre());
        //Si encuentra a una desarrolladora con ese nombre entonces no procede a guardar.
        if(desa != null){
            throw new DeveloperNameDuplicate("Desarrollador existente.");
        }
        deRe.save(desarrollador);
        return desarrollador;
    }

    @Override
    public Desarrollador traerDesarrollador(String nombre) {
        Desarrollador des = this.existenciaDesarrollador(nombre);
        if(des == null){
            throw new DeveloperNotFound("No se encontró el desarrollador.");
        }
        return des;
    }

    @Override
    public Desarrollador existenciaDesarrollador(String nombre) {
        return deRe.findByNombre(nombre);
    }
}
