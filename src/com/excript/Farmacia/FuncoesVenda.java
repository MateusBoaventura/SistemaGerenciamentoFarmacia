package com.excript.Farmacia;

public interface FuncoesVenda {
	public void adicionarProduto(Produto produto);
	public double calcularValorTotal();
	public void finalizarVenda();
	public void exibirTotalVendas();
}
