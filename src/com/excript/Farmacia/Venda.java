package com.excript.Farmacia;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Venda implements FuncoesVenda {
	Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> carrinho; // Criando o Carrinho de vendas, onde os produtos que estão sendo comprandos são adicionados
    private int idVenda;
    private static double valorTotalVendas = 0.0;
    private Date dataVenda;
    private Estoque estoque;
    private double valorTotal;
    private Cliente cliente;

    public Venda(int idVenda, Cliente cliente, Estoque estoque) {
        this.idVenda = idVenda;
        this.dataVenda = new Date();
        this.carrinho = new ArrayList<>();
        this.valorTotal = 0.0;
        this.cliente = cliente;
        this.estoque = estoque;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Produto> produtosVendidos) {
        this.carrinho = produtosVendidos;
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
        if (produto.estaVencido()) {
            System.out.println("ATENÇÃO: O produto " + produto.getNome() + " está vencido!");
            System.out.println("Deseja adicionar mesmo assim? (S/N)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Produto não adicionado ao carrinho.");
                return;
            }
        }
        
        if (produto instanceof Medicamento) {
            if (!verificarReceita(produto)) {
                System.out.println("Produto não adicionado ao carrinho.");
                return;
            }
        }
        if (estoque.verificarDisponibilidade(produto)) {
            carrinho.add(produto);
            valorTotal += produto.getPreco();
            estoque.adicionarCarrinho(produto);
            cliente.getPontos().adicionarPontos(calcularPontos(produto.getPreco()));
        }
    }

    private int calcularPontos(double valor) {
        int pontos = 0;
        int valorInteiro = (int) valor;
        int valorRestante = valorInteiro % 100; // Valor restante após múltiplos de 100

        pontos += valorInteiro / 100 * 10; // A cada 100 reais, ganha 10 pontos

        if (valorRestante >= 10) {
            pontos += valorRestante / 10; // A cada 10 reais, ganha 1 ponto
        }

        return pontos;
    }


    public double calcularValorTotal() {
        return valorTotal;
    }

    public void exibirCarrinho(Cliente cliente) {
        System.out.println("Seus itens no carrinho: \n");
        ArrayList<String> nomesQuantidades = new ArrayList<>();
        for (Produto produto : carrinho) {
            String nome = produto.getNome();
            int quantidade = 0;
            for (Produto p : carrinho) {
                if (p.getNome().equals(nome)) {
                    quantidade++;
                }
            }
            String nomeQuantidade = nome + " (" + quantidade + ")";
            if (!nomesQuantidades.contains(nomeQuantidade)) {
                nomesQuantidades.add(nomeQuantidade);
                System.out.println(nomeQuantidade);
            }
        }
    }

    private boolean verificarReceita(Produto produto) {
        if (produto instanceof Medicamento) {
            Medicamento medicamento = (Medicamento) produto;

            if (medicamento.iseReceita()) {
                System.out.println("O medicamento " + medicamento.getNome() + " requer receita médica.");
                System.out.println("Você possui a receita? (S/N)");

                String resposta = scanner.nextLine();
                return resposta.equalsIgnoreCase("S");
            }
        }

        return true; // Se o produto não for um medicamento que requer receita, retorna true por padrão
    }

    
    public void finalizarVenda(Cliente cliente) {
    	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy 'Horário:' HH:mm:ss"); // Formatando a data/horario
        String dataFormatada = formatoData.format(getDataVenda()); //Criando uma string que vai receber a nova data 

        System.out.println("Recibo da venda:");
        System.out.println("ID da venda: " + getIdVenda());
        System.out.println("Data da venda: " + dataFormatada);
        System.out.println("Produtos comprados:");
        for (Produto produto : carrinho) {
            System.out.println(produto.getNome() + " - Preço: R$" + produto.getPreco());   
            
            if (produto instanceof GiftCard) { // Verifica se o produto é um GiftCard
                GiftCard giftCard = (GiftCard) produto; // Faz o cast para GiftCard

                if (!giftCard.isAtivo()) { // Verifica se o GiftCard ainda não está ativado
                    giftCard.ativarGiftCard(); // Ativa o GiftCard
                    System.out.println("GiftCard ativado! Código: " + giftCard.getCodigo());
                }
            }
        }
        
        System.out.println("");
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Instanciando para que o dinheiro apenas exiba 2 casas decimais depois da virgula
        String valorFormatado = decimalFormat.format(getValorTotal()); // Criando uma string que vai receber o getValorTotal() no formato do decimalFormat
        System.out.println("Valor total da venda: R$" + valorFormatado); // Ele exibe o valorFormatado, ao invés do getValorTotal(), para evitar várias casas depois da vírgula.
        
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
                cliente.getPontos().setPontos(pontosCliente - 100);
                cliente.mostrarPontos();

                valorTotalVendas += valorComDesconto;
            }	else {
                	System.out.println("Valor total da venda: R$" + getValorTotal());
                	valorTotalVendas += getValorTotal();
                	cliente.mostrarPontos();
            	} 
        	}else {
        		valorTotalVendas += getValorTotal();
        	}
        System.out.println("OBRIGADO POR COMPRAR EM NOSSA FARMACIA!");
    	}


    public void exibirTotalVendas() {
    	String valorTotalFormatado = String.format("%.2f", valorTotalVendas);
        System.out.println("Valor total de todas as vendas: R$" + valorTotalFormatado);
    }
}
