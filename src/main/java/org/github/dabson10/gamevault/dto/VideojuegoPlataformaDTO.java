package org.github.dabson10.gamevault.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.IMessage;
import org.github.dabson10.gamevault.entity.Plataforma;

import java.util.List;

@Setter @Getter
public class VideojuegoPlataformaDTO {
    @NotBlank(message = "Ingrese un nombre correcto")
    private String nombre;
    private List<Plataforma> plataforma;
}
