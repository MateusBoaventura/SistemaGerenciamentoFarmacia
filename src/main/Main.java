package main;

import com.excript.Farmacia.*;
import excessoes.*;
import mercadoria.*;


public class Main {
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {

		Farmacia farmacia = new Farmacia();
		Estoque e = new Estoque();
		Funcionario Mateus = new Funcionario("Mateus", "123");
		Funcionario Victor = new Funcionario("Victor", "1234");
		Comida c = new Comida("Leite ninho","Nestle","07/08/2022","01/04/2025",123,"Calorias sao mais de 8000!");
		Comida c2 = new Comida("Danone","DanoneCompany","02/04/2023","07/07/2025",342,"Danoninho seu amiguinho");
		e.cadastrarProduto(c, 32);
		e.atualizarQuantidade(32, 300);
		e.cadastrarProduto(c2, 0);
		e.atualizarQuantidade(0, 10);
		e.atualizarPreco(32, 20.3f);
		System.out.println(c);
		System.out.println("");
		System.out.println(c2);
		System.out.println("");
		Cliente cliente = new Cliente();
		
		Venda venda = new Venda(cliente);
		
		venda.adicionarItem(32, 30);
		farmacia.finalizarVenda(venda);
		//farmacia.finalizarVenda(venda);

	}
}
