package com.damzik.estacionamento2.repositories;

import com.damzik.estacionamento2.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
