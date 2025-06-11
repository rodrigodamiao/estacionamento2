package com.damzik.estacionamento2.services;

import com.damzik.estacionamento2.dto.TicketRequestDTO;
import com.damzik.estacionamento2.entities.Ticket;
import com.damzik.estacionamento2.entities.Veiculo;
import com.damzik.estacionamento2.exceptions.TicketJaFinalizadoException;
import com.damzik.estacionamento2.exceptions.TicketNotFoundException;
import com.damzik.estacionamento2.exceptions.VeiculoJaPossuiTicketAbertoException;
import com.damzik.estacionamento2.exceptions.VeiculoNotFoundException;
import com.damzik.estacionamento2.repositories.TicketRepository;
import com.damzik.estacionamento2.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final VeiculoRepository veiculoRepository;

    public TicketService(TicketRepository ticketRepository, VeiculoRepository veiculoRepository) {
        this.ticketRepository = ticketRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        return ticket;
    }

    public List<Ticket> buscarTicketsDoVeiculo(Long veiculoId) {
        return ticketRepository.findByVeiculoId(veiculoId);
    }

    public Ticket addTicket(TicketRequestDTO ticketRequestDTO){

        Long veiculoId = ticketRequestDTO.getVeiculoId();

        List<Ticket> ticketsAbertos = ticketRepository.findByVeiculoIdAndStatus(veiculoId, "ABERTO");
        if (!ticketsAbertos.isEmpty()) {
            throw new VeiculoJaPossuiTicketAbertoException(veiculoId);
        }

        Ticket ticket = new Ticket();

        ticket.setValor(5.00);
        ticket.setEntrada(LocalDateTime.now());

        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new VeiculoNotFoundException(veiculoId));

        ticket.setVeiculo(veiculo);

        ticket.setStatus("ABERTO");

        ticketRepository.save(ticket);

        return ticket;
    }

    public Ticket finalizarTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        if (ticket.getStatus().equals("FECHADO")) {
            throw new TicketJaFinalizadoException(ticket.getId());
        }

        ticket.setStatus("FECHADO");

        ticket.setSaida(LocalDateTime.now());

        if(Duration.between(ticket.getEntrada(), LocalDateTime.now()).toHours() < 3){
            ticket.setValor(5.0);
        }else{
            ticket.setValor(10.0);
        }

        ticketRepository.save(ticket);

        return ticket;
    }
}
