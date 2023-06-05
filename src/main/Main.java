package main;

import mercadoria.Medicamento;
import mercadoria.Comida;
import mercadoria.Cosmetico;
import mercadoria.GiftCard;

//TEMPORARIO AAAAAAAAAAAAAAAAAAAAAAAA
public class Main {
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
		System.out.println(e);
	}
}
