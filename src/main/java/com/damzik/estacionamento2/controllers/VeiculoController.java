package com.damzik.estacionamento2.controllers;

import com.damzik.estacionamento2.dto.VeiculoRequestDTO;
import com.damzik.estacionamento2.dto.VeiculoResponseDTO;
import com.damzik.estacionamento2.entities.Veiculo;
import com.damzik.estacionamento2.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> getVeiculos(){
        List<Veiculo> veiculos = veiculoService.getVeiculos();

        List<VeiculoResponseDTO> veiculoResponseDTOS = veiculos
                .stream()
                .map(VeiculoResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(veiculoResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> getVeiculoById(@PathVariable Long id){
        Veiculo veiculo = veiculoService.getVeiculoById(id);

        VeiculoResponseDTO veiculoResponseDTO = new VeiculoResponseDTO(veiculo);

        return ResponseEntity.ok(veiculoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> addVeiculo(@RequestBody @Valid VeiculoRequestDTO veiculoRequestDTO){
        Veiculo veiculo = veiculoService.addVeiculo(veiculoRequestDTO);

        VeiculoResponseDTO veiculoResponseDTO = new VeiculoResponseDTO(veiculo);

        return ResponseEntity.ok(veiculoResponseDTO);
    }
}
