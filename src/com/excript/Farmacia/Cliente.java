package com.excript.Farmacia;

	// Criando a classe Cliente com seus atributos, getters e setters e funcoes
public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private Pontos pontos;

    // Construtor
    public Cliente(String nome, String telefone, String email, Pontos pontos) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
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

    public Pontos getPontos() {
        return pontos;
    }

    public void setPontos(Pontos pontos) {
        this.pontos = pontos;
    }
    
    // Ele mostra quantos pontos tem o cliente, pegando o valor lá da classe Pontos
    public void mostrarPontos() {
        System.out.println("Pontos acumulados: " + pontos.getPontos());
    }
    
    // Mostrando os dados do cliente
    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Pontos acumulados: " + pontos.getPontos());
    }
}
