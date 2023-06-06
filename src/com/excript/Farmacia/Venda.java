package com.excript.Farmacia;

//Importando Map e HashMap
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import excessoes.CadastroInvalido;

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
		
		for(int i = 0; i < s.length; i++) {
			saida += String.format("\n%d : %d", (int)s[i],(int)this.carrinho.get(s[i]));
		}
		
		return saida;
	}
	
	public void decida(Cliente cliente, Estoque estoque) { //Função de loop da venda
		Scanner scan = new Scanner(System.in);
		System.out.println("Deseja mais alguma coisa?");
		System.out.println("1 - Adicionar outro produto");
		System.out.println("2 - Remover Produto");
		System.out.println("3 - Exibir carrinho de compras");
		System.out.println("4 - Finalizar compras");
		
		int escolha = scan.nextInt();
		
		switch (escolha) {
		case 1:
			this.vendaProduto(cliente, estoque);
			break;
		case 2:
			this.removaProduto(cliente, estoque);
			break;
		case 3: 
			System.out.println(this.toString());
			this.decida(cliente, estoque);
			break;
		case 4:
			break;
		default:
			System.out.println("Erro");
			break;
		}
	}
	
	public void removaProduto(Cliente cliente, Estoque estoque){
		Scanner scan = new Scanner(System.in);
		this.toString();
		System.out.println(this.toString());
		System.out.println("Qual produto deseja remover?");
		int i = scan.nextInt();
		System.out.println("Qual a quantidade");
		int qtd = scan.nextInt();
		this.removerItem(i, qtd);
		
		this.decida(cliente, estoque);
	}
	
	public void vendaProduto(Cliente cliente, Estoque estoque){
		Scanner scan = new Scanner(System.in);
		String nomeProduto;
		int qtd = 0, cod;
		System.out.println("O que deseja comprar?");
		System.out.println(estoque.getMercadorias());
		do {
			nomeProduto = scan.nextLine();
			cod = estoque.buscarProduto(nomeProduto);
			if (cod == -1) {
			System.out.println("Erro, digite novamente");
			}
		} while (cod == -1);
		System.out.println("Digite a quantidade");
		try {
			do {
				qtd = scan.nextInt();
				try {
					if (estoque.consultarQuantidade(cod) < qtd) {
						System.out.println("Erro, quantidade indisponível");;
					}
				} catch (CadastroInvalido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (estoque.consultarQuantidade(cod) < qtd);
		} catch (CadastroInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.adicionarItem(cod, qtd);
		
		this.decida(cliente, estoque);
	}
	
}
