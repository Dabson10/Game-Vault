package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuego")
    private Long idVideojuego;
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese un autor.")
    private String autor;
    @Min(value = 1, message = "Ingrese una duración mas alta.")
    // @NotBlank(message = "Ingrese una duración correcta")
    private int duracion;
    @Column(name = "porcentaje_total")
    @Min(value = 1, message = "Ingrese un porcentaje mayor.")
    // @NotBlank(message = "Ingrese el porcentaje del videojuego.")
    private int porcentajeTotal;
    @NotNull(message = "Ingrese una fecha de lanzamiento.")
    private LocalDate lanzado;
    // Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "videojuego")
    private List<Coleccion> coleccion;
    @ManyToOne
    @JoinColumn(name = "id_desarrollador")
    private Desarrollador desarrollador;

    @ManyToMany
    @JoinTable(name = "plataforma_videojuego", joinColumns = @JoinColumn(name = "id_videojuego"), inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
    private List<Plataforma> plataforma;

    @ManyToMany
    @JoinTable(name = "videojuego_genero",
    joinColumns = @JoinColumn(name = "id_videojuego"),
            inverseJoinColumns =  @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;
}
