package com.excript.Farmacia;

import java.util.ArrayList; // Importando uma arrayList

public class CadastroDeExames {
	ArrayList<Exame> listaExame = new ArrayList<Exame>(); // Criando uma lista de Exames
	
	// Funcao para checar o horário
	public boolean checaHorario(Exame exame) {
		for (int i = 0; i < listaExame.size(); i++) {
			Exame compara = listaExame.get(i);
			if (exame.getHorario() == compara.getHorario()) {
				return true;
			}
		}
		return false;
	}
	
	// Funcao para cadastrar um exame
	public boolean cadastraExame(Exame exame) {
		if (checaHorario(exame)) {
			return true;
		} else {
			listaExame.add(exame);
		}
		return false;
	}
	
	// Funcao para remover um exame
	public boolean removerExame(String email) {
		for (int i = 0; i < listaExame.size(); i++) {
			Exame compara = listaExame.get(i);
			Cliente comparaEmail = compara.getCliente();
			if (email == comparaEmail.getEmail()) {
				listaExame.remove(compara);
				return true;
			}
		}
		
		return false;
	}
}