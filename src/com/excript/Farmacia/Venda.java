package com.excript.Farmacia;
//Importando as devidas bibliotecas:
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Venda implements FuncoesVenda {
	Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> carrinho; // Criando o Carrinho de vendas, onde os produtos que estão sendo comprandos são adicionados
    private int idVenda; // Toda venda tem um id proprio
    private static double valorTotalVendas = 0.0; // Para ver o valor total de todas as vendas
    private Date dataVenda;
    private Estoque estoque;
    private double valorTotal;
    private Cliente cliente;

    // Construtor
    public Venda(int idVenda, Cliente cliente, Estoque estoque) {
        this.idVenda = idVenda;
        this.dataVenda = new Date();
        this.carrinho = new ArrayList<>();
        this.valorTotal = 0.0;
        this.cliente = cliente;
        this.estoque = estoque;
    }

    // Getters e Setters
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

    // Funcao para adicionar o produto no carrinho
    public void adicionarProduto(Produto produto) {
        try {
            if (produto.estaVencido()) { // Verifica se o produto está vencido e exibe um alerta
                System.out.println("ATENÇÃO: O produto " + produto.getNome() + " está vencido!");
                System.out.println("Deseja adicionar mesmo assim? (S/N)"); // Pergunta se mesmo vencido, o cliente deseja adicionar o produto ao carrinho
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("N")) {
                    System.out.println("Produto não adicionado ao carrinho.");
                    return;
                }
            }

            if (produto instanceof Medicamento) { // Verifica se o produto é um medicamento
                if (!verificarReceita(produto)) { // Verifica se o medicamento é de receita e solicita ela
                    System.out.println("Produto não adicionado ao carrinho."); // Se for de receita e o cliente não deu, não adiciona ao carrinho
                    return;
                }
            }

            while (true) { // Loop para ficar pedindo a quantidade do produto que você quer adicionar até dar uma resposta válida
                System.out.println("Digite a quantidade do produto a ser adicionada ao carrinho:");
                System.out.println("Produto: " + produto.getNome() + " (" + estoque.quantidadeDisponivel(produto) + ")"); // Mostra quantos daquele produto tem disponivel no estoque

                try {
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidade <= 0) { // Se o usuário colocar um numero negativo
                        System.out.println("Quantidade inválida. Digite um valor positivo maior que zero.");
                    } else if (!estoque.verificarDisponibilidade(produto, quantidade)) { // Ele verifica se o produto esta disponivel no estoque, junto com a quantidade
                        System.out.println("Quantidade indisponível. Apenas " + estoque.quantidadeDisponivel(produto) + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
                    } else {
                        for (int i = 0; i < quantidade; i++) { // Tem o produto no estoque e a quantidade está correta
                            carrinho.add(produto); // Adiciona o produto ao carrinho para cada unidade especificada
                        }
                        produto.setQuantidade(quantidade); // Define a quantidade correta no produto
                        valorTotal += produto.getPreco() * quantidade; // Define o valor total corretamente
                        estoque.adicionarCarrinho(produto, quantidade); // Adicionando no carrinho o produto
                        cliente.getPontos().adicionarPontos(calcularPontos(produto.getPreco() * quantidade)); // Atualiza os pontos do cliente considerando a quantidade
                        estoque.atualizarQtd(); // Atualiza a quantidade daquele produto no estoque
                        return; // Sai da funcao
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número válido."); // Caso o usuario digitou algo invalido, ele repete
                    scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar o produto: " + e.getMessage()); // Deu algum tipo de erro
        }
    }

    // Funcao para calcular quantos pontos ganhou o cliente com a compra
    private int calcularPontos(double valor) {
        int pontos = 0;
        int valorInteiro = (int) valor; // Recebe o valor que é double, no formato inteiro
        int valorRestante = valorInteiro % 100; // Valor restante após múltiplos de 100

        pontos += valorInteiro / 100 * 10; // A cada 100 reais, ganha 10 pontos

        if (valorRestante >= 10) {
            pontos += valorRestante / 10; // A cada 10 reais, ganha 1 ponto
        }

        return pontos;
    }

 // Funcao para exibir o carrinho de compras do cliente
    public void exibirCarrinho(Cliente cliente) {
        System.out.println("Seus itens no carrinho:\n");
        ArrayList<String> nomesQuantidades = new ArrayList<>(); // Criando um ArrayList para armazenar nomes e quantidades dos produtos no carrinho
        
        for (Produto produto : carrinho) { // Itera sobre os produtos no carrinho
            String nome = produto.getNome(); // Obtém o nome do produto
            int quantidade = 0; // Inicializa a quantidade do produto
            
            for (Produto p : carrinho) { // Itera novamente sobre os produtos no carrinho para contar a quantidade
                if (p.getNome().equals(nome)) {
                    quantidade++; // Incrementa a quantidade se o nome do produto atual for igual ao nome do produto sendo verificado
                }
            }
            
            String nomeQuantidade = nome + " (" + quantidade + ")"; // Cria a representação do nome e quantidade do produto
            
            if (!nomesQuantidades.contains(nomeQuantidade)) { // Verifica se o nome e quantidade já foram adicionados ao ArrayList
                nomesQuantidades.add(nomeQuantidade); // Adiciona o nome e quantidade ao ArrayList
                System.out.println(nomeQuantidade); // Exibe o nome e quantidade do produto no carrinho
            }
        }
    }


    private boolean verificarReceita(Produto produto) {
        if (produto instanceof Medicamento) { // Verifica se o produto é uma instância de Medicamento
            Medicamento medicamento = (Medicamento) produto; // Torna o produto um Medicamento

            if (medicamento.iseReceita()) { // Verifica se o medicamento é de receita
                System.out.println("O medicamento " + medicamento.getNome() + " requer receita médica.");
                System.out.println("Você possui a receita? (S/N)");

                String resposta = scanner.nextLine();
                return resposta.equalsIgnoreCase("S"); // Retorna false (se a resposta for "S") ou true (se a resposta for qualquer outra coisa)
            }
        }

        return true; // Se o produto não for um medicamento que requer receita, retorna true por padrão
    }

    
    public void finalizarVenda(Cliente cliente) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy 'Horário:' HH:mm:ss"); // Formatando a data/horario
            String dataFormatada = formatoData.format(getDataVenda()); //Criando uma string que vai receber a nova data 

            System.out.println("Recibo da venda:");
            System.out.println("ID da venda: " + getIdVenda());
            System.out.println("Data da venda: " + dataFormatada);
            System.out.println("Produtos comprados:");

            for (Produto produto : carrinho) {
                System.out.println(produto.getNome() + " - Preço: R$" + produto.getPreco()); // Exibindo todos os produtos e ao lado seus respectivos preços

                if (produto instanceof GiftCard) { // Verifica se o produto é um GiftCard
                    GiftCard giftCard = (GiftCard) produto; // Faz o cast para GiftCard

                    if (!giftCard.isAtivo()) { // Verifica se o GiftCard ainda não está ativado
                        giftCard.ativarGiftCard(); // Ativa o GiftCard
                        System.out.println("GiftCard ativado! Código: " + giftCard.getCodigo());
                    }
                }

                // Remover a quantidade do produto vendida do estoque
                estoque.removerProduto(produto.getNome(), produto.getQuantidade());
            }

            System.out.println("");
            DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Instanciando para que o dinheiro apenas exiba 2 casas decimais depois da vírgula
            String valorFormatado = decimalFormat.format(getValorTotal()); // Criando uma string que vai receber o getValorTotal() no formato do decimalFormat
            System.out.println("Valor total da venda: R$" + valorFormatado); // Ele exibe o valorFormatado, ao invés do getValorTotal(), para evitar várias casas depois da vírgula.

            int pontosCliente = cliente.getPontos().getPontos(); // Pegando quantos pontos o cliente acumulou
            System.out.println("Pontos acumulados: " + pontosCliente);

            if (pontosCliente >= 100) { // Se o cliente tiver mais do que 100 pontos:
                System.out.println("Deseja utilizar os pontos acumulados? (S/N)");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("S")) { // Se ele quer o desconto:
                    double desconto = cliente.getPontos().getDesconto(); // Pega o desconto/
                    double valorComDesconto = getValorTotal() - (getValorTotal() * desconto); // Pega valor com o desconto

                    System.out.println("Desconto aplicado: " + (desconto * 100) + "%"); // Mostra o desconto aplicado
                    String valorFormato = String.format("%.2f", valorComDesconto); 
                    System.out.println("Valor total com desconto: R$" + valorFormato);
                    cliente.getPontos().setPontos(pontosCliente - 100);
                    cliente.mostrarPontos(); // Mostrando os pontos do cliente

                    valorTotalVendas += valorComDesconto;
                } else {
                    System.out.println("Valor total da venda: R$" + getValorTotal());
                    valorTotalVendas += getValorTotal();
                    cliente.mostrarPontos();
                }
            } else {
                valorTotalVendas += getValorTotal();
            }

            // Remover os produtos do carrinho após a venda
            carrinho.clear();

            System.out.println("OBRIGADO POR COMPRAR EM NOSSA FARMÁCIA!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao finalizar a venda.");
            e.printStackTrace();
        }
    }


    // Exibindo o valor total das vendas:
    public void exibirTotalVendas() {
    	try {
    		String valorTotalFormatado = String.format("%.2f", valorTotalVendas); // Convertendo para exibir o valor double até 2 casas depois da vírgula
    		System.out.println("Valor total de todas as vendas: R$" + valorTotalFormatado);
    } catch (Exception e) {  // Tratamento de exceção
    	System.out.println("Ocorreu um erro ao exibir o valor total de todas as vendas");
    	e.printStackTrace();
    	}
    }
}
