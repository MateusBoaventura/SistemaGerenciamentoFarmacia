package com.excript.Farmacia;

	// Criando a classe Cliente com seus atributos, getters e setters e funcoes
public class Cliente {
    private String nome, telefone, email, cpf;
    private int pontos;

    // Construtor vazio
    public Cliente() {
    	this.nome = new String();
    	this.telefone = new String();
    	this.cpf = new String();
    	this.email = new String();
    	this.pontos = 0;
    }
    
    // Construtor
    public Cliente(String nome, String telefone, String email, String cpf, int pontos) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.pontos = pontos;
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

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String toString() {
		return String.format("Cliente:%s\nEmail:%s\nCPF:%s\nTelefone:%s\nPontos:%d",this.getNome(),this.getEmail(),this.getCpf(),this.getTelefone(),this.getPontos());
	}

}
