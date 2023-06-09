package main;

import com.excript.Farmacia.*;
import excessoes.*;
import mercadoria.*;
import GUI.*;
import java.awt.*;

public class Main {
	public static Estoque ESTOQUE = new Estoque();
	public static Farmacia FARMACIA = new Farmacia();
	public static CadastroDeExames EXAMES = new CadastroDeExames();
	
	public static void main(String [] args) throws JaCadastrado, CadastroInvalido {

		Farmacia farmacia = new Farmacia();
		farmacia.setEstoque(Main.ESTOQUE);
		//Estoque estoque = new Estoque();		
		Medicamento alivium = new Medicamento("Alivium", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		Main.ESTOQUE.cadastrarProduto(alivium, 23918);
		Main.ESTOQUE.atualizarQuantidade(23918, 10);
		Main.ESTOQUE.atualizarPreco("Alivium", 30);
		Medicamento neosoro = new Medicamento("Neosoro", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		Main.ESTOQUE.cadastrarProduto(neosoro, 32412);
		Main.ESTOQUE.atualizarQuantidade(32412, 8);
		Main.ESTOQUE.atualizarPreco("Neosoro", 4);
		Medicamento paracetamol = new Medicamento("Paracetamol", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, true, false);
		Main.ESTOQUE.cadastrarProduto(paracetamol, 45534);
		Main.ESTOQUE.atualizarQuantidade(45534, 5);
		Main.ESTOQUE.atualizarPreco("Paracetamol", 20);
		Medicamento dipirona = new Medicamento("Dipirona", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, true);
		Main.ESTOQUE.cadastrarProduto(dipirona, 64453);
		Main.ESTOQUE.atualizarPreco(64453, 39);
		Main.ESTOQUE.atualizarQuantidade("Dipirona", 2);
		Medicamento pondera = new Medicamento("Pondera", "EmpresaDeMed", "10/03/2020", "11/04/2025", 150, false, false);
		Main.ESTOQUE.cadastrarProduto(pondera, 12321);
		Main.ESTOQUE.atualizarQuantidade("Pondera", 12);
		Main.ESTOQUE.atualizarPreco("Pondera", 40);
		Cosmetico Dove = new Cosmetico("Dove", "EmpresaDeCosmetico", "01/02/2023","Um desodorante para a pele");
		Main.ESTOQUE.cadastrarProduto(Dove, 67234);
		Main.ESTOQUE.atualizarQuantidade("Dove", 15);
		Main.ESTOQUE.atualizarPreco("Dove", 20);
		Cosmetico batom = new Cosmetico("Batom", "EmpresaDeCosmetico", "02/03/2023","Um brilho aos seus lábios");
		Main.ESTOQUE.cadastrarProduto(batom, 43522);
		Main.ESTOQUE.atualizarQuantidade("Batom", 10);
		Main.ESTOQUE.atualizarPreco("Batom", 4);
		Cosmetico Esmalte = new Cosmetico("Esmalte", "EmpresaDeCosmetico", "01/04/2023","Esmalte de cor rosa");
		Main.ESTOQUE.cadastrarProduto(Esmalte, 12134);
		Main.ESTOQUE.atualizarQuantidade(12134, 4);
		Main.ESTOQUE.atualizarPreco("Esmalte", 10);
		Comida batomGaroto = new Comida("Batom Garoto", "EmpresaChocolate", "24/02/2023", "23/06/2023", 140, "Chocolate ao leite");
		Main.ESTOQUE.cadastrarProduto(batomGaroto, 99291);
		Main.ESTOQUE.atualizarQuantidade(99291, 14);
		Main.ESTOQUE.atualizarPreco(99291, 4);
		Comida Fandangos = new Comida("Fandangos", "EmpresaSalgado", "19/03/2023", "23/09/2023", 200, "Salgadinho");
		Main.ESTOQUE.cadastrarProduto(Fandangos, 31231);
		Main.ESTOQUE.atualizarQuantidade("Fandangos", 14);
		Main.ESTOQUE.atualizarPreco(31231, 9);
		Comida Chiclete = new Comida("Chiclete", "EmpresaGoma", "25/05/2023", "14/06/2023", 10, "Mastigar");
		Main.ESTOQUE.cadastrarProduto(Chiclete, 43254);
		Main.ESTOQUE.atualizarQuantidade("Chiclete", 88);
		Variado luva = new Variado("Luva", "EmpresaAcessorio", "01/06/2023", "Uma luva!");
		Main.ESTOQUE.cadastrarProduto(luva, 12911);
		Main.ESTOQUE.atualizarQuantidade(12911, 5);
		Main.ESTOQUE.atualizarPreco(12911, 3);
		Variado Mascara = new Variado("Mascara", "EmpresaAcessorio", "02/06/2023", "Uma mascara!");
		Main.ESTOQUE.cadastrarProduto(Mascara, 12311);
		Main.ESTOQUE.atualizarQuantidade("Mascara", 9);
		Main.ESTOQUE.atualizarPreco(12311, 8);
		GiftCard LoL = new GiftCard("LOL RIOT POINTS", "Riot Games", "01/01/2023", "23/10/2023", 30, "League of Legends");
		Main.ESTOQUE.cadastrarProduto(LoL, 32312);
		Main.ESTOQUE.atualizarQuantidade("LOL RIOT POINTS", 3);
		Main.ESTOQUE.atualizarPreco("LOL RIOT POINTS", 100);
		Cliente Joao = new Cliente("João", "99802-4532", "emailjoao@gmail.com", "312.312.321-98", 0);
		farmacia.cadastrarCliente(Joao);
		Cliente Maria = new Cliente("Maria", "91231-9812", "emailMaria@gmail.com", "212.312.321-98", 30);
		farmacia.cadastrarCliente(Maria);
		
		
// =====================================================================================================================================================================================   //		
		
		System.out.println(Main.ESTOQUE);
		System.out.println("");
		System.out.println("===================Clientes==================");
		System.out.println(Joao);
		System.out.println("");
		System.out.println(Maria);
		System.out.println("==============================================");
		System.out.println("");
		Venda venda = new Venda(Joao);
		venda.adicionarItem(32312, 1);
		venda.adicionarItem(99291, 5);
		System.out.println(venda);
		System.out.println("");
//		venda.removerItem(32312, 1);
		System.out.println(venda);
//		farmacia.consultarTotal(venda);
		System.out.println("");
//		farmacia.finalizarVenda(venda, true);
//		System.out.println("");
//		venda.removerItem(99291, 3);
		System.out.println(venda);

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
