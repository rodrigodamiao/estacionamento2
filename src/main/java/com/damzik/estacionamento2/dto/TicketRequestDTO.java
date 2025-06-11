package com.damzik.estacionamento2.dto;

import com.damzik.estacionamento2.entities.Veiculo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDTO {

    @NotNull(message = "O ID do veículo é obrigatório.")
    private Long veiculoId;

    public TicketRequestDTO() {
    }

    public TicketRequestDTO(Long veiculoId) {
        this.veiculoId = veiculoId;
    }
}
