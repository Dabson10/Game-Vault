package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;
    //Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "usuario")
    private List<Coleccion> coleccion;
}
