package com.damzik.estacionamento2.dto;

import com.damzik.estacionamento2.entities.Veiculo;
import lombok.Getter;

@Getter
public class VeiculoResponseDTO {

    private Long id;

    private String placa;
    private String tipo;
    private String cor;

    public VeiculoResponseDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.tipo = veiculo.getTipo();
        this.cor = veiculo.getCor();
    }
}
