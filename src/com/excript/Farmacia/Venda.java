package com.excript.Farmacia;

import java.util.HashMap;
import java.util.Map;

public class Venda {
	private Map<Integer, Integer> carrinho;
	private Cliente cliente;
	
	public Venda(Cliente cliente) {
		this.carrinho = new HashMap<>();
		this.cliente = cliente;
	}
	
	public void adicionarItem(int codigo,int quantidade) {
		Integer qnt = this.carrinho.get(codigo);
		
		if(qnt == null) {
			qnt = 0;
		}
		
		this.carrinho.put(codigo, qnt+quantidade);
	}
	
	public void removerItem(int codigo,int quantidade) {
		Integer qnt = this.carrinho.get(codigo);
		if(qnt == null) {
			return;
		}
		if(qnt <= quantidade) {
			this.carrinho.remove(codigo);
			return;
		}
		this.carrinho.put(codigo, qnt-quantidade);
	}
	
	//Getters e setters
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
