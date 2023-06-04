package com.excript.Farmacia;

public class Farmacia {
	public static void main(String[] args) {
		
		/*	Para instanciar cada uma das classes:
		 * 	Cliente(nome, telefone, email, pontos)
		 * 	Medicamento(nome, empresa, peso, id, preço, eReceita?, eGenerico, DataFabricacao, dataValidade, quantida)
		 * 	Cosmetico(nome, empresa, id, preço, categoria, descrição, DataFabricacao, dataValidade, quantida)
		 * 	Categorias cosmetico: MAQUIAGEM, CUIDADOS_PELE, CUIDADOS_CABELO, FRAGRANCIAS, OUTROS;
		 * 	Snack(nome, empresa, id, preço, categoria, descrição, quantidade, DataFabricacao, dataValidade, quantida)
		 * 	Categorias Snacks: SALGADINHO, BISCOITO, BARRA_DE_CEREAL, CHOCOLATE;
		 * 	Acessorio(nome, empresa, id, preço, DataFabricacao, dataValidade, quantida)
		 * 	GiftCard(nome, empresa, id, preço, codigo, ativo?, DataFabricacao, dataValidade, quantida)
		 * 
		 * 	Sempre inicie um estoque criando Estoque estoque = new Estoque();
		 * 	Sempre inicie Pontos com 0 (é o padrão);
		 * 	Inicie um CadastroDeClientes;
		 * 	
		 * 	Para cadastrar um novo cliente: (nome, telefone, email, pontosCliente);
		 * 	Para realizar uma venda: instancie uma venda:
		 * 	Venda venda1 = new Venda(idVenda, cliente);
		 * 	Para iniciar os pontos, instancie Pontos pontosCliente = new Pontos(0); 	
		 * 	
		 */
		
		Estoque estoque = new Estoque();
		Pontos pontosCliente = new Pontos(0);
		CadastroDeClientes clientes = new CadastroDeClientes();
		Cliente MariaLuiza = new Cliente("Maria Luiza", "0000000", "mariaLuiza@gmail.com", pontosCliente);
		clientes.cadastrarCliente(MariaLuiza);
		Medicamento alivium = new Medicamento("Alivium", "EmpresaDeMed", 180, 32873, 39.9, false, false, "10/03/2020", "11/04/2025", 3);
		estoque.adicionarProduto(alivium);
		Medicamento dipirona = new Medicamento("Dipirona", "EmpresaMed", 100, 23030, 10, false, false, "10/10/2020", "10/09/2024", 3);
		estoque.adicionarProduto(dipirona);
		Medicamento dipirona2 = new Medicamento("Dipirona2", "EmpresaDeMed", 180, 11112, 20, false, false, "10/03/2022", "11/07/2023", 1);
		estoque.adicionarProduto(dipirona2);
		Medicamento paracetamol = new Medicamento("Paracetamol", "EmpresaDeMed", 180, 14321, 39.9, false, false, "10/03/2022", "11/07/2023", 1);
		estoque.adicionarProduto(paracetamol);
		Medicamento pondera = new Medicamento("Paracetamol", "EmpresaDeMed", 180, 14321, 39.9, false, true, "10/03/2022", "11/07/2023", 2);
		estoque.adicionarProduto(pondera);
		Cosmetico Dove = new Cosmetico("Dove", "EmpresaDeCosmetico", 43532, 19.9, Cosmetico.categoria.CUIDADOS_PELE, "Um desodorante para a pele", "01/02/2023", "08/04/2024", 3);
		estoque.adicionarProduto(Dove);
		Cosmetico BatomVinho = new Cosmetico("Batom Vinho", "EmpresaDeCosmetico", 54321, 4.9, Cosmetico.categoria.MAQUIAGEM, "Batom de cor vinho escuro", "02/03/2023", "04/01/2024", 3);
		estoque.adicionarProduto(BatomVinho);
		Cosmetico Esmalte = new Cosmetico("Esmalte rosa", "EmpresaDeCosmetico", 66676, 3, Cosmetico.categoria.MAQUIAGEM, "Um esmalte rosa", "22/03/2023", "10/05/2025", 2);
		estoque.adicionarProduto(Esmalte);
		Snack batom = new Snack("Batom Garoto", "EmpresaSnack", 99876, 2.9, Snack.categoria.CHOCOLATE, "Chocolate ao leite", 1, "24/02/2023", "23/06/2023", 2);
		estoque.adicionarProduto(batom);
		Snack Pacotebatom = new Snack("Pacote Batom Garoto", "EmpresaSnack", 24231, 29.9, Snack.categoria.CHOCOLATE, "Pacote com 11 batons, chocolate ao leite", 11, "24/03/2023", "23/09/2023", 4);
		estoque.adicionarProduto(Pacotebatom);
		Snack DiamanteNegro = new Snack("Diamante Negro", "EmpresaSnack", 75643, 18.9, Snack.categoria.CHOCOLATE, "Chocolate ao leite com amendoim", 1, "24/02/2023", "23/05/2023", 2);
		estoque.adicionarProduto(DiamanteNegro);
		Acessorio luva = new Acessorio("Luva", "EmpresaAcessorio", 23232, 4.9, "01/06/2023", "14/10/2026", 5);
		estoque.adicionarProduto(luva);
		Acessorio AcessorioCaro = new Acessorio("AcessorioCaro", "EmpresaAcessorio", 23233, 400, "01/06/2023", "16/11/2025", 5);
		estoque.adicionarProduto(AcessorioCaro);
		GiftCard LoL = new GiftCard("LOL RIOT POINTS", "Riot Games", 321, 100, 420347138, false, "01/01/2023", "23/10/2023", 3);
		estoque.adicionarProduto(LoL);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		MariaLuiza.mostrarDados();
		Cliente LailaDoida = new Cliente("Laila Doida", "3243230", "lailadoida@gmail.com", pontosCliente);
		System.out.println("");
		clientes.atualizarTelefone(LailaDoida, "99532761");
		System.out.println("");
		clientes.atualizarTelefone(MariaLuiza, "99532761");
		System.out.println("");
		System.out.println("");
		MariaLuiza.mostrarDados();
		System.out.println("");
		estoque.exibirQtd();
		System.out.println("");
		estoque.exibirListaProdutos();
		System.out.println("");
		Venda venda = new Venda(95483, MariaLuiza, estoque);
		System.out.println("");
		Pacotebatom.MostrarDados(estoque);
		System.out.println("");
		venda.adicionarProduto(Pacotebatom);
		System.out.println("");
		venda.adicionarProduto(paracetamol);
		System.out.println("");
		venda.adicionarProduto(LoL);
		System.out.println("");
		venda.exibirCarrinho(MariaLuiza);
		System.out.println("");
		venda.adicionarProduto(luva);
		System.out.println("");
		venda.exibirCarrinho(MariaLuiza);
		System.out.println("");
		venda.finalizarVenda(MariaLuiza);
		System.out.println("");
		MariaLuiza.mostrarDados();
		System.out.println("");
		estoque.removerProduto("Dipirona", 1);
		System.out.println("");
		estoque.removerProduto("Diamante Negro", 2);
		System.out.println("");
		estoque.removerProduto("Dove", 4);
		System.out.println("");
		estoque.exibirListaProdutos();
		System.out.println("");
		estoque.exibirQtd();
	}
}
