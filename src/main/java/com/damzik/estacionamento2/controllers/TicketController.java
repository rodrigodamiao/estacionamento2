package com.damzik.estacionamento2.controllers;

import com.damzik.estacionamento2.dto.TicketRequestDTO;
import com.damzik.estacionamento2.dto.TicketResponseDTO;
import com.damzik.estacionamento2.entities.Ticket;
import com.damzik.estacionamento2.services.TicketService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getTickets(){
        List<Ticket> tickets = ticketService.getTickets();

        List<TicketResponseDTO> ticketsResponseDTO = tickets
                .stream()
                .map(TicketResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ticketsResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable Long id){
        Ticket ticket = ticketService.getTicketById(id);

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO(ticket);

        return ResponseEntity.ok(ticketResponseDTO);
    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> addTicket(@RequestBody TicketRequestDTO ticketRequestDTO){
        Ticket ticket = ticketService.addTicket(ticketRequestDTO);

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO(ticket);

        return ResponseEntity.ok(ticketResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> finalizarTicket(@PathVariable Long id){
        Ticket ticket = ticketService.finalizarTicket(id);

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO(ticket);

        return ResponseEntity.ok(ticketResponseDTO);
    }



















}
