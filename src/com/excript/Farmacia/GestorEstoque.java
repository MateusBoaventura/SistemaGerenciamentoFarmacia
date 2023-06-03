package com.excript.Farmacia;

public interface GestorEstoque {
	public boolean verificarCodigo(int codigo);
	public boolean verificarDisponibilidade(Produto produto);
	public boolean adicionarCarrinho(Produto produto);
	public void atualizarQtd();
	public boolean adicionarMedicamento(Produto Medicamento);
	public boolean removerMedicamento(int codigoMedicamento);
	public boolean adicionarAcessorio(Produto Acessorio);
	public boolean removerAcessorio(int codigoAcessorio);
	public boolean adicionarCosmetico(Produto Cosmetico);
	public boolean removerCosmetico(int codigoCosmetico);
	public boolean adicionarGiftCard(Produto GiftCard);
	public boolean removerGiftCard(int codigoGiftCard);
	public boolean adicionarSnack(Produto Snack);
	public boolean removerSnack(int codigoSnack);
	public void exibirQtd();
}
