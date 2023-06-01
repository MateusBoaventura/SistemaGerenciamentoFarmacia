package com.excript.Farmacia;

public class Pontos {
    private int pontos;
    private double desconto;

    public Pontos(int pontos) {
        this.pontos = pontos;
        this.desconto = 0.0;
    }

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

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
        verificarDesconto();
    }

    public void verificarDesconto() {
        int quantidadeDescontos = pontos / 100;
        desconto = quantidadeDescontos * 0.1;
    }
}
