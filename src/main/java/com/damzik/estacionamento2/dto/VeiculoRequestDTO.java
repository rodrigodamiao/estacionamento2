package com.damzik.estacionamento2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequestDTO {

    private String tipo;
    private String cor;

    public VeiculoRequestDTO() {
    }

    public VeiculoRequestDTO(String tipo, String cor) {
        this.tipo = tipo;
        this.cor = cor;
    }
}