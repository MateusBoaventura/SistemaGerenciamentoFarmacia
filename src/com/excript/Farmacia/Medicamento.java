package com.excript.Farmacia;

public class Medicamento extends Produto implements FuncoesMedicamento{
	
	private int peso;
	private boolean eReceita, eGenerico;
	private Estoque estoque;
	//Data de validade
	
	public Medicamento(String nome, String empresa, int peso, int id, double preco, boolean eReceita, boolean eGenerico) {
		super(nome, empresa, id, preco);
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
	
	 @Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarMedicamento(this)) {
	            System.out.println("Nome: " + getNome());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Receita: " + (iseReceita() ? "Sim" : "Nao"));
	            System.out.println("Generico: " + (iseGenerico() ? "Sim" : "Nao"));
	            System.out.println("Peso: " + getPeso());
	            System.out.println("Id: " + getId());
	            System.out.println("Preco: R$" + getPreco());
	        } else {
	            System.out.println("O medicamento nao esta no estoque.");
	        }
	    }
}
