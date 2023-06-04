package com.excript.Farmacia;

public abstract class Produto implements FuncoesProduto {
	
	private String nome, empresa;
	private int id;
	private double preco;
	private String dataFabricacao;
	private String dataValidade;
	private int quantidade;

	Produto(String nome, String empresa, int id, double preco, String dataFabricacao, String dataValidade, int quantidade) {
	    this.nome = nome;
	    this.empresa = empresa;
	    this.id = id;
	    this.preco = preco;
	    this.dataFabricacao = dataFabricacao;
	    this.dataValidade = dataValidade;
	    this.quantidade = quantidade;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public abstract void MostrarDados(Estoque estoque);
	
	public abstract boolean estaVencido();
	
}
