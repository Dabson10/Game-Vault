package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.exceptions.PlatformDuplicate;
import org.github.dabson10.gamevault.exceptions.PlatformNotFound;
import org.github.dabson10.gamevault.repository.PlataformaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlataformaService implements PlataformaServiceImp{

    //Inyección de dependencias.
    private final PlataformaRepository plaRe;

    //Constructor.
    public PlataformaService(PlataformaRepository plaRe){
        this.plaRe = plaRe;
    }

    @Override
    public Plataforma crearPlataforma(Plataforma plataforma) {
        Plataforma plat = this.existenciaPlataforma(plataforma.getNombrePlataforma());
        if(plat != null){
            throw new PlatformDuplicate("Plataforma existente.");
        }
        plaRe.save(plataforma);
        return plataforma;
    }

    @Override
    public Plataforma buscarPlataforma(String nombrePlataforma) {
        Plataforma plat = this.existenciaPlataforma(nombrePlataforma);
        if(plat == null){
            throw new PlatformNotFound("Plataforma no encontrada.");
        }
        return plat;
    }

    @Override
    public Plataforma existenciaPlataforma(String nombrePlataforma) {
        return plaRe.findByNombrePlataforma(nombrePlataforma);
    }
}
