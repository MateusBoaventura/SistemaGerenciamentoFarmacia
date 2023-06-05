package com.excript.Farmacia;

import excessoes.LoginInvalido;

public class Funcionario {
	
	private String nome, senha;
	
	// Construtor vazio
	public Funcionario() {
		this.nome = new String();
		this.senha = new String();
	}
	
	public Funcionario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean loginFuncionario(String nome, String senha) throws LoginInvalido {
		if (nome.equals(this.getNome()) && senha.equals(this.getSenha())) {
			return true;
		}
		throw new LoginInvalido();
	}
	
	public String toString() {
		return String.format("Funcionario: %s\nSenha: %s", this.getNome(), this.getSenha());
	}
}
