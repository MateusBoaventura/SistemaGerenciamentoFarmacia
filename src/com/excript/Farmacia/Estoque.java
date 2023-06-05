package com.excript.Farmacia;

import java.util.HashMap;
import java.util.Map;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.Produto; 

public class Estoque {
	private Map<Integer, Produto> mercadorias;
	private Map<Integer, Integer> quantidade;
	private Map<Integer, Float> preco;
	private Map<String, Integer> nomes;

	public Estoque() {
		this.mercadorias = new HashMap<>();
		this.quantidade = new HashMap<>();
		this.preco = new HashMap<>();
		this.nomes = new HashMap<>();
	}
	
	public void cadastrarProduto(Produto produto,int codigo) throws JaCadastrado {
		if(nomes.get(produto.getNome()) != null) {
			throw new JaCadastrado("Produto",produto.getNome());
		}
		if(mercadorias.get(codigo) != null) {
			throw new JaCadastrado("Codigo",String.format("%d", codigo));
		}
		
		this.nomes.put(produto.getNome(), codigo);
		this.preco.put(codigo, 0f);
		this.quantidade.put(codigo, 0);
		this.mercadorias.put(codigo, produto);
	}

	public void removerProduto(int codigo) throws CadastroInvalido {
		Produto p = this.mercadorias.get(codigo);
		if(p == null) {
			throw new CadastroInvalido("Codigo",String.format("%d", codigo));
		}
		
		this.mercadorias.remove(codigo);
		this.quantidade.remove(codigo);
		this.preco.remove(codigo);
		this.nomes.remove(p.getNome());
	}
	
	public int consultarQuantidade(int codigo) throws CadastroInvalido {
		if(this.quantidade.get(codigo) != null) {
			return this.quantidade.get(codigo);
		}
		throw new CadastroInvalido("Codigo",String.format("%d", codigo));
	}
	
	public int consultarQuantidade(String nome) throws CadastroInvalido {
		if(this.nomes.get(nome) != null) {
			return this.consultarQuantidade(this.nomes.get(nome));
		}
		throw new CadastroInvalido("Nome",nome);
	}
	
	public void atualizarQuantidade(int codigo,int quantidade) throws CadastroInvalido {
		if(this.quantidade.get(codigo) == null) {
			throw new CadastroInvalido("Codigo",String.format("%d", codigo));
		}
		this.quantidade.put(codigo, quantidade);
	}
	
	public void atualizarQuantidade(String nome,int quantidade) throws CadastroInvalido {
		if(this.nomes.get(nome) == null) {
			throw new CadastroInvalido("Nome",nome);
		}
		this.atualizarQuantidade(this.nomes.get(nome), quantidade);
	}
	
	public float consultarPreco(int codigo) throws CadastroInvalido {
		if(this.preco.get(codigo) != null) {
			return this.preco.get(codigo);
		}
		throw new CadastroInvalido("Codigo",String.format("%d", codigo));
	}
	
	public float consultarPreco(String nome) throws CadastroInvalido {
		if(this.nomes.get(nome) != null) {
			return this.consultarPreco(this.nomes.get(nome));
		}
		throw new CadastroInvalido("Nome",nome);
	}
	
	public void atualizarPreco(int codigo,float preco) throws CadastroInvalido {
		if(this.preco.get(codigo) == null) {
			throw new CadastroInvalido("Codigo",String.format("%d", codigo));
		}
		this.preco.put(codigo, preco);
	}
	
	public void atualizarPreco(String nome,float preco) throws CadastroInvalido {
		if(this.nomes.get(nome) == null) {
			throw new CadastroInvalido("Nome",nome);
		}
		this.atualizarPreco(this.nomes.get(nome), preco);
	}
	
	@Override
	public String toString() {
		String saida = new String();
		Object[] s = this.nomes.keySet().toArray();
		for(int i = 0;i<s.length;i++) {
			if(i>0) {
				saida += "\n";
			}
			try {
				saida += String.format("%s : %d : %.2f", s[i],this.consultarQuantidade((String) s[i]),this.consultarPreco((String)s[i]));
			} catch (CadastroInvalido e) {
				e.printStackTrace();
			}
		}
		return saida;
	}
}