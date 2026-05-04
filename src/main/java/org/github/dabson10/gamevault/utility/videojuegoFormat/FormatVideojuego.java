package org.github.dabson10.gamevault.utility.videojuegoFormat;

import org.github.dabson10.gamevault.dto.videojuegoDTO.VideojuegoCreateDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.entity.Plataforma;
import org.github.dabson10.gamevault.entity.Videojuego;
import org.github.dabson10.gamevault.exceptions.DeveloperNotFound;
import org.github.dabson10.gamevault.exceptions.PlatformNotFound;
import org.github.dabson10.gamevault.repository.DesarrolladorRepository;
import org.github.dabson10.gamevault.repository.PlataformaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para formatear de un DTO a una clase tipo
 * {@code videojuego}.
 */
@Component
public class FormatVideojuego {

    private final PlataformaRepository plaRe;
    private final DesarrolladorRepository deRe;

    public FormatVideojuego(PlataformaRepository plaRe, DesarrolladorRepository deRe) {
        this.plaRe = plaRe;
        this.deRe = deRe;
    }

    /**
     * Esta función sirve para convertir de {@code VideojuegoCompletoDTO} a
     * {@code Videojuego},
     * esta función se utiliza en {@code VideojuegoService} en la parte de
     * {@code CrearVideojuego}.
     * 
     * @param videoDTO : Aquí se ingresan los datos del videojuego, incluyendo la
     *                 plataforma y el desarrollador.
     * @return : Regresará el objeto principal {@code videojuego} para poder
     *         guardarlo en la base de datos.
     */
    public Videojuego formatVideojuego(VideojuegoCreateDTO videoDTO) {
        // Guardamos los datos fundamentales del videojuego.
        Videojuego video = new Videojuego();
        video.setNombre(videoDTO.getNombre());
        video.setAutor(videoDTO.getAutor());
        video.setDuracion(videoDTO.getDuracion());
        video.setPorcentajeTotal(videoDTO.getPorcentajeTotal());
        video.setLanzado(videoDTO.getLanzado());
        // Guardamos los datos de las relaciones de otras tablas.
        video.setPlataforma(plataformaFormat(videoDTO.getPlataformas()));
        video.setDesarrollador(desarrolladorFormat(videoDTO.getIdDesarrollador()));
        return video;
    }

    public List<Plataforma> plataformaFormat(List<Long> plataforma) {
        List<Plataforma> plat = new ArrayList<>();
        plataforma.forEach(p -> plat.add(datosPlataforma(p)));
        return plat;
    }

    public Plataforma datosPlataforma(Long idPlataforma) {
        return plaRe.findById(idPlataforma).orElseThrow(() -> new PlatformNotFound("No se encontró la plataforma."));
    }

    public Desarrollador desarrolladorFormat(Long idDesarrollador) {
        return deRe.findById(idDesarrollador)
                .orElseThrow(() -> new DeveloperNotFound("Desarrollador no encontrado."));
    }

}
