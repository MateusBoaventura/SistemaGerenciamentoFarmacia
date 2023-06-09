package com.excript.Farmacia;

import java.util.Date; // Importando data

public class Exame {
	// Atributos
    private String tipo;
    private Date horario;
    private double preco;
    private Cliente cliente;

    // Construtor
    public Exame(String tipo, Date horario, double preco, Cliente cliente) {
        this.tipo = tipo;
        this.horario = horario;
        this.preco = preco;
        this.cliente = cliente;
    }

    // Getters e setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Funcao que retorna dizendo que enviou o resultado do exame para o email correspondente
    public void enviarResultadoPorEmail() {
        // código para enviar o resultado do exame por email ao cliente
        System.out.println("Resultado do exame enviado por email para " + cliente.getEmail());
    }
}