package com.excript.Farmacia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicamento extends Produto implements FuncoesMedicamento{
	
	private int peso;
	private boolean eReceita, eGenerico;
	private Estoque estoque;
		
	public Medicamento(String nome, String empresa, int peso, int id, double preco, boolean eReceita, boolean eGenerico, String dataFabricacao, String dataValidade) {
		super(nome, empresa, id, preco, dataFabricacao, dataValidade);
		this.peso = peso;
		this.eReceita = eReceita;
		this.eGenerico = eGenerico;
		NovoPreco();
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public boolean iseReceita() {
		return eReceita;
	}
	public void seteReceita(boolean eReceita) {
		this.eReceita = eReceita;
	}
	public boolean iseGenerico() {
		return eGenerico;
	}
	public void seteGenerico(boolean eGenerico) {
		this.eGenerico = eGenerico;
	}	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public void NovoPreco() {
		if(iseGenerico()) {
			  setPreco(getPreco() * 0.9);// Dá desconto de 10% automaticamente no sistema para Genericos
		}
	}
	
	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    return dataValidadeFormatada.isBefore(dataAtual);
	}
	
	 @Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarMedicamento(this)) {
	            System.out.println("Nome: " + getNome());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Receita: " + (iseReceita() ? "Sim" : "Não"));
	            System.out.println("Genérico: " + (iseGenerico() ? "Sim" : "Não"));
	            System.out.println("Peso: " + getPeso());
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
		        System.out.println("O Medicamento não está no estoque.");
		    }
	    }
}
