package com.damzik.estacionamento2.repositories;

import com.damzik.estacionamento2.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByVeiculoIdAndStatus(Long veiculoId, String status);

    List<Ticket> findByVeiculoId(Long veiculoId);
}
