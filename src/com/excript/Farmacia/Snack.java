package com.excript.Farmacia;

public class Snack extends Produto{
	
	//Data de validade
	private categoria categoria;
	private Estoque estoque;
	private String descricao;
	int quantidade; //Quantidade em uma embalagem
	
	public Snack(String nome, String empresa, int id, double preco, categoria categoria, String descricao, int quantidade) {
		super(nome, empresa, id, preco);
		this.categoria = categoria;
		this.descricao = descricao;
		this.quantidade = quantidade;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}


	public enum categoria{
		SALGADINHO, BISCOITO, BARRA_DE_CEREAL, CHOCOLATE;
	}
	
	
	 @Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarSnack(this)) {
	        	System.out.println("Nome: " + getNome());
	    		System.out.println("Quantidade: " + getQuantidade());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Categoria: " + getCategoria());
	            System.out.println("Id: " + getId());
	            System.out.println("Preco: R$" + getPreco());
	            System.out.println("Descricao: "+ getDescricao());
	        } else {
	            System.out.println("O Snack nao esta no estoque.");
	        }
	    }
	
}
