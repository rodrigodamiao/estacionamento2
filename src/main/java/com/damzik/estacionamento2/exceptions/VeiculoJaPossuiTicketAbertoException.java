package com.damzik.estacionamento2.exceptions;

public class VeiculoJaPossuiTicketAbertoException extends RuntimeException {
    public VeiculoJaPossuiTicketAbertoException(Long veiculoId) {

        super(String.format("O veículo com ID %s já tem um ticket aberto.", veiculoId));
    }
}
