package main;

<<<<<<< HEAD
import com.excript.Farmacia.Estoque;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
=======
import mercadoria.Medicamento;
>>>>>>> dbc9ffd2d5c070ef9f05015a999e70b3e406703a
import mercadoria.Comida;
import mercadoria.Cosmetico;
import mercadoria.GiftCard;

//TEMPORARIO AAAAAAAAAAAAAAAAAAAAAAAA
public class Main {
<<<<<<< HEAD
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {
		Comida c = new Comida("Leite ninho","Nestle",0,"32/13/-2000","Ontem",8001,"Calorias sao mais de 8000!");
		Comida c2 = new Comida("Jorge","Jorge",0,"Jorge","Jorge",0,"Jorge");
		Estoque e = new Estoque();
		e.cadastrarProduto(c, 32);
		e.atualizarQuantidade(32, 300);
		e.cadastrarProduto(c2, 0);
		e.atualizarQuantidade(0, 10);
=======
	public static void main(String [] args) {
		Medicamento m = new Medicamento("Dipirona", "EmpresaMed", "07/07/2017", "09/8/2023", 250, true, false);
		Comida c = new Comida("Leite ninho","Nestle","32/13/-2000","Ontem",8001,"Calorias sao mais de 8000!");
		Cosmetico d = new Cosmetico("Sabonete", "SaboneteNew", "02/02/2022", "Pra lavar o rosto");
		GiftCard e = new GiftCard("LoL", "Riot Games", "02/02/2021", "05/05/2024", 100, "League of Legends");
		System.out.println(m);
		System.out.println("");
		System.out.println(c);
		System.out.println("");
		System.out.println(d);
		System.out.println("");
>>>>>>> dbc9ffd2d5c070ef9f05015a999e70b3e406703a
		System.out.println(e);
	}
}
