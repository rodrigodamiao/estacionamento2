package com.damzik.estacionamento2.exceptions;

import java.time.LocalDateTime;

public class TicketJaFinalizadoException extends RuntimeException {
    public TicketJaFinalizadoException(Long id) {
        super(String.format("O Ticket com ID %s já foi finalizado.", id));
    }
}
