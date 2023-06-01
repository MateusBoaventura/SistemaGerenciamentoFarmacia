package com.excript.Farmacia;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private Pontos pontos;
    
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
}