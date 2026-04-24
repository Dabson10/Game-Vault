package org.github.dabson10.gamevault.utility;

import org.github.dabson10.gamevault.entity.Plataforma;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CombinarListas {
    /**
     * Esta función sirve para fusionar dos listas en una, sin repetir coincidencias.
     * @param plataformaVideo
     * @param plataformasVideoDTO
     * @return
     */
    public List<Plataforma> combinarColeccionVideojuegos(
            List<Plataforma> plataformaVideo, List<Plataforma> plataformasVideoDTO){
        Map<String, Plataforma> mapa = new HashMap<>();
        //Recorre el array que estaba en la base de datos y los guarda en un mapa.
        plataformaVideo.forEach(video -> {
            mapa.put(video.getNombrePlataforma(), video);
        });
        //Se recorre la segunda lista y se busca en el mapa los valores de la segunda lista,
        // si esta entonces no guardamos si no guardamos.
        plataformasVideoDTO.forEach(videoDTO ->{
            //putIfAbsent : Sirve para guardar cuando una llave no existe,
            //si existe entonces no guarda el valor, conserva el inicial.
            mapa.putIfAbsent(videoDTO.getNombrePlataforma(), videoDTO);
        });

        plataformaVideo.clear();
        plataformaVideo.addAll(mapa.values());
        return plataformaVideo;
    }
}
