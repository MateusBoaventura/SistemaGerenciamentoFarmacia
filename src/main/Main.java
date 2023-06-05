package main;

import com.excript.Farmacia.Estoque;
import com.excript.Farmacia.Funcionario;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.Comida;
import Interface.TelaLogin;


public class Main {
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {
		
		Funcionario Mateus = new Funcionario("Mateus", "123");
		Funcionario Victor = new Funcionario("Victor", "1234");
		String c = Mateus.toString();
		String e = Victor.toString();
		System.out.println(c);
		System.out.println(e);
		new TelaLogin();
		
		//Comida c = new Comida("Leite ninho","Nestle","32/13/-2000","Ontem",8001,"Calorias sao mais de 8000!");
		//Comida c2 = new Comida("Jorge","Jorge","Jorge","Jorge",0,"Jorge");
		//Estoque e = new Estoque();
		//e.cadastrarProduto(c, 32);
		//e.atualizarQuantidade(32, 300);
		//e.cadastrarProduto(c2, 0);
		//e.atualizarQuantidade(0, 10);
		//e.atualizarPreco(32, 20.3f);
		//System.out.println(e);
	}
}
