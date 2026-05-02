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
    private final PlataformaFormat formPlatform;
    private final Logger log = LoggerFactory.getLogger(PlataformaService.class);

    //Constructor.
    public PlataformaService(PlataformaRepository plaRe, PlataformaFormat formPlatform){
        this.plaRe = plaRe;
        this.formPlatform = formPlatform;
    }

    @Override
    public PlataformaNombreDTO crearPlataforma(PlataformaNombreDTO plataforma) {
        Plataforma plat = this.existenciaPlataforma(plataforma.getNombrePlataforma());
        if(plat != null){
            throw new PlatformDuplicate("Plataforma existente.");
        }
        plat =  plaRe.save(formPlatform.platformDataDTO(plataforma));
        plataforma.setIdPlataforma(plat.getIdPlataforma());
        return plataforma;
    }

    @Override
    public PlataformaNombreDTO buscarPlataforma(PlataformaNombreDTO plataforma) {
        Plataforma plat = this.existenciaPlataforma(plataforma.getNombrePlataforma());
        if(plat == null){
            throw new PlatformNotFound("Plataforma no encontrada.");
        }
        return formPlatform.platformData(plat);
    }

    /**
     * Este service es para listar todas las plataformas existentes, no es necesario saber
     * si tiene videojuegos asociados solo el nombre e ID.
     * @return : Lista con objetos.
     */
    @Override
    public List<PlataformaNombreDTO> listarPlataformas() {
        List<Plataforma> listPlat = plaRe.findAll();
        return formPlatform.formatList(listPlat);
    }

    /**
     * Este Service es para listas todas las plataformas que no tienen un videojuego asociado.
     * @return : Regresará una lista con un json u objeto con solo nombre e ID.
     */
    @Override
    public List<PlataformaNombreDTO> listarSinUsar() {
        List<Plataforma> plat = plaRe.findByVideojuegosIsEmpty();
        return formPlatform.formatList(plat);
    }

    /**
     * Este service es para contar la cantidad de plataformas sin videojuegos.
     * @return : Regresará un Long que es la cantidad de plataformas sin usuarios.
     */
    @Override
    public Long cantSinUsar() {
        return plaRe.countByVideojuegosEmpty();
    }

    /**
     * Este service es para saber si existe una plataforma, este regresará el objeto
     * ya sea con un objeto o un null
     * @param nombrePlataforma : Nombre de la plataforma
     * @return : Regresará un objeto con valores o un null, esto lo jala de la base de datos.
     */
    @Override
    public Plataforma existenciaPlataforma(String nombrePlataforma) {
        return plaRe.findByNombrePlataforma(nombrePlataforma);
    }
}
