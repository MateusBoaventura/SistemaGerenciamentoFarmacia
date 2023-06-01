package com.excript.Farmacia;

public class Farmacia {
	public static void main(String[] args) {
		
		/*	Para instanciar cada uma das classes:
		 * 	Cliente(nome, telefone, email, pontos)
		 * 	Medicamento(nome, empresa, peso, id, preço, eReceita?, eGenerico?)
		 * 	Cosmetico(nome, empresa, id, preço, categoria, descrição)
		 * 	Snack(nome, empresa, id, preço, categoria, descrição, quantidade)
		 * 	Acessorio(nome, empresa, id, preço)
		 * 	GiftCard(nome, empresa, id, preço, codigo, ativo?)
		 * 
		 * 	Sempre inicie um estoque criando Estoque estoque = new Estoque();
		 * 	No momento, para atribuir pontos à um cliente, é necessário instanciar os pontos e a quantidade.
		 * 	 
		 * 	Obs.: sobre o giftCard, ainda há implementações para fazer.
		 * 	Obs.2: ainda vou adicionar as implementações em relação à datas.
		 */
		
		Estoque estoque = new Estoque();
		Pontos pontosCliente = new Pontos(99);
		Cliente cliente = new Cliente("Mateus", "988449775", "mateus_boaventura@hotmail.com", pontosCliente);
		Venda venda = new Venda(1, cliente);
		venda.setEstoque(estoque);
		Medicamento MED1 = new Medicamento("MED1", "EMPRESA1", 200, 123, 30, false, true);
		System.out.println("");
		estoque.adicionarMedicamento(MED1);
		System.out.println("");
		Snack choco = new Snack("Batom", "Garoto", 784, 2.9, Snack.categoria.CHOCOLATE, "Chocolate ao leite", 1);
		estoque.adicionarSnack(choco);
		System.out.println("");
		estoque.exibirQtd();
		System.out.println("");
		venda.adicionarProduto(MED1);
		venda.adicionarProduto(choco);
		System.out.println("");
		venda.finalizarVenda(cliente);
		System.out.println("");
		venda.exibirTotalVendas();
	}
}
