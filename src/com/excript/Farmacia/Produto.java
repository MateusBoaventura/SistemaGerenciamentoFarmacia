package com.excript.Farmacia;

public abstract class Produto implements FuncoesProduto {
	
	private String nome, empresa;
	private int id;
	private double preco;
	
	Produto(String nome, String empresa, int id, double preco){
		this.nome = nome;
		this.empresa = empresa;
		this.id = id;
		this.preco = preco;
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
	
	public abstract void MostrarDados(Estoque estoque);
	//Metodo para mostrar quando o produto vencer
	
}
