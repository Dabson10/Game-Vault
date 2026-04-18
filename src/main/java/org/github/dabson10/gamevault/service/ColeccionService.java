package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.repository.ColeccionRepository;
import org.springframework.stereotype.Service;

@Service
public class ColeccionService implements ColeccionServiceImp {
    private final ColeccionRepository coRe;

    public ColeccionService(ColeccionRepository coRe){
        this.coRe = coRe;
    }
    @Override
    public void crearColeccion() {

    }
}
