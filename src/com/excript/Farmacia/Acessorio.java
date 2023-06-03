package com.excript.Farmacia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Acessorio extends Produto {
    private Estoque estoque;

    public Acessorio(String nome, String empresa, int id, double preco, String dataFabricacao, String dataValidade) {
        super(nome, empresa, id, preco, dataFabricacao, dataValidade);
    }

	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    return dataValidadeFormatada.isBefore(dataAtual);
	}

	@Override
	public void MostrarDados(Estoque estoque) {
	    if (estoque.verificarAcessorio(this)) {
	        System.out.println("Nome: " + getNome());
	        System.out.println("Empresa: " + getEmpresa());
	        System.out.println("Id: " + getId());
	        System.out.println("Preço: R$" + getPreco());
	        System.out.println("Data de Fabricação: " + getDataFabricacao());
	        System.out.println("Data de Validade: " + getDataValidade());

	        if (estaVencido()) {
	            System.out.println("Status: Vencido!");
	        } else {
	            System.out.println("Status: Não vencido.");
	        }
	    } else {
	        System.out.println("O Acessório não está no estoque.");
	    }
	}


	
}
