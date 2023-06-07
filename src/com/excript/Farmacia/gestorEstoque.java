package com.excript.Farmacia;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.Produto;

public interface gestorEstoque {
	
	public void cadastrarProduto(Produto produto, int codigo) throws JaCadastrado;
	public void removerProduto(int codigo) throws CadastroInvalido;
	public int buscarProduto(String nome);
	
}
