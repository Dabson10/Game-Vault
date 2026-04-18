package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "coleccion")
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coleccion")
    private Long idColeccion;
    private String progreso;
    private int horasJugadas;
    private String formato;
    private String proposito;
    //Se le asigna un nombre a la columna que almacenara los IDs.
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_plataforma")
    private Plataforma plataforma;
    @ManyToOne
    @JoinColumn(name = "id_videojuego")
    private Videojuego videojuego;
}
