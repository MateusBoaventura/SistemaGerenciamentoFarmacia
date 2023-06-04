package com.excript.Farmacia;

//Importando as devidas bibliotecas para fazer o sistema de data:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicamento extends Produto implements FuncoesMedicamento{
	
	private int peso; // Um peso, em gramas ou ml, de um medicamento é um atributo essencial
	private boolean eReceita, eGenerico; // Um medicamento pode ou ser generico, assim como pode ou nao solicitar uma receita
	private Estoque estoque; // O Produto Medicamento estará no estoque da nossa farmácia
	
	// Criando seu construtor
	public Medicamento(String nome, String empresa, int peso, int id, double preco, boolean eReceita, boolean eGenerico, String dataFabricacao, String dataValidade, int quantidade) {
		super(nome, empresa, id, preco, dataFabricacao, dataValidade, quantidade);
		this.peso = peso;
		this.eReceita = eReceita;
		this.eGenerico = eGenerico;
		NovoPreco(); // aqui ao invés de atribuir por padrão, ele atribui baseado se é ou não generico.
	}
	
	//Getters e Setters
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

	// Aqui ele verifica se o medicamento é generico
	public void NovoPreco() {
		if(iseGenerico()) {
			  setPreco(getPreco() * 0.9);// Dá desconto de 10% automaticamente no sistema para Genericos
		}
	}
	
	// A explicação desta função de forma detalhada está na classe Acessorio
	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    return dataValidadeFormatada.isBefore(dataAtual);
	}
	
	// A explicação desta função de forma detalhada está na classe Acessorio
	 @Override
	    public void MostrarDados(Estoque estoque) {
	        if (estoque.verificarProduto(estoque.getMedicamentos(), this)) {
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
