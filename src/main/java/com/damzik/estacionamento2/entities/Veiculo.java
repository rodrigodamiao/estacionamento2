package com.damzik.estacionamento2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa; // ABC-123 (criar um gerador de placas aleatório)
    private String tipo; // Moto, Carro, etc...
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private List<Ticket> tickets = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(Long id, String placa, String tipo, String cor, List<Ticket> tickets) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.cor = cor;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
