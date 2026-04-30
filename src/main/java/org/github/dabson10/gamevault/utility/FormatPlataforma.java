package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.dto.PlataformaDTO.PlataformaNombreDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormatPlataforma {

    //Formatear un DTO de parte de Videojuego-Plataforma
    public List<PlataformaNombreDTO> formatLista(List<Plataforma> plataforma){
        List<PlataformaNombreDTO> listaFormat = new ArrayList<>();
        plataforma.forEach(plat ->{
            listaFormat.add(formatData(plat));
        });
        return listaFormat;
    }

    public PlataformaNombreDTO formatData(Plataforma plataforma){
        PlataformaNombreDTO plDTO = new PlataformaNombreDTO();
        plDTO.setIdPlataforma(plataforma.getIdPlataforma());
        plDTO.setNombrePlataforma(plataforma.getNombrePlataforma());
        return plDTO;
    }
}
