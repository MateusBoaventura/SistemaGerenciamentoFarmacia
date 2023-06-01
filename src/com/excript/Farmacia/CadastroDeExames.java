package com.excript.Farmacia;

import java.util.ArrayList;

public class CadastroDeExames {
	ArrayList<Exame> listaExame = new ArrayList<Exame>();
	
	public boolean checaHorario(Exame exame) {
		for (int i = 0; i < listaExame.size(); i++) {
			Exame compara = listaExame.get(i);
			if (exame.getHorario() == compara.getHorario()) {
				return true;
			}
		}
		return false;
	}
	
	public void cadastraExame(Exame exame) {
		if (checaHorario(exame)) {
			System.out.println("O horário não está disponível");
		} else {
			listaExame.add(exame);
		}
	}
	
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