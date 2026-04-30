package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.exceptions.PlatformDuplicate;
import org.github.dabson10.gamevault.exceptions.PlatformNotFound;
import org.github.dabson10.gamevault.repository.PlataformaRepository;
import org.github.dabson10.gamevault.utility.plataformaFormat.PlataformaFormat;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@Service
public class PlataformaService implements PlataformaServiceImp{

    //Inyección de dependencias.
    private final PlataformaRepository plaRe;
    private final PlataformaFormat formPlatfor;
    private final Logger log = LoggerFactory.getLogger(PlataformaService.class);

    //Constructor.
    public PlataformaService(PlataformaRepository plaRe, PlataformaFormat formPlatfor){
        this.plaRe = plaRe;
        this.formPlatfor = formPlatfor;
    }

    @Override
    public PlataformaNombreDTO crearPlataforma(PlataformaNombreDTO plataforma) {
        Plataforma plat = this.existenciaPlataforma(plataforma.getNombrePlataforma());
        if(plat != null){
            throw new PlatformDuplicate("Plataforma existente.");
        }
        plat =  plaRe.save(formPlatfor.platformDataDTO(plataforma));
        plataforma.setIdPlataforma(plat.getIdPlataforma());
        return plataforma;
    }

    @Override
    public PlataformaNombreDTO buscarPlataforma(PlataformaNombreDTO plataforma) {
        Plataforma plat = this.existenciaPlataforma(plataforma.getNombrePlataforma());
        if(plat == null){
            throw new PlatformNotFound("Plataforma no encontrada.");
        }
        PlataformaNombreDTO platDTO = formPlatfor.platformData(plat);
        return platDTO;
    }

    @Override
    public List<PlataformaNombreDTO> listarPlataformas() {
        List<Plataforma> listPlat = plaRe.findAll();
        return formPlatfor.formatList(listPlat);
    }

    @Override
    public void listarPorAutor(String nombre) {
        List<Plataforma> plataformas ;

    }

    @Override
    public Plataforma existenciaPlataforma(String nombrePlataforma) {
        return plaRe.findByNombrePlataforma(nombrePlataforma);
    }
}
