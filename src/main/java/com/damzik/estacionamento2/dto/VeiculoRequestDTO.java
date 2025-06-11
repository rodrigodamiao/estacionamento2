package com.damzik.estacionamento2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequestDTO {

    @NotBlank(message = "O tipo do veículo é obrigatório.")
    private String tipo;

    @NotBlank(message = "A cor do veículo é obrigatória.")
    private String cor;

    public VeiculoRequestDTO() {
    }

    public VeiculoRequestDTO(String tipo, String cor) {
        this.tipo = tipo;
        this.cor = cor;
    }
}