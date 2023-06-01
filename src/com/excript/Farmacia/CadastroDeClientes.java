package com.excript.Farmacia;

import java.util.ArrayList;

public class CadastroDeClientes {
	ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public boolean checaEmail(Cliente cliente){
		for (int i = 0 ; i < listaCliente.size(); i++) {
			Cliente compara = listaCliente.get(i);
			if (cliente.getEmail() == compara.getEmail()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checaTelefone(Cliente cliente){
		for (int i = 0 ; i < listaCliente.size(); i++) {
			Cliente compara = listaCliente.get(i);
			if (cliente.getTelefone() == compara.getTelefone()) {
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		if (checaEmail(cliente)) {
			System.out.println("Este email já está sendo usado em outra conta.");
		} else if (checaTelefone(cliente)) {
			System.out.println("Este telefone já está sendo usado em outra conta");
		} else {
			listaCliente.add(cliente);
		}
	}
	
	public void removerCliente(Cliente cliente) {
		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente compara = listaCliente.get(i);
			if (cliente == compara) {
				listaCliente.remove(compara);
				System.out.println("Cliente removido");
				break;
			}
		}
		System.out.println("Cliente não encontrado");
	}
	
	public void atualizarEmail(Cliente cliente, String novoEmail) {
		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente compara = listaCliente.get(i);
			if (cliente == compara) {
				compara.setEmail(novoEmail);
				System.out.println("Email atualizado");
				break;
			}
		}
		System.out.println("Cliente não encontrado");
	}
	
	public void atualizaTelefone(Cliente cliente, String novoTelefone) {
		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente compara = listaCliente.get(i);
			if (cliente == compara) {
				compara.setTelefone(novoTelefone);
				System.out.println("Telefone atualizado");
				break;
			}
		}
		System.out.println("Cliente não encontrado");
	}
}