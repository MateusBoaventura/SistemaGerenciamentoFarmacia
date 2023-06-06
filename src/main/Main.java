package main;

import com.excript.Farmacia.*;
import excessoes.*;
import mercadoria.*;
import GUI.*;
import java.awt.*;

public class Main {
	public static Estoque ESTOQUE = new Estoque();
	/*
	Onde tinha "estoque", vc vai botar Main.ESTOQUE
	
	Vide TelaAdicionarCosmetico
	*/
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {

		Farmacia farmacia = new Farmacia();
		Estoque estoque = new Estoque();
		Funcionario Mateus = new Funcionario("Mateus", "123");
		Funcionario Victor = new Funcionario("Victor", "1234");		
		Medicamento alivium = new Medicamento("Alivium", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		estoque.cadastrarProduto(alivium, 23918);
		estoque.atualizarQuantidade(23918, 10);
		Medicamento neosoro = new Medicamento("Neosoro", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		estoque.cadastrarProduto(neosoro, 32412);
		estoque.atualizarQuantidade(32412, 8);
		Medicamento paracetamol = new Medicamento("Paracetamol", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, true, false);
		estoque.cadastrarProduto(paracetamol, 45534);
		estoque.atualizarQuantidade(45534, 5);
		Medicamento dipirona = new Medicamento("Dipirona", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, true);
		estoque.cadastrarProduto(dipirona, 64453);
		estoque.atualizarQuantidade("Dipirona", 2);
		Medicamento pondera = new Medicamento("Pondera", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		estoque.cadastrarProduto(pondera, 12321);
		estoque.atualizarQuantidade("Pondera", 12);
		Cosmetico Dove = new Cosmetico("Dove", "EmpresaDeCosmetico", "01/02/2023","Um desodorante para a pele");
		estoque.cadastrarProduto(Dove, 67234);
		estoque.atualizarQuantidade("Dove", 15);
		Cosmetico batom = new Cosmetico("Batom", "EmpresaDeCosmetico", "02/03/2023","Um brilho aos seus lábios");
		estoque.cadastrarProduto(batom, 43522);
		estoque.atualizarQuantidade("Batom", 10);
		Cosmetico Esmalte = new Cosmetico("Esmalte", "EmpresaDeCosmetico", "01/04/2023","Esmalte de cor rosa");
		estoque.cadastrarProduto(Esmalte, 12134);
		estoque.atualizarQuantidade(12134, 4);
		Comida batomGaroto = new Comida("Batom Garoto", "EmpresaChocolate", "24/02/2023", "23/06/2023", 140, "Chocolate ao leite");
		estoque.cadastrarProduto(batomGaroto, 99291);
		estoque.atualizarQuantidade(99291, 14);
		estoque.atualizarPreco(99291, 4);
		Comida Fandangos = new Comida("Fandangos", "EmpresaSalgado", "19/03/2023", "23/09/2023", 200, "Salgadinho");
		estoque.cadastrarProduto(Fandangos, 31231);
		estoque.atualizarQuantidade("Fandangos", 14);
		Comida Chiclete = new Comida("Chiclete", "EmpresaGoma", "25/05/2023", "14/06/2023", 10, "Mastigar");
		estoque.cadastrarProduto(Chiclete, 43254);
		estoque.atualizarQuantidade("Chiclete", 88);
		Variado luva = new Variado("Luva", "EmpresaAcessorio", "01/06/2023", "Uma luva!");
		estoque.cadastrarProduto(luva, 12911);
		estoque.atualizarQuantidade(12911, 5);
		Variado Mascara = new Variado("Mascara", "EmpresaAcessorio", "02/06/2023", "Uma mascara!");
		estoque.cadastrarProduto(Mascara, 12311);
		estoque.atualizarQuantidade("Mascara", 9);
		GiftCard LoL = new GiftCard("LOL RIOT POINTS", "Riot Games", "01/01/2023", "23/10/2023", 30, "League of Legends");
		estoque.cadastrarProduto(LoL, 32312);
		estoque.atualizarQuantidade("LOL RIOT POINTS", 3);
		estoque.atualizarPreco("LOL RIOT POINTS", 100);
		Cliente Joao = new Cliente("João", "99802-4532", "emailjoao@gmail.com", "312.312.321-98", 0);
		farmacia.cadastrarCliente(Joao);
		Cliente Maria = new Cliente("Maria", "91231-9812", "emailMaria@gmail.com", "212.312.321-98", 30);
		farmacia.cadastrarCliente(Maria);
//		Venda venda = new Venda(Joao);
//		venda.adicionarItem(32312, 1);
//		venda.adicionarItem(99291, 5);
//		System.out.println(venda);
//		System.out.println("");
//		venda.removerItem(32312, 1);
//		System.out.println(venda);
//		farmacia.finalizarVenda(venda, true);
//		System.out.println("");
//		venda.removerItem(99291, 3);
//		System.out.println(venda);
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Criar a instância da tela TelaEstoque
                    TelaLogin inicio = new TelaLogin();

                    // Tornar a tela visível
                    inicio.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
		
}
