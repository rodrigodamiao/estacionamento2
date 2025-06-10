package com.damzik.estacionamento2.services;

import com.damzik.estacionamento2.dto.VeiculoRequestDTO;
import com.damzik.estacionamento2.entities.Veiculo;
import com.damzik.estacionamento2.exceptions.VeiculoNotFoundException;
import com.damzik.estacionamento2.helper.PlacaGenerator;
import com.damzik.estacionamento2.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> getVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoById(Long id){
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new VeiculoNotFoundException(id));

        return veiculo;
    }

    public Veiculo addVeiculo(VeiculoRequestDTO veiculoRequestDTO){
        Veiculo veiculo = new Veiculo();

        veiculo.setPlaca(PlacaGenerator.gerarPlaca());
        veiculo.setTipo(veiculoRequestDTO.getTipo());
        veiculo.setCor(veiculoRequestDTO.getCor());

        veiculoRepository.save(veiculo);

        return veiculo;
    }
}
