package com.damzik.estacionamento2.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super(String.format("Ticket com ID %s não encontrado.", id));
    }
}
