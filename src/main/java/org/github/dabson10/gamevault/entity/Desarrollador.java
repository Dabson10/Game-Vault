package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese una ubicación.")
    private String ubicacion;
    @NotBlank(message = "Ingrese un creador.")
    private String creador;
    @OneToMany(mappedBy = "desarrollador")
    private List<Videojuego> videojuego;
}
