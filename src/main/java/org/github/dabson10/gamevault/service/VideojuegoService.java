package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCompletoDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoNombreDTO;
import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoPlataformaDTO;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.exceptions.PlatformDuplicate;
import org.github.dabson10.gamevault.exceptions.PlatformsNotDeletedException;
import org.github.dabson10.gamevault.exceptions.VideojuegoDuplicate;
import org.github.dabson10.gamevault.exceptions.VideojuegoNotFound;
import org.github.dabson10.gamevault.repository.VideojuegoRepository;
import org.github.dabson10.gamevault.utility.CombinarListas;
import org.github.dabson10.gamevault.utility.FormatVideojuegoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VideojuegoService implements VideojuegoServiceImp {
    //Inyección de dependencias.
    private final VideojuegoRepository viRe;
    private final FormatVideojuegoDTO videoFormat;
    private final CombinarListas combListas;


    //Constructor
    public VideojuegoService(VideojuegoRepository viSe, FormatVideojuegoDTO videoFormat, CombinarListas combListas){
        this.viRe = viSe;
        this.videoFormat = videoFormat;
        this.combListas = combListas;
    }

    /**
     * Función para crear solamente un videojuego sin crear colecciones incluyendo
     * las plataformas a las que pertenece.
     * @param videojuego : Objeto con los datos que se guardaran.
     * @return : Regresará el mismo objeto, confirmando que se guardarón.
     */
    @Override
    public Videojuego crearVideojuego(Videojuego videojuego) {
        Videojuego vid = this.existenciaVideojuego(videojuego.getNombre());
        if(vid != null){
            throw new VideojuegoDuplicate("Videojuego existente.");
        }
        viRe.save(videojuego);
        return videojuego;
    }

    /**
     * Función para buscar un videojuego mediante su nombre
     * @param nombre : Nombre del videojuego.
     * @return : Regresara un DTO de la clase videojuego para que no exista
     *          ningún error o bucle de datos.
     */
    @Override
    public VideojuegoCompletoDTO traerVideojuego(String nombre) {
        Videojuego vid = this.existenciaVideojuego(nombre);
        if(vid == null){
            throw new VideojuegoNotFound("Videojuego no existente.");
        }
        //Ahora teniendo el videojuego lo formateamos a la clase VideojuegoCompleto
        return videoFormat.formatDataVideojuego(vid);
    }

    @Override
    public VideojuegoCompletoDTO editarVideojuego(VideojuegoNombreDTO video) {
        Videojuego videoJ = this.existenciaVideojuego(video.getNombre());
        if(videoJ == null){
            //Si es null es por que no se encontró.
            throw new VideojuegoNotFound("No se encontró el videojuego.");
        }
        //Ahora realizamos el cambio de nombre
        videoJ.setNombre(video.getNombreNuevo());
        viRe.save(videoJ);
        return videoFormat.formatDataVideojuego(videoJ);
    }

    /**
     * Función para que a un videojuego se le agreguen plataformas nuevas.
     * @param videojuego : Este objeto DTO es la fusion del nombre del juego y
     *                   la una lista de plataformas nuevas que se agregaran.
     * @return : Regresará un DTO con datos del videojuego completo.
     */
    @Override
    public VideojuegoCompletoDTO agregarPlataforma(VideojuegoPlataformaDTO videojuego) {

        Videojuego video = this.existenciaVideojuego(videojuego.getNombre());
        //Validamos que exista el videojuego.
        if(video == null){
            throw new VideojuegoNotFound("No se encontró el videojuego.");
        }

        //Guardamos en una lista los valores combinados de la lista plataforma,
        //en una lista que guardara datos de una función en donde pasaremos la primera lista
        List<Plataforma> plat = new ArrayList<>( combListas.combinarColeccionVideojuegos(
                video.getPlataforma(), videojuego.getPlataforma()));


        //Validamos que no se repitan datos.
        if(plat.isEmpty()){
            //Si esta vacía significa que se repitieron plataformas.
            throw new PlatformDuplicate("Plataformas existentes, agregue otras.");
        }
        video.getPlataforma().clear();
        video.getPlataforma().addAll(plat);

        viRe.save(video);//Esperamos a tener bien la lógica antes de guardar.
        //En esta parte realizo el formato para regresar el objeto de VideojuegoCompletoDTO.
        return videoFormat.formatDataVideojuego(video);
    }

    /**
     * Función para eliminar plataformas de las ya existentes.
     * @param videoDTO : Este objeto DTO es la fusion del nombre del juego y
     *                  la una lista de plataformas nuevas que se agregaran.
     * @return : Regresara el objeto en DTO para que no exista datos duplicados.
     */
    @Override
    public VideojuegoCompletoDTO eliminarPlataforma(VideojuegoPlataformaDTO videoDTO) {
        Videojuego video = this.existenciaVideojuego(videoDTO.getNombre());
        if(video == null){
            throw new VideojuegoNotFound("Videojuego no encontrado.");
        }
        List<Plataforma> plat = new ArrayList<>
                (combListas.borrarIguales(video.getPlataforma(), videoDTO.getPlataforma()));

        if(video.getPlataforma().size() < plat.size()){
            //Si la lista regresa vacía entonces regresamos una excepción.
            throw new PlatformsNotDeletedException("Las plataformas ingresadas no coinciden con las guardadas.");
        }
        video.getPlataforma().clear();
        video.getPlataforma().addAll(plat);
        viRe.save(video);
        return videoFormat.formatDataVideojuego(video);
    }

    @Override
    public Map<String, String> eliminarVideojuego(String nombre) {
        Videojuego video = this.existenciaVideojuego(nombre);
        if(video == null){
            throw new VideojuegoNotFound("No se encontró el videojuego.");
        }

        viRe.delete(video);
        return Map.of("Message", (nombre + ", se elimino correctamente."));
    }

    /**
     * Función para listar todos los videojuegos.
     * @return : Regresará una lista de todos los videojuegos en DTO.
     */
    @Override
    public List<VideojuegoCompletoDTO> listarVideojuegos() {
        //Obtenemos la lista con los videojuegos totales.
        List<Videojuego> video = viRe.findAll();
        //Regresamos una lista con los videojuegos formateados.
        return videoFormat.formatListaVideojuego(video);
    }

    @Override
    public Videojuego existenciaVideojuego(String nombre) {
        return viRe.findByNombre(nombre);
    }
}
