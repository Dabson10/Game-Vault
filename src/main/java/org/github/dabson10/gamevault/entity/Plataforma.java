package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity @ToString
@Table(name = "Plataforma")
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private Long idPlataforma;
    @Basic
    @Column(name = "nombre_plataforma") @NotBlank(message = "Ingrese un nombre de plataforma.")
    private String nombrePlataforma;
    //Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "plataforma")
    @ToString.Exclude
    private List<Coleccion> colecciones;

    @ManyToMany(mappedBy = "plataforma")
    @ToString.Exclude
    private List<Videojuego> videojuegos;
}
