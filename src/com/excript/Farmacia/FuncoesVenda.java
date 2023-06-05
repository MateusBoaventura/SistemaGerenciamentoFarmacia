package com.excript.Farmacia;

import mercadoria.Produto;

public interface FuncoesVenda {
	public void adicionarProduto(Produto produto);
	public void finalizarVenda(Cliente cliente);
	public void exibirTotalVendas();
}
