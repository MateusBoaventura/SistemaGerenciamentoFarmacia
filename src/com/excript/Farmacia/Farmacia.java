package com.excript.Farmacia;

import java.util.HashMap;
import java.util.Map;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;

public class Farmacia {
	private Map<String, Cliente> clientes;
	private Estoque estoque;
	
	// Construtor
	public Farmacia() {
		this.clientes = new HashMap<>();
		this.estoque = new Estoque();
	}
	
	// Função que recebe um cliente e o cadastra pelo cpf
	public void cadastrarCliente(Cliente cliente) throws JaCadastrado {
	    if (this.clientes.get(cliente.getCpf()) != null) { // Verifica se o cliente já está cadastrado pelo CPF
	        throw new JaCadastrado("CPF", cliente.getCpf()); // Lança uma exceção de "JaCadastrado" caso o cliente já esteja cadastrado
	    }

	    this.clientes.put(cliente.getCpf(), cliente); // Adiciona o cliente ao mapa de clientes usando o CPF como chave
	}

	
	// Recebe a venda e percorre os itens do carrinho e verifica se a quantidade é o suficiente
	public void finalizarVenda(Venda venda) throws CadastroInvalido {
	    Object[] itens = venda.getCarrinho().keySet().toArray(); // Obtém a lista de itens do carrinho da venda
	    float preco = 0; // Variável auxiliar para armazenar o preço de cada item

	    for (int i = 0, codigo = 0, emEstoque = 0, clienteQuer = 0; i < itens.length; i++) {
	        codigo = (int) itens[i]; // Obtém o código do item
	        emEstoque = this.estoque.consultarQuantidade(codigo); // Consulta a quantidade em estoque do item
	        clienteQuer = venda.getCarrinho().get(codigo); // Obtém a quantidade solicitada pelo cliente para esse item

	        if (emEstoque >= clienteQuer) { // Verifica se a quantidade em estoque é suficiente
	            preco = this.estoque.consultarPreco(codigo); // Consulta o preço do item
	            this.estoque.atualizarQuantidade(codigo, emEstoque - clienteQuer); // Atualiza a quantidade em estoque
	            venda.getCliente().setDinheiro(venda.getCliente().getDinheiro() + preco * clienteQuer); // Atualiza o saldo do cliente com o valor da compra
	        }
	    }
	}

	
	// Consulta o preço, quantidade e nome. Retorna em uma string
	public String consultarTotal(Venda venda) throws CadastroInvalido {
	    String saida = new String(); // Variável para armazenar a saída
	    Object[] itens = venda.getCarrinho().keySet().toArray(); // Obtém a lista de itens do carrinho da venda
	    float preco = 0; // Variável para armazenar o preço de cada item

	    for (int i = 0, codigo = 0, clienteQuer = 0; i < itens.length; i++) {
	        codigo = (int) itens[i]; // Obtém o código do item
	        clienteQuer = venda.getCarrinho().get(codigo); // Obtém a quantidade solicitada pelo cliente para esse item
	        preco = this.estoque.consultarPreco(codigo); // Consulta o preço do item

	        // Formata a string com as informações do item e adiciona à saída
	        saida += String.format("%s : %d = %.2f (%.2f Cada)", this.estoque.getMercadorias().get(codigo).getNome(), clienteQuer, clienteQuer * preco, preco);
	    }

	    return saida; // Retorna a saída contendo as informações do total da venda
	}

	
	@Override
	public String toString() {
		String saida = this.estoque.toString();
		
		Object[] s = this.clientes.keySet().toArray(); // Utilizando Array
		
		for(int i = 0;i<s.length;i++) {
			saida += String.format("\n\n%s", this.clientes.get(s[i]));
		}
		
		return saida;
	}
}
