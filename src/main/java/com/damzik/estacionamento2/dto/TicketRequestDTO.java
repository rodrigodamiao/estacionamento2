package com.damzik.estacionamento2.dto;

import com.damzik.estacionamento2.entities.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDTO {

    private Long veiculoId;

    public TicketRequestDTO() {
    }

    public TicketRequestDTO(Long veiculoId) {
        this.veiculoId = veiculoId;
    }
}
