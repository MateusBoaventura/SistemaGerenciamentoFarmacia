package com.excript.Farmacia;

public class Cosmetico extends Produto {
	
	private categoria categoria;
	private String descricao;
	private Estoque estoque;
	//Data de validade
	
	public Cosmetico(String nome, String empresa, int id, double preco, categoria categoria, String descricao) {
		super(nome, empresa, id, preco);
		this.categoria = categoria;
		this.descricao = descricao;
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


	public enum categoria{
		MAQUIAGEM, CUIDADOS_PELE, CUIDADOS_CABELO, FRAGRANCIAS, OUTROS;
	}
	
	@Override
    public void MostrarDados(Estoque estoque) {
        if (estoque.verificarCosmetico(this)) {
        	System.out.println("Nome: " + getNome());
            System.out.println("Empresa: " + getEmpresa());
            System.out.println("Categoria: " + getCategoria());
            System.out.println("Id: " + getId());
            System.out.println("Preco: R$" + getPreco());
            System.out.println("Descricao: "+ getDescricao());
        } else {
            System.out.println("O cosmetico nao esta no estoque.");
        }
    }
	
}
