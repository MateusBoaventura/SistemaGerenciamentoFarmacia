package com.excript.Farmacia;

import java.util.List;

public interface GestorEstoque {
	public boolean verificarCodigo(int codigo);
	public boolean verificarDisponibilidade(Produto produto, int quantidade);
	public boolean adicionarCarrinho(Produto produto, int quantidade);
	public void exibirListaProdutos();
	public boolean verificarProduto(List<Produto> produtos, Produto produto);
	public boolean adicionarProduto(Produto produto);
	public boolean removerProduto(String nomeProduto, int quantidade);
	public void atualizarQtd();
	public void exibirQtd();
}
