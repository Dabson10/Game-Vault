package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Plataforma")
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private Long idPlataforma;
    @Basic
    @Column(name = "nombre_plataforma")
    private String nombrePlataforma;
    //Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "plataforma")
    private List<Coleccion> colecciones;

    @ManyToMany
    @JoinTable(
            name = "plataforma_videojuego",
            joinColumns = @JoinColumn(name = "id_plataforma"),
            inverseJoinColumns = @JoinColumn(name =  "id_videojuego")
    )
    private List<Videojuego> videojuegos;
}
