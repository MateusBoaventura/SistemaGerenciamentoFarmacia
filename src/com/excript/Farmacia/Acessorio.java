package com.excript.Farmacia;

public class Acessorio extends Produto {
	
	private Estoque estoque;
	
	public Acessorio(String nome, String empresa, int id, double preco) {
		super(nome, empresa, id, preco);
	}
	
	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}


	@Override
    public void MostrarDados(Estoque estoque) {
        if (estoque.verificarAcessorio(this)) {
            System.out.println("Nome: " + getNome());
            System.out.println("Empresa: " + getEmpresa());
            System.out.println("Id: " + getId());
            System.out.println("Preco: R$" + getPreco());
        } else {
            System.out.println("O acessorio nao esta no estoque.");
        }
    }
	
}
