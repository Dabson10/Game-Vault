package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.exceptions.DeveloperNotFound;
import org.github.dabson10.gamevault.exceptions.DeveloperNameDuplicate;
import org.github.dabson10.gamevault.repository.DesarrolladorRepository;
import org.github.dabson10.gamevault.utility.FormatDesarrollador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesarrolladorService implements DesarrolladorServiceImp {
    //Inyección de dependencias.
    private final DesarrolladorRepository deRe;
    private final FormatDesarrollador formatDes;

    public DesarrolladorService(DesarrolladorRepository deRe, FormatDesarrollador formatDesarrollador){
        this.deRe = deRe;
        this.formatDes = formatDesarrollador;
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

    @Override
    public List<DesarrolladorDTO> listaDesarrollador() {
        return formatDes.formatLista(deRe.findAll());
    }
}
