package com.excript.Farmacia;

public class Farmacia {
	public static void main(String[] args) {
		
		/*	Para instanciar cada uma das classes:
		 * 	Medicamento(nome, empresa, peso, id, preço, eReceita?, eGenerico?)
		 * 	Cosmetico(nome, empresa, id, preço, categoria, descrição)
		 * 	Snack(nome, empresa, id, preço, categoria, descrição, quantidade)
		 * 	Acessorio(nome, empresa, id, preço)
		 * 	GiftCard(nome, empresa, id, preço, codigo, ativo?)
		 * 	Obs.: sobre o giftCard, ainda há implementações para fazer.
		 * 	Obs.2: ainda vou adicionar as implementações em relação à datas.
		 */
		
		Estoque estoque = new Estoque();
		Medicamento MED1 = new Medicamento("MED1", "Empresa1", 200, 123, 30, false, false);
		estoque.adicionarMedicamento(MED1);
		System.out.println("");
		MED1.MostrarDados(estoque);
		System.out.println("");
		Medicamento MED2 = new Medicamento("MED2", "Empresa2", 250, 123, 20, false, true);
		estoque.adicionarMedicamento(MED2);
		System.out.println("");
		MED2.MostrarDados(estoque);
		System.out.println("");
		estoque.exibirQtd();
		System.out.println("");
		Cosmetico cosmetico1 = new Cosmetico("Gel para cabelo", "Avura", 12345, 50, Cosmetico.categoria.CUIDADOS_CABELO, "Um gel de cor mel para cabelo");
		estoque.adicionarCosmetico(cosmetico1);
		System.out.println("");
		Snack snack1 = new Snack("M&M", "EmpresaM&M", 552, 4.9, Snack.categoria.CHOCOLATE, "Varias bolinhas de chocolate", 1);
		estoque.adicionarSnack(snack1);
		System.out.println("");
		Acessorio luva1 = new Acessorio("Luva", "LuvaCompany", 9942, 3);
		estoque.adicionarAcessorio(luva1);
		System.out.println("");
		GiftCard LoL = new GiftCard("LoL", "RiotGames", 987312, 100, 134134121, false);
		estoque.adicionarGiftCard(LoL);
		System.out.println("");
		Acessorio luva2 = new Acessorio("Luva2", "LuvaCompany", 9942, 3);
		estoque.adicionarAcessorio(luva2);
		System.out.println("");
		luva1.MostrarDados(estoque);
		System.out.println("");
		luva2.MostrarDados(estoque);
		System.out.println("");
		estoque.exibirQtd();
		Venda venda = new Venda(1);
		venda.setEstoque(estoque);
		System.out.println("");
		venda.adicionarProduto(MED1);
		venda.adicionarProduto(LoL);
		System.out.println("");
		venda.finalizarVenda();
		System.out.println("");
		estoque.exibirQtd();
		System.out.println("");
		MED1.MostrarDados(estoque);
		System.out.println("");
		LoL.MostrarDados(estoque);
		System.out.println("");
		Venda venda2 = new Venda(2);
		venda2.setEstoque(estoque);
		venda2.adicionarProduto(LoL);
		venda2.adicionarProduto(MED1);
		venda2.finalizarVenda();
		System.out.println("");
		Venda venda3 = new Venda(3);
		venda3.setEstoque(estoque);
		venda3.adicionarProduto(cosmetico1);
		System.out.println("");
		venda3.finalizarVenda();
		System.out.println("");
		double valorTotalVendas = Venda.getValorTotalVendas();
		System.out.println("Valor total de todas as vendas: R$" + valorTotalVendas);
	}
}
