package com.excript.Farmacia;

public class GiftCard extends Produto {
	
	//Data de emissao
	//Data de validade
	//Infos do cliente que emitiu: nome, telefone e email
	private Estoque estoque;
	private long codigo;
	private boolean ativo;
	
	public GiftCard(String nome, String empresa, int id, double preco, long codigo, boolean ativo) {
		super(nome, empresa, id, preco);
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
	
	@Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarGiftCard(this)) {
	        	System.out.println("Nome: " + getNome());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Id: " + getId());
	            System.out.println("Preco: R$" + getPreco());
	            System.out.println("Codigo: " + getCodigo());
	            System.out.println("Esta ativado? " + (isAtivo() ? "Sim" : "Nao"));
	        } else {
	            System.out.println("O GiftCard nao esta no estoque.");
	        }
	    }
	
}
