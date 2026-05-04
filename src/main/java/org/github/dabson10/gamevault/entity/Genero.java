package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long idGenero;
    @NotBlank(message = "Ingrese un genero.")
    private String genero;
    @ManyToMany(mappedBy = "generos")
    private List<Videojuego> videojuegos;
}
