package com.excript.Farmacia;

//Importando Map e HashMap
import java.util.HashMap;
import java.util.Map;

public class Venda {
	private Map<Integer, Integer> carrinho;
	private Cliente cliente;
	
	// Construtor
	public Venda(Cliente cliente) {
	    this.carrinho = new HashMap<>(); // Inicializa o carrinho como um novo HashMap
	    this.cliente = cliente; // Atribui o cliente recebido como parâmetro ao atributo cliente da venda
	}
	
	// Getters e setters
		public Map<Integer, Integer> getCarrinho() {
			return carrinho;
		}

		public void setCarrinho(Map<Integer, Integer> carrinho) {
			this.carrinho = carrinho;
		}

		
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

	// Adicionando item passando o codigo dele e a quantidade
	public void adicionarItem(int codigo, int quantidade) {
	    Integer qnt = this.carrinho.get(codigo); // Obtém a quantidade atual do produto no carrinho pelo seu código

	    if (qnt == null) { // Se a quantidade for nula (produto não está no carrinho)
	        qnt = 0; // Define a quantidade como 0
	    }

	    this.carrinho.put(codigo, qnt + quantidade); // Adiciona a quantidade informada ao carrinho para o produto com o código fornecido
	}

	
	// Removendo item passando o codigo e a quantidade
	public void removerItem(int codigo,int quantidade) {
		Integer qnt = this.carrinho.get(codigo); // Obtém a quantidade atual do produto no carrinho pelo seu código

	    if (qnt == null) { // Se a quantidade for nula (produto não está no carrinho), retorna
	        return;
	    }

	    if (qnt <= quantidade) { // Se a quantidade atual for menor ou igual à quantidade informada
	        this.carrinho.remove(codigo); // Remove o produto do carrinho
	        return;
	    }

	    this.carrinho.put(codigo, qnt - quantidade); // Subtrai a quantidade informada do produto no carrinho
	}

	
	@Override
	public String toString() {
		String saida = new String();
		
		saida += cliente;
		
		Object[] s = this.carrinho.keySet().toArray();
		
		for(int i = 0;i<s.length;i++) {
			saida += String.format("\n%d : %d", (int)s[i],(int)this.carrinho.get(s[i]));
		}
		
		return saida;
	}
}
