package org.github.dabson10.gamevault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Nombre nulo o vacío.")
    private String nombre;
    @NotBlank(message = "Apellido nulo o vacío.")
    private String apellidos;
    @Email(message = "Formato del correo invalido.") @NotBlank(message = "Correo nulo o vacío.")
    private String correo;
    @Size(min = 8, message = "Ingrese una contraseña con mas de 7 caracteres.") @NotBlank(message = "Contraseña nula o vacía.")
    private String clave;
    //Se dice sobre que objeto se mapeara.
    @OneToMany(mappedBy = "usuario")
    private List<Coleccion> coleccion;
}
