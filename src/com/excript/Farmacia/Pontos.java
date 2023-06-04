package com.excript.Farmacia;

// Classe dos Pontos
public class Pontos {
    private int pontos;
    private double desconto;

    // Construtor pontos
    public Pontos(int pontos) {
        this.pontos = pontos;
        this.desconto = 0.0; // O desconto começa como 0
    }

    // Getters e setters
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    // Adiciona os pontos passados pelo parametro
    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
        verificarDesconto(); // Chamando verificarDesconto
    }

    public void verificarDesconto() {
        int quantidadeDescontos = pontos / 100; // A quantidade de descontos é de a cada 100 pontos ter desconto
        desconto = quantidadeDescontos * 0.1; // O desconto sempre será de 10%
    }
}
