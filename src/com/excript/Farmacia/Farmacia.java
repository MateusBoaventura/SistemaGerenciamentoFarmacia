package com.excript.Farmacia;

import java.util.HashMap;
import java.util.Map;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;

public class Farmacia {
	private Map<String, Cliente> clientes;
	private Estoque estoque;
	
	public Farmacia() {
		this.clientes = new HashMap<>();
		this.estoque = new Estoque();
	}
	
	public void cadastrarCliente(Cliente cliente) throws JaCadastrado {
		if(this.clientes.get(cliente.getCpf()) != null) {
			throw new JaCadastrado("CPF",cliente.getCpf());
		}
		
		this.clientes.put(cliente.getCpf(), cliente);
	}
	
	public void finalizarVenda(Venda venda) throws CadastroInvalido {
		Object[] itens = venda.getCarrinho().keySet().toArray();
		float preco = 0;
		for(int i = 0,codigo = 0,emestoque = 0,clientequer = 0;i<itens.length;i++) {
			codigo = (int) itens[i];
			emestoque = this.estoque.consultarQuantidade(codigo);
			clientequer = venda.getCarrinho().get(codigo);
			if(emestoque >= clientequer) {
				preco = this.estoque.consultarPreco(codigo);
				this.estoque.atualizarQuantidade(codigo, emestoque-clientequer);
				venda.getCliente().setDinheiro(venda.getCliente().getDinheiro() + preco*clientequer);
			}
		}
	}
	
	public String consultarTotal(Venda venda) throws CadastroInvalido {
		String saida = new String();
		Object[] itens = venda.getCarrinho().keySet().toArray();
		float preco = 0;
		for(int i = 0,codigo = 0,clientequer = 0;i<itens.length;i++) {
			codigo = (int) itens[i];
			clientequer = venda.getCarrinho().get(codigo);
			preco = this.estoque.consultarPreco(codigo);
			saida += String.format("%s : %d = %.2f (%.2f Cada)", this.estoque.getMercadorias().get(codigo).getNome(),clientequer,clientequer*preco,preco);
		}
		
		return saida;
	}
	
	@Override
	public String toString() {
		String saida = this.estoque.toString();
		
		Object[] s = this.clientes.keySet().toArray();
		
		for(int i = 0;i<s.length;i++) {
			saida += String.format("\n\n%s", this.clientes.get(s[i]));
		}
		
		return saida;
	}
}
