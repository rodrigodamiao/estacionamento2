package com.damzik.estacionamento2.dto;

import com.damzik.estacionamento2.entities.Ticket;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class TicketResponseDTO {
    
    private Long id;

    private Double valor;

    private LocalDateTime entrada;
    private LocalDateTime saida;

    private VeiculoResponseDTO veiculoResponseDTO;

    private String status;

    public TicketResponseDTO() {
    }

    public TicketResponseDTO(Ticket ticket){
        this.id = ticket.getId();
        this.entrada = ticket.getEntrada();
        this.saida = ticket.getSaida();
        this.veiculoResponseDTO = new VeiculoResponseDTO(ticket.getVeiculo());
        this.status = ticket.getStatus();

        if(ticket.getSaida() != null){
            this.valor = ticket.getValor();
        }
        else{
            long horas = Duration.between(ticket.getEntrada(), LocalDateTime.now()).toHours();
            if(horas < 3){
                this.valor = 5.0;
            }else{
                this.valor = 10.0;
            }
        }
    }
}
