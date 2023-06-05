package com.excript.Farmacia;

	// Criando a classe Cliente com seus atributos, getters e setters e funcoes
public class Cliente {
    private String nome, telefone, email, cpf;
    private int pontos;
    private float dinheiro;

    // Construtor vazio
    public Cliente() {
    	this.nome = new String();
    	this.telefone = new String();
    	this.cpf = new String();
    	this.email = new String();
    	this.pontos = 0;
    	this.dinheiro = 0.0f;
    }
    
    // Construtor
    public Cliente(String nome, String telefone, String email, String cpf, int pontos, float dinheiro) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.pontos = pontos;
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public float getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int calculaPontos() {
		double aux = getDinheiro();
		// Verifica se o cliente tem pelo menos 100 reais para ganhar os 10 pontos
		if (aux >= 100.0) {
				pontos += 10;
				aux -= 100.0;
		    }
		// Verifica quantos pontos adicionais o cliente ganha a cada 10 reais
		int pontosExtras = (int) (aux / 10);
			pontos += pontosExtras;
			aux -= pontosExtras * 10;
			return pontos;
	}
	
	public String toString() {
		return String.format("Cliente:%s\nEmail:%s\nCPF:%s\nTelefone:%s\n,Pontos:%d",this.getNome(),this.getEmail(),this.getCpf(),this.getTelefone(),this.getPontos());
	}
}
