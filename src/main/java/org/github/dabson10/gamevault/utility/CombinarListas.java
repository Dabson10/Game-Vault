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
     * @param plataformaVideo : Lista de las plataformas que tiene el juego. Los valores provienen de la base de datos.
     * @param plataformasVideoDTO : Lista de las nuevas plataformas que se le quieren agregar al juego.
     * @return : Si la lista ingresada en su totalidad son duplicados entonces regresa una lista vacía.
     *           Si se agregó al menos 1 valor nuevo al mapa entonces regresa una lista con los valores que se agregaran sin
     *           repetidos.
     */
    public List<Plataforma> combinarColeccionVideojuegos(
                List<Plataforma> plataformaVideo, List<Plataforma> plataformasVideoDTO){

        Map<Long, Plataforma> mapa = new HashMap<>();
        //Recorre el array que estaba en la base de datos y los guarda en un mapa.
        plataformaVideo.forEach(video -> {
            mapa.put(video.getIdPlataforma(), video);
        });
        //Cuenta cuantos valores inicialmente tendrá el mapa.
        int cantidadMap = mapa.size();
        //Se recorre la segunda lista y se busca en el mapa los valores de la segunda lista,
        // si esta entonces no guardamos si no guardamos.
        plataformasVideoDTO.forEach(videoDTO ->{
            //putIfAbsent: Sirve para guardar cuando una llave no existe,
            //si existe entonces no guarda el valor, conserva el inicial.
            mapa.putIfAbsent(videoDTO.getIdPlataforma(), videoDTO);
        });
        //Ahora teniendo en el mapa los valores que son diferentes, toca hacer una validación
        plataformaVideo.clear();
        //Si el mapa tiene el mismo tamaño de cuando se agregaron los valores
        //que se obtuvieron en la base de datos entonces regresa una lista vacía.
        if(cantidadMap == mapa.size()){
            return plataformaVideo;
        }
        plataformaVideo.addAll(mapa.values());
        plataformaVideo.forEach(p ->{
            System.out.println(" perro: " + p.toString());
        });
        return plataformaVideo;
    }

    /**
     * Función para borrar plataformas que existen en algún videojuego.
     * @param video : Lista con plataformas que provienen de la base de datos.
     * @param videoDTO : Lista con plataformas ingresadas.
     * @return : Regresará una lista que se limpió y se agregaron los datos fundamentales.
     */
    public List<Plataforma> borrarIguales(List<Plataforma> video, List<Plataforma> videoDTO){
        Map<Long, Plataforma> mapa = new HashMap<>();
        //Guardamos en el mapa los valores obtenidos de la base de datos
        video.forEach(vid -> {
            mapa.put(vid.getIdPlataforma(), vid);
        });
        //Contamos la cantidad inicial de los valores en el mapa.
        int cantidadMapa = mapa.size();
        //Ahora borraremos los valores que coinciden.
        videoDTO.forEach(vid ->{
            mapa.remove(vid.getIdPlataforma());
        });
        //Ahora validaremos que se realizaron cambios mas que nada para no guardar nada
        //en la base de datos.
        if(cantidadMapa == mapa.size()){
            return video;
        }
        video.clear();
        //Ahora en la lista de la base de datos guardamos los valores con los datos borrados.
        video.addAll(mapa.values());
        return video;
    }

}
