package com.damzik.estacionamento2.repositories;

import com.damzik.estacionamento2.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
