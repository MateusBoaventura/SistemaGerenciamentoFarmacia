package com.excript.Farmacia;

public interface FuncoesVenda {
	public void adicionarProduto(Produto produto);
	public double calcularValorTotal();
	public void finalizarVenda(Cliente cliente);
	public void exibirTotalVendas();
}
