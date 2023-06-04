package com.excript.Farmacia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Snack extends Produto{
	
	//Data de validade
	private categoria categoria;
	private Estoque estoque;
	private String descricao;
	int qtdEmbalagem; //Quantidade em uma embalagem
	
	public Snack(String nome, String empresa, int id, double preco, categoria categoria, String descricao, int qtdEmbalagem, String dataFabricacao, String dataValidade, int quantidade) {
		super(nome, empresa, id, preco, dataFabricacao, dataValidade, quantidade);
		this.categoria = categoria;
		this.descricao = descricao;
		this.qtdEmbalagem = qtdEmbalagem;
	}
	
	public categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public int getQtdEmbalagem() {
		return qtdEmbalagem;
	}
	public void setQtdEmbalagem(int qtdEmbalagem) {
		this.qtdEmbalagem = qtdEmbalagem;
	}


	public enum categoria{
		SALGADINHO, BISCOITO, BARRA_DE_CEREAL, CHOCOLATE;
	}
	
	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    return dataValidadeFormatada.isBefore(dataAtual);
	}
	
	 @Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarProduto(estoque.getSnacks(), this)) {
	        	System.out.println("Nome: " + getNome());
	    		System.out.println("Quantidade: " + getQuantidade());
	    		System.out.println("Quantidade na Embalagem: " + getQtdEmbalagem());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Categoria: " + getCategoria());
	            System.out.println("Id: " + getId());
	            System.out.println("Preço: R$" + getPreco());
	            System.out.println("Descrição: "+ getDescricao());
	            System.out.println("Data de Fabricação: " + getDataFabricacao());
		        System.out.println("Data de Validade: " + getDataValidade());

		        if (estaVencido()) {
		            System.out.println("Status: Vencido!");
		        } else {
		            System.out.println("Status: Não vencido.");
		        }
		    } else {
		        System.out.println("O Snack não está no estoque.");
		    }
	    }
	}
