package com.excript.Farmacia;
import java.util.ArrayList;
import java.util.Date;

public class Venda implements FuncoesVenda {
	private ArrayList<Produto> produtosVendidos;
	private int idVenda;
	private static double valorTotalVendas = 0.0;
	private Date dataVenda;
	private Estoque estoque;
	private double valorTotal;
	
	public Venda(int idVenda) {
		this.idVenda = idVenda;
		this.dataVenda = new Date();
		this.produtosVendidos = new ArrayList<>();
		this.valorTotal = 0.0;
	}
	
	
	
	public ArrayList<Produto> getProdutosVendidos() {
		return produtosVendidos;
	}
	public void setProdutosVendidos(ArrayList<Produto> produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}	
	public static double getValorTotalVendas() {
		return valorTotalVendas;
	}
	public static void setValorTotalVendas(double valorTotalVendas) {
		Venda.valorTotalVendas = valorTotalVendas;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public void adicionarProduto(Produto produto) {
        if (estoque.verificarDisponibilidade(produto)) {
            produtosVendidos.add(produto);
            valorTotal += produto.getPreco();
            estoque.removerProduto(produto);
        }
    }
	
	public double calcularValorTotal() {
		return valorTotal;
	}
	
	public void finalizarVenda() {
		System.out.println("Recibo da venda:");
		System.out.println("ID da venda: " + getIdVenda());
		System.out.println("Data da venda: " + getDataVenda());
		System.out.println("Produtos vendidos:");
		for (Produto produto : produtosVendidos) {
	          System.out.println(produto.getNome() + " - Preco: R$" + produto.getPreco());
	      }
		System.out.println("Valor total da venda: R$" + getValorTotal());
		valorTotalVendas += getValorTotal();
	}
	
	public void exibirTotalVendas() {
		System.out.println("Valor total de todas as vendas: R$" + getValorTotalVendas());
	}
}
