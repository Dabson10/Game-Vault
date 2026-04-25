package org.github.dabson10.gamevault.dto.usuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class UsuarioCredencialDTO {
    @Email(message = "Formato del correo invalido.") @NotBlank(message = "Correo vacío o valor nulo.")
    private String correo;
    @Size(min = 8, message = "Ingrese una contraseña con al menos 8 caracteres.") @NotBlank(message = "Contraseña vacía o nula.")
    private String clave;
}
