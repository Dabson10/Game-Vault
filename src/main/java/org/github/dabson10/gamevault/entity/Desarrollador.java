package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
@Entity
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrollador")
    private Long idDesarrollador;
    private String nombre;
    private String ubicacion;
    private String creador;
    @OneToMany(mappedBy = "desarrollador")
    private List<Videojuego> videojuego;
}
