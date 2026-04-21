package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.repository.PlataformaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlataformaService implements PlataformaServiceImp{

    //Inyección de dependencias.
    private final PlataformaRepository plaRe;

    public PlataformaService(PlataformaRepository plaRe){
        this.plaRe = plaRe;
    }

    @Override
    public Plataforma crearPlataforma(Plataforma plataforma) {
        return null;
    }
}
