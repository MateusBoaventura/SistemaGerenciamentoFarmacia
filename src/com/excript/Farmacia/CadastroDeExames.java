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
	public void cadastraExame(Exame exame) {
		if (checaHorario(exame)) {
			System.out.println("O horário não está disponível");
		} else {
			listaExame.add(exame);
		}
	}
	
	// Funcao para remover um exame
	public void removerExame(Exame exame) {
		for (int i = 0; i < listaExame.size(); i++) {
			Exame compara = listaExame.get(i);
			if (exame == compara) {
				listaExame.remove(compara);
				System.out.println("Exame removido");
				break;
			}
		}
		
		System.out.println("Exame não encontrado");
	}
}