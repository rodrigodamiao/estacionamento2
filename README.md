# Sistema de Estacionamento 🚗

Este é um projeto simples de um sistema de estacionamento, desenvolvido com **Spring Boot** e banco de dados **H2** (em memória), com o objetivo de praticar conceitos de:

- CRUD com Spring Data JPA
- Relacionamento entre entidades (Veículo e Ticket)
- Camadas Controller, Service e Repository
- DTOs para comunicação com a API
- Manipulação de datas e cálculo de valores
- Tratamento de exceções com `@ControllerAdvice`

## Funcionalidades

- **Cadastro de veículo** (`POST /veiculos`)
- **Listagem de veículos** (`GET /veiculos`)
- **Criação de ticket** (`POST /tickets`)
- **Listagem de tickets** (`GET /tickets`)
- **Finalizar ticket (definir saída e calcular valor)** (`PUT /tickets/{id}/finalizar`)

## Tecnologias usadas

- Java 21
- Spring Boot
- Spring Data JPA
- Lombok
- Banco de dados H2 (para testes)
- Postman (para testes de API)
