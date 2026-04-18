package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity @Table(name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuego")
    private Long idVideojuego;
    private String nombre;
    private int duracion;
    @Column(name = "porcentaje_total")
    private int porcentajeTotal;
    private LocalDate lanzado;
    //Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "videojuego")
    private List<Coleccion> coleccion;
    @ManyToOne
    @JoinColumn(name = "id_desarrollador")
    private Desarrollador desarrollador;

    @ManyToMany(mappedBy = "videojuegos")
    private List<Plataforma> plataforma;
}
