package com.excript.Farmacia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Venda implements FuncoesVenda {
	Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> produtosVendidos;
    private int idVenda;
    private static double valorTotalVendas = 0.0;
    private Date dataVenda;
    private Estoque estoque;
    private double valorTotal;
    private Cliente cliente;

    public Venda(int idVenda, Cliente cliente) {
        this.idVenda = idVenda;
        this.dataVenda = new Date();
        this.produtosVendidos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto produto) {
        if (estoque.verificarDisponibilidade(produto)) {
            produtosVendidos.add(produto);
            valorTotal += produto.getPreco();
            estoque.removerProduto(produto);
            cliente.getPontos().adicionarPontos(calcularPontos(produto.getPreco()));
        }
    }

    private int calcularPontos(double valor) {
        int pontos = 0;

        int valorInteiro = (int) valor;
        pontos += valorInteiro / 100 * 10; // A cada 100 reais, ganha 10 pontos
        pontos += valorInteiro / 10; // A cada 10 reais, ganha 1 ponto

        return pontos;
    }

    public double calcularValorTotal() {
        return valorTotal;
    }

    public void finalizarVenda(Cliente cliente) {
        System.out.println("Recibo da venda:");
        System.out.println("ID da venda: " + getIdVenda());
        System.out.println("Data da venda: " + getDataVenda());
        System.out.println("Produtos vendidos:");
        for (Produto produto : produtosVendidos) {
            System.out.println(produto.getNome() + " - Preco: R$" + produto.getPreco());
        }
        System.out.println("Valor total da venda: R$" + getValorTotal());
        
        int pontosCliente = cliente.getPontos().getPontos();
        System.out.println("Pontos acumulados: " + pontosCliente);
        if (pontosCliente >= 100) {
            System.out.println("Deseja utilizar os pontos acumulados? (S/N)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                double desconto = cliente.getPontos().getDesconto();
                double valorComDesconto = getValorTotal() - (getValorTotal() * desconto);

                System.out.println("Desconto aplicado: " + (desconto * 100) + "%");
                String valorFormato = String.format("%.2f", valorComDesconto);
                System.out.println("Valor total com desconto: R$" + valorFormato);

                valorTotalVendas += valorComDesconto;
            }	else {
                	System.out.println("Valor total da venda: R$" + getValorTotal());
                	valorTotalVendas += getValorTotal();
            	} 
        	}else {
        		valorTotalVendas += getValorTotal();
        	}
    	}


    public void exibirTotalVendas() {
    	String valorTotalFormatado = String.format("%.2f", valorTotalVendas);
        System.out.println("Valor total de todas as vendas: R$" + valorTotalFormatado);
    }
}
