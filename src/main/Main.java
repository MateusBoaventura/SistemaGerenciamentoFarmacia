package main;

import com.excript.Farmacia.Estoque;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.Comida;

//TEMPORARIO AAAAAAAAAAAAAAAAAAAAAAAA
public class Main {
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {
		Comida c = new Comida("Leite ninho","Nestle",0,"32/13/-2000","Ontem",8001,"Calorias sao mais de 8000!");
		Comida c2 = new Comida("Jorge","Jorge",0,"Jorge","Jorge",0,"Jorge");
		Estoque e = new Estoque();
		e.cadastrarProduto(c, 32);
		e.atualizarQuantidade(32, 300);
		e.cadastrarProduto(c2, 0);
		e.atualizarQuantidade(0, 10);
		System.out.println(e);
	}
}
