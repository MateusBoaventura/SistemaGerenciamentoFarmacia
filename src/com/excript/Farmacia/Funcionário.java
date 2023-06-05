package com.excript.Farmacia;

public class Funcionário {
	private String nome;
	private String senha;
	
	Funcionário(String nome, String senha){
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
	
	public boolean checaNome(String nome, Funcionário funcionário) { //Checa se o nome dado é válido
		if (nome == funcionário.getNome()) {
			return false;
		}
		return true;
	}
	
	public boolean checaSenha(String senha, Funcionário funcionário) { //Checa se a senha dada é válida
		if (senha == funcionário.getSenha()) {
			return false;
		}
		return true;
	}
	
	public boolean loginDeFuncionário(String nome, String senha, Funcionário funcionário) { //Recebe o nome e a senha
		if (checaNome(nome, funcionário)) {
			System.out.println("Nome incorreto"); // Checa se o nome é válido
			return false;
		} else if (checaSenha(senha, funcionário)){
			System.out.println("Senha incorreta"); // Checa se a senha é válida
			return false;
		}
		return true; //Se tudo estiver nos conformes, retorna true
	}
}
