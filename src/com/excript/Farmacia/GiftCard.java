package com.excript.Farmacia;

//Importando as devidas bibliotecas para fazer o sistema de data:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiftCard extends Produto {
	
	private Estoque estoque; // O Produto GiftCard estará no estoque da nossa farmácia
	private long codigo; // O giftCard é um produto que possui um codigo unico dado pela empresa
	private boolean ativo; // O giftCard pode ou nao estar ativado
	
	// Criando seu construtor
	public GiftCard(String nome, String empresa, int id, double preco, long codigo, boolean ativo, String dataFabricacao, String dataValidade, int quantidade) {
		super(nome, empresa, id, preco, dataFabricacao, dataValidade, quantidade);
		this.codigo = codigo;
		this.ativo = false; // Na farmacia, o giftCard naturalmente é criado desativado.
		this.estoque = null;
	}

	// Getters e Setters
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

	// Funcao basica para ativar o giftCard
	public void ativarGiftCard() {
		if(!ativo) ativo = true;
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
	        if (estoque.verificarProduto(estoque.getGiftCards(), this)) {
	        	System.out.println("Nome: " + getNome());
	            System.out.println("Empresa: " + getEmpresa());
	            System.out.println("Id: " + getId());
	            System.out.println("Preço: R$" + getPreco());
	            System.out.println("Código: " + getCodigo());
	            System.out.println("Está ativado? " + (isAtivo() ? "Sim" : "Não")); // Ele verifica se o giftCard está ativo, true retorna 'Sim', false retorna 'Nao'
	            System.out.println("Data de Fabricação: " + getDataFabricacao());
		        System.out.println("Data de Validade: " + getDataValidade());
		        
		        // As mensagens do giftCard são diferentes
		        if (estaVencido()) {
		            System.out.println("Status: Expirado!");
		        } else {
		            System.out.println("Status: Pode ser resgatado!");
		        }
		    } else {
		        System.out.println("O GiftCard não está no estoque.");
		    }
	    }
	}
