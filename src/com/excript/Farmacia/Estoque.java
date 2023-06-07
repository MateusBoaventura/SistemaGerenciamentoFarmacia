package com.excript.Farmacia;

// Importando Map e HashMap
import java.util.HashMap;
import java.util.Map;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.Produto; 

public class Estoque  implements gestorEstoque {
	// Criando os Maps para mercadorias, quantidade, preço e nomes
	private Map<Integer, Produto> mercadorias;
	private Map<Integer, Integer> quantidade;
	private Map<Integer, Float> preco;
	private Map<String, Integer> nomes;

	// Construtor
	public Estoque() {
		this.mercadorias = new HashMap<>();
		this.quantidade = new HashMap<>();
		this.preco = new HashMap<>();
		this.nomes = new HashMap<>();
	}
	
	
	// Getters e Setters
	public Map<Integer, Produto> getMercadorias() {
		return mercadorias;
	}
	public void setMercadorias(Map<Integer, Produto> mercadorias) {
		this.mercadorias = mercadorias;
	}

	public Map<Integer, Integer> getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Map<Integer, Integer> quantidade) {
		this.quantidade = quantidade;
	}

	public Map<Integer, Float> getPreco() {
		return preco;
	}
	public void setPreco(Map<Integer, Float> preco) {
		this.preco = preco;
	}

	public Map<String, Integer> getNomes() {
		return nomes;
	}
	public void setNomes(Map<String, Integer> nomes) {
		this.nomes = nomes;
	}
	
	
	// Funcao para cadastrar o produto
	public void cadastrarProduto(Produto produto, int codigo) throws JaCadastrado { // Lançando tratamento de exceção caso produto já esteja cadastrado
	    if (nomes.get(produto.getNome()) != null) { // Verifica se o nome do produto já existe no mapa de nomes
	        throw new JaCadastrado("Produto", produto.getNome()); // Lança uma exceção JaCadastrado com a mensagem personalizada indicando que o produto já está cadastrado
	    }
	    if (mercadorias.get(codigo) != null) { // Verifica se o código do produto já existe no mapa de mercadorias
	        throw new JaCadastrado("Codigo", String.format("%d", codigo)); // Lança uma exceção JaCadastrado com a mensagem personalizada indicando que o código já está cadastrado
	    }
	    
	    // Se o produto não estiver cadastrado, realiza o cadastro
	    this.nomes.put(produto.getNome(), codigo); // Adiciona o nome do produto ao mapa de nomes, usando o código como chave
	    this.preco.put(codigo, 0f); // Inicializa o preço do produto como 0 no mapa de preços, usando o código como chave
	    this.quantidade.put(codigo, 0); // Inicializa a quantidade do produto como 0 no mapa de quantidades, usando o código como chave
	    this.mercadorias.put(codigo, produto); // Adiciona o produto ao mapa de mercadorias, usando o código como chave
	}


	// Funcao para remover o produto
	public void removerProduto(int codigo) throws CadastroInvalido { // Lançando tratamento de exceção caso codigo seja invalido
		Produto p = this.mercadorias.get(codigo); // Obtém o produto associado ao código fornecido do mapa 'mercadorias'
	    if (p == null) {
	        throw new CadastroInvalido("Codigo", String.format("%d", codigo)); // Lança uma exceção 'CadastroInvalido' se o produto não for encontrado com o código fornecido
	    }

	    this.mercadorias.remove(codigo); // Remove o produto do mapa 'mercadorias' com base no código
	    this.quantidade.remove(codigo); // Remove a quantidade associada ao código do mapa 'quantidade'
	    this.preco.remove(codigo); // Remove o preço associado ao código do mapa 'preco'
	    this.nomes.remove(p.getNome()); // Remove o nome do produto do mapa 'nomes' usando o nome obtido do objeto 'p'
	}
	
	
	// Retorna a quantidade de um produto com base no código fornecido
	public int consultarQuantidade(int codigo) throws CadastroInvalido {
	    if (this.quantidade.get(codigo) != null) { // Verifica se há uma quantidade associada ao código fornecido no mapa 'quantidade'
	        return this.quantidade.get(codigo); // Retorna a quantidade correspondente ao código
	    }
	    throw new CadastroInvalido("Codigo", String.format("%d", codigo)); // Lança uma exceção 'CadastroInvalido' se o código não estiver cadastrado
	}

	// Retorna a quantidade de um produto com base no nome fornecido
	public int consultarQuantidade(String nome) throws CadastroInvalido {
	    if (this.nomes.get(nome) != null) { // Verifica se há um código associado ao nome fornecido no mapa 'nomes'
	        return this.consultarQuantidade(this.nomes.get(nome)); // Chama a função 'consultarQuantidade' passando o código associado ao nome
	    }
	    throw new CadastroInvalido("Nome", nome); // Lança uma exceção 'CadastroInvalido' se o nome não estiver cadastrado
	}

	// Atualiza a quantidade de um produto com base no código fornecido
	public void atualizarQuantidade(int codigo, int quantidade) throws CadastroInvalido {
	    if (this.quantidade.get(codigo) == null) { // Verifica se há uma quantidade associada ao código fornecido no mapa 'quantidade'
	        throw new CadastroInvalido("Codigo", String.format("%d", codigo)); // Lança uma exceção 'CadastroInvalido' se o código não estiver cadastrado
	    }
	    this.quantidade.put(codigo, quantidade); // Atualiza a quantidade do produto com base no código fornecido
	}

	// Atualiza a quantidade de um produto com base no nome fornecido
	public void atualizarQuantidade(String nome, int quantidade) throws CadastroInvalido {
	    if (this.nomes.get(nome) == null) { // Verifica se há um código associado ao nome fornecido no mapa 'nomes'
	        throw new CadastroInvalido("Nome", nome); // Lança uma exceção 'CadastroInvalido' se o nome não estiver cadastrado
	    }
	    this.atualizarQuantidade(this.nomes.get(nome), quantidade); // Chama a função 'atualizarQuantidade' passando o código associado ao nome e a quantidade fornecida
	}

	
	// Retorna o preço de um produto com base no código fornecido
	public float consultarPreco(int codigo) throws CadastroInvalido {
	    if (this.preco.get(codigo) != null) { // Verifica se há um preço associado ao código fornecido no mapa 'preco'
	        return this.preco.get(codigo); // Retorna o preço correspondente ao código
	    }
	    throw new CadastroInvalido("Codigo", String.format("%d", codigo)); // Lança uma exceção 'CadastroInvalido' se o código não estiver cadastrado
	}

	// Retorna o preço de um produto com base no nome
	public float consultarPreco(String nome) throws CadastroInvalido {
	    if (this.nomes.get(nome) != null) { // Verifica se há um código associado ao nome fornecido no mapa 'nomes'
	        return this.consultarPreco(this.nomes.get(nome)); // Chama a função 'consultarPreco' passando o código associado ao nome
	    }
	    throw new CadastroInvalido("Nome", nome); // Lança uma exceção 'CadastroInvalido' se o nome não estiver cadastrado
	}

	// Atualiza o preço de um produto com base no codigo fornecido
	public void atualizarPreco(int codigo, float preco) throws CadastroInvalido {
	    if (this.preco.get(codigo) == null) { // Verifica se há um preço associado ao código fornecido no mapa 'preco'
	        throw new CadastroInvalido("Codigo", String.format("%d", codigo)); // Lança uma exceção 'CadastroInvalido' se o código não estiver cadastrado
	    }
	    this.preco.put(codigo, preco); // Atualiza o preço do produto com base no código fornecido
	}

	// Atualiza o preçõ de um produto com base no nome fornecido
	public void atualizarPreco(String nome, float preco) throws CadastroInvalido {
	    if (this.nomes.get(nome) == null) { // Verifica se há um código associado ao nome fornecido no mapa 'nomes'
	        throw new CadastroInvalido("Nome", nome); // Lança uma exceção 'CadastroInvalido' se o nome não estiver cadastrado
	    }
	    this.atualizarPreco(this.nomes.get(nome), preco); // Chama a função 'atualizarPreco' passando o código associado ao nome e o preço fornecido
	}
	
	// Buscando produto
	public int buscarProduto(String nome) {
		if (this.nomes.get(nome) != null) {
			return this.nomes.get(nome);
		}
		return -1;
	}
	
	
	@Override
	public String toString() { // Retorna uma representação em forma de String dos produtos
		String saida = new String(); // Variável para armazenar a string
	    Object[] s = this.nomes.keySet().toArray(); // Array de objetos contendo os nomes dos produtos
	    for (int i = 0; i < s.length; i++) { // Iteração sobre os nomes dos produtos
	        if (i > 0) {
	            saida += "\n"; // Adiciona uma quebra de linha se não for o primeiro produto
	        }
	        try {
	            saida += String.format("%s : %d : %.2f", s[i], this.consultarQuantidade((String) s[i]), this.consultarPreco((String) s[i]));
	            // Formata a representação do produto com nome, quantidade e preço, usando os métodos 'consultarQuantidade' e 'consultarPreco'
	        } catch (CadastroInvalido e) {
	            e.printStackTrace(); // Imprime o rastreamento de pilha da exceção 'CadastroInvalido' se ocorrer
	        }
	    }
	    return saida; // Retorna a representação em forma de string dos produtos
	}
}