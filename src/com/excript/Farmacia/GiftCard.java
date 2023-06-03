package com.excript.Farmacia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiftCard extends Produto {
	
	//Data de emissao
	//Data de validade
	//Infos do cliente que emitiu: nome, telefone e email
	private Estoque estoque;
	private long codigo;
	private boolean ativo;
	
	public GiftCard(String nome, String empresa, int id, double preco, long codigo, boolean ativo, String dataFabricacao, String dataValidade) {
		super(nome, empresa, id, preco, dataFabricacao, dataValidade);
		this.codigo = codigo;
		this.ativo = false;
		this.estoque = null;
	}

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
	 public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public void ativarGiftCard() {
		if(!ativo) ativo = true;
	}
	
	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    return dataValidadeFormatada.isBefore(dataAtual);
	}
	
	@Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarGiftCard(this)) {
	        	System.out.println("Nome: " + getNome());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Id: " + getId());
	            System.out.println("Preço: R$" + getPreco());
	            System.out.println("Código: " + getCodigo());
	            System.out.println("Está ativado? " + (isAtivo() ? "Sim" : "Não"));
	            System.out.println("Data de Fabricação: " + getDataFabricacao());
		        System.out.println("Data de Validade: " + getDataValidade());

		        if (estaVencido()) {
		            System.out.println("Status: Expirado!");
		        } else {
		            System.out.println("Status: Pode ser resgatado!");
		        }
		    } else {
		        System.out.println("O GiftCard não está no estoque.");
		    }
	    }
	
}
