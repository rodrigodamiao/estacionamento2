package com.damzik.estacionamento2.exceptions;

public class VeiculoNotFoundException extends RuntimeException {
    public VeiculoNotFoundException(Long id) {
      super(String.format("Veículo com ID %s não encontrado.", id));
    }
}
