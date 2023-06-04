package com.excript.Farmacia;

//Importando as devidas bibliotecas para fazer o sistema de data, ArrayLists, Maps e HashMaps:
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Estoque implements GestorEstoque {
	
	private static int qtdMedicamento, qtdAcessorio, qtdGiftCard, qtdSnack, qtdCosmetico; // Essas quantidades representarão quanto de cada tipo de produto possui no estoque
	
	// Criando uma lista para cada tipo de produto:
	private ArrayList<Produto> Medicamentos;
	private ArrayList<Produto> Acessorios;
	private ArrayList<Produto> GiftCards;
	private ArrayList<Produto> Snacks;
	private ArrayList<Produto> Cosmeticos;
	
	// Construtor:
	public Estoque() {
		Medicamentos = new ArrayList<>();
		Acessorios = new ArrayList<>();
		GiftCards = new ArrayList<>();
		Snacks = new ArrayList<>();
		Cosmeticos = new ArrayList<>();
	}
	
	// Getters e Setters
	public static int getQtdMedicamento() {
		return qtdMedicamento;
	}
	public static void setQtdMedicamento(int qtdMedicamento) {
		Estoque.qtdMedicamento = qtdMedicamento;
	}
	public static int getQtdAcessorio() {
		return qtdAcessorio;
	}
	public static void setQtdAcessorio(int qtdAcessorio) {
		Estoque.qtdAcessorio = qtdAcessorio;
	}
	public static int getQtdGiftCard() {
		return qtdGiftCard;
	}
	public static void setQtdGiftCard(int qtdGiftCard) {
		Estoque.qtdGiftCard = qtdGiftCard;
	}
	public static int getQtdSnack() {
		return qtdSnack;
	}
	public static void setQtdSnack(int qtdSnack) {
		Estoque.qtdSnack = qtdSnack;
	}
	public static int getQtdCosmetico() {
		return qtdCosmetico;
	}
	public static void setQtdCosmetico(int qtdCosmetico) {
		Estoque.qtdCosmetico = qtdCosmetico;
	}
	public ArrayList<Produto> getMedicamentos() {
		return Medicamentos;
	}
	public void setMedicamentos(ArrayList<Produto> medicamentos) {
		Medicamentos = medicamentos;
	}
	public ArrayList<Produto> getAcessorios() {
		return Acessorios;
	}
	public void setAcessorios(ArrayList<Produto> acessorios) {
		Acessorios = acessorios;
	}
	public ArrayList<Produto> getGiftCards() {
		return GiftCards;
	}
	public void setGiftCards(ArrayList<Produto> giftCards) {
		GiftCards = giftCards;
	}
	public ArrayList<Produto> getSnacks() {
		return Snacks;
	}
	public void setSnacks(ArrayList<Produto> snacks) {
		Snacks = snacks;
	}
	public ArrayList<Produto> getCosmeticos() {
		return Cosmeticos;
	}
	public void setCosmeticos(ArrayList<Produto> cosmeticos) {
		Cosmeticos = cosmeticos;
	}

	// Funcao para verificar se o codigo do produto é igual ao código de outro produto (quantidas não vale)
	public boolean verificarCodigo(int codigo) {
	    for (Produto medicamento : Medicamentos) { // Quando o produto for um Medicamento, ele percorre toda a lista dos Medicamentos
	        if (medicamento.getId() == codigo && medicamento.getQuantidade() > 0) { // Se o Id daquele medicamento for igual ao iD de um medicamento que já existe no estoque
	            return true; // Ele retorna true, dizendo que há um medicamento com Id igual ao novo;
	        }
	    }
	    
	    // Repetindo o processo para o resto dos produtos:
	    for (Produto acessorio : Acessorios) {
	        if (acessorio.getId() == codigo && acessorio.getQuantidade() > 0) {
	            return true;
	        }
	    }

	    for (Produto cosmetico : Cosmeticos) {
	        if (cosmetico.getId() == codigo && cosmetico.getQuantidade() > 0) {
	            return true;
	        }
	    }

	    for (Produto giftCard : GiftCards) {
	        if (giftCard.getId() == codigo && giftCard.getQuantidade() > 0) {
	            return true;
	        }
	    }

	    for (Produto snack : Snacks) {
	        if (snack.getId() == codigo && snack.getQuantidade() > 0) {
	            return true;
	        }
	    }

	    return false; // Caso os id's forem diferentes, ele retorna false
	}

	
	// Nesta função, ele verifica se o produto e a quantidade dele estão disponíveis no estoque
	public boolean verificarDisponibilidade(Produto produto, int quantidade) {
	    if (produto instanceof Medicamento) { // Se a instância do produto for um medicamento
	        Medicamento medicamento = (Medicamento) produto; // Faz o cast do produto para o tipo Medicamento
	     // Verifica se o medicamento está presente na lista de Medicamentos e se a quantidade disponível é maior ou igual à quantidade solicitada
	        return Medicamentos.contains(medicamento) && medicamento.getQuantidade() >= quantidade;
	     // Faz a mesma coisa para os demais produtos:
	    } else if (produto instanceof Cosmetico) {
	        Cosmetico cosmetico = (Cosmetico) produto; 
	        return Cosmeticos.contains(cosmetico) && cosmetico.getQuantidade() >= quantidade; 
	    } else if (produto instanceof GiftCard) { 
	        GiftCard giftCard = (GiftCard) produto; 
	        return GiftCards.contains(giftCard) && giftCard.getQuantidade() >= quantidade; 
	    } else if (produto instanceof Snack) {
	        Snack snack = (Snack) produto;
	        return Snacks.contains(snack) && snack.getQuantidade() >= quantidade; 
	    } else if (produto instanceof Acessorio) {
	        Acessorio acessorio = (Acessorio) produto; 
	        return Acessorios.contains(acessorio) && acessorio.getQuantidade() >= quantidade;
	    } else {
	        return false; // Caso o produto não seja nenhum dos tipos esperados, retorna falso
	    }
	}

	
	// Funcao que retorna a quantidade disponivel de cada produto
	public int quantidadeDisponivel(Produto produto) {
	    int quantidadeDisponivel = 0;

	    if (produto instanceof Medicamento) { // Se a instância do produto for um medicamento
	        for (Produto p : Medicamentos) { // Itera sobre a lista de Medicamentos
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) { // Verifica se o nome do produto na lista é igual ao nome do produto
	                Medicamento medicamento = (Medicamento) p; // Faz o cast do produto para o tipo Medicamento
	                quantidadeDisponivel = medicamento.getQuantidade(); // Obtém a quantidade disponível do medicamento encontrado
	                break; // interrompe o loop após encontrar a primeira ocorrência
	            }
	        }
	    // Agora ele faz o mesmo para o restante dos produtos:
	    } else if (produto instanceof Cosmetico) {
	        for (Produto p : Cosmeticos) {
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
	                Cosmetico cosmetico = (Cosmetico) p;
	                quantidadeDisponivel = cosmetico.getQuantidade();
	                break; 
	            }
	        }
	    } else if (produto instanceof GiftCard) {
	        for (Produto p : GiftCards) {
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
	                GiftCard giftCard = (GiftCard) p;
	                quantidadeDisponivel = giftCard.getQuantidade();
	                break; 
	            }
	        }
	    } else if (produto instanceof Snack) {
	        for (Produto p : Snacks) {
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
	                Snack snack = (Snack) p;
	                quantidadeDisponivel = snack.getQuantidade();
	                break; 
	            }
	        }
	    } else if (produto instanceof Acessorio) {
	        for (Produto p : Acessorios) {
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
	                Acessorio acessorio = (Acessorio) p;
	                quantidadeDisponivel = acessorio.getQuantidade();
	                break;
	            }
	        }
	    }

	    return quantidadeDisponivel; //  Retorna a quantidade disponível do produto (pode ser 0 se não for encontrado)
	}


	// A funcao adicionarCarrinho será chamado pela Venda, com o objetivo de adicionar o produto e a quantidade dele no carrinho do cliente, verificando se tudo tem no estoque
	public boolean adicionarCarrinho(Produto produto, int quantidade) {
	    if (produto instanceof Medicamento && Medicamentos.contains(produto)) { // Se o produto for do tipo Medicamento e estiver na lista de Medicamentos
	        int quantidadeDisponivel = quantidadeDisponivel(produto); // Obtém a quantidade disponível do produto
	        if (quantidadeDisponivel >= quantidade) { // Verifica se a quantidade disponível é suficiente para adicionar ao carrinho
	            int index = Medicamentos.indexOf(produto); // Obtém o índice do produto na lista de Medicamentos
	            Produto medicamento = Medicamentos.get(index); // Obtém o objeto do produto encontrado
	            if (medicamento.getQuantidade() >= quantidade) { // Verifica se a quantidade disponível do produto é suficiente para adicionar ao carrinho
	                medicamento.setQuantidade(medicamento.getQuantidade() - quantidade); // Atualiza a quantidade disponível do produto no estoque
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd(); // Chama a funcao atualizarQtd para atualizar no estoque a quantidade nova de itens
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
	    // Repete o processo para cada um dos outros produtos
	    } else if (produto instanceof Cosmetico && Cosmeticos.contains(produto)) {
	        int quantidadeDisponivel = quantidadeDisponivel(produto);
	        if (quantidadeDisponivel >= quantidade) {
	            int index = Cosmeticos.indexOf(produto);
	            Produto cosmetico = Cosmeticos.get(index);
	            if (cosmetico.getQuantidade() >= quantidade) {
	                cosmetico.setQuantidade(cosmetico.getQuantidade() - quantidade);
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd();
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
	    } else if (produto instanceof GiftCard && GiftCards.contains(produto)) {
	        int quantidadeDisponivel = quantidadeDisponivel(produto);
	        if (quantidadeDisponivel >= quantidade) {
	            int index = GiftCards.indexOf(produto);
	            Produto giftCard = GiftCards.get(index);
	            if (giftCard.getQuantidade() >= quantidade) {
	                giftCard.setQuantidade(giftCard.getQuantidade() - quantidade);
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd();
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
	    } else if (produto instanceof Snack && Snacks.contains(produto)) {
	        int quantidadeDisponivel = quantidadeDisponivel(produto);
	        if (quantidadeDisponivel >= quantidade) {
	            int index = Snacks.indexOf(produto);
	            Produto snack = Snacks.get(index);
	            if (snack.getQuantidade() >= quantidade) {
	                snack.setQuantidade(snack.getQuantidade() - quantidade);
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd();
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
	    } else if (produto instanceof Acessorio && Acessorios.contains(produto)) {
	        int quantidadeDisponivel = quantidadeDisponivel(produto);
	        if (quantidadeDisponivel >= quantidade) {
	            int index = Acessorios.indexOf(produto);
	            Produto acessorio = Acessorios.get(index);
	            if (acessorio.getQuantidade() >= quantidade) {
	                acessorio.setQuantidade(acessorio.getQuantidade() - quantidade);
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd();
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
	    }

	    System.out.println("O produto " + produto.getNome() + " não foi encontrado.");
	    return false; // Se o produto nao for encontrado, retorna false
	}


	// Funcao com o objetivo de exibir uma lista dos produtos no formato de nome do produto e quantidade que tem dele no estoque
	public void exibirListaProdutos() {
        Map<String, Integer> nomeQuantidadeMap = new HashMap<>(); // Cria um mapa como um novo HashMap para associar e armazenar os pares dos nomes e quantidades dos produtos

        // Chama a funcao atualizarNomeQuantidadeMap para atualizar os mapas com os produtos correspondentes:
        atualizarNomeQuantidadeMap(Medicamentos, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Acessorios, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(GiftCards, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Snacks, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Cosmeticos, nomeQuantidadeMap);

        for (Map.Entry<String, Integer> entry : nomeQuantidadeMap.entrySet()) { // Itera sobre as entradas do mapa nomeQuantidadeMap
            String nome = entry.getKey(); // Obtém o nome do produto
            int quantidade = entry.getValue(); // Obtém a quantidade do produto

            Produto produtoEncontrado = encontrarProdutoPorNome(nome); // Encontra o produto com base no nome
            if (produtoEncontrado != null) { // Verifica se o produto foi encontrado
                String preco = formatarPreco(produtoEncontrado.getPreco()); // Formata o preço do produto
                String alerta = produtoEncontrado.estaVencido() ? " [PRODUTO VENCIDO!]" : ""; // Verifica se o produto está vencido e adiciona um alerta se necessário
                System.out.println(nome + " (" + quantidade + "): R$" + preco + alerta); // Exibe o nome, quantidade, preço e alerta do produto caso o alerta retorne que está vencido
            }
        }
    }
	
	private Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : Medicamentos) { // Itera sobre os Medicamentos
            if (produto.getNome().equals(nome)) { // Verifica se o nome do produto é igual ao nome procurado
                return produto; // Retorna o produto encontrado
            }
        }

        // Repete o mesmo processo para os demais produtos:
        for (Produto produto : Acessorios) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

        for (Produto produto : GiftCards) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

        for (Produto produto : Snacks) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

        for (Produto produto : Cosmeticos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

        return null; // Se o produto nao for encontrado, retorna null
    }

	private void atualizarNomeQuantidadeMap(List<Produto> produtos, Map<String, Integer> nomeQuantidadeMap) {
	    for (Produto produto : produtos) { // Itera sobre a lista de produtos fornecida
	        String nome = produto.getNome(); // Obtém o nome do produto
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0); // Obtém a quantidade atual do produto no mapa ou 0 se não existir
	        nomeQuantidadeMap.put(nome, quantidade + 1); // Atualiza o mapa com a quantidade incrementada
	    }
	}

	// Funcao para criar um formato decimal com duas casas depois da vírgula (útil para exibir valores em dinheiro)
	private String formatarPreco(double preco) {
	    DecimalFormat df = new DecimalFormat("#.00"); // Cria um formato decimal com duas casas decimais
	    return df.format(preco); // Formata o preço usando o formato criado e retorna como uma string
	}

	// Funcao que verifica se o produto está no estoque
	public boolean verificarProduto(List<Produto> produtos, Produto produto) {
	    try {
	        return produtos.contains(produto); // Verifica se o produto está presente na lista de produtos fornecida
	    } catch (NullPointerException e) {
	        System.out.println("Lista de produtos é nula."); // Trata a exceção caso a lista de produtos seja nula
	        return false;
	    }
	}
	
	// Essa funcao atualiza a quantidade de cada produto que está no estoque pegando o tamanho da lista de cada produto
	 public void atualizarQtd() {
		 	qtdMedicamento = Medicamentos.size();
		 	qtdCosmetico = Cosmeticos.size();
		 	qtdSnack = Snacks.size();
		 	qtdAcessorio = Acessorios.size();
		 	qtdGiftCard = GiftCards.size();
	    }

	 // A funcao adicionarProduto adiciona um produto ao estoque, e separa corretamente em qual lista esse produto vai automaticamente
	 public boolean adicionarProduto(Produto produto) {
		    try {
		    	// Verificando o tipo de produto
		        if (produto instanceof Medicamento) {
		            Medicamento medicamento = (Medicamento) produto; // Converte o objeto produto para o tipo Medicamento
		            medicamento.setEstoque(this); // Define o estoque do medicamento como o estoque atual
		            for (int i = 0; i < medicamento.getQuantidade(); i++) { // Pega a quantidade (que está sendo passado quando instancia o produto) e add no estoque de acordo com ela
		                Medicamentos.add(medicamento); // Adiciona o medicamento à lista de Medicamentos
		            }
		            qtdMedicamento += medicamento.getQuantidade(); // Atualiza a quantidade de medicamentos no estoque
		            System.out.println("Medicamento adicionado com sucesso!");
		        // Repete o mesmo processo para o restante dos produtos
		        } else if (produto instanceof Acessorio) {
		            Acessorio acessorio = (Acessorio) produto;
		            acessorio.setEstoque(this);
		            for (int i = 0; i < acessorio.getQuantidade(); i++) {
		                Acessorios.add(acessorio);
		            }
		            qtdAcessorio += acessorio.getQuantidade();
		            System.out.println("Acessório adicionado com sucesso!");
		        } else if (produto instanceof Cosmetico) {
		            Cosmetico cosmetico = (Cosmetico) produto;
		            cosmetico.setEstoque(this);
		            for (int i = 0; i < cosmetico.getQuantidade(); i++) {
		                Cosmeticos.add(cosmetico);
		            }
		            qtdCosmetico += cosmetico.getQuantidade();
		            System.out.println("Cosmético adicionado com sucesso!");
		        } else if (produto instanceof GiftCard) {
		            GiftCard giftCard = (GiftCard) produto;
		            giftCard.setEstoque(this);
		            for (int i = 0; i < giftCard.getQuantidade(); i++) {
		                GiftCards.add(giftCard);
		            }
		            qtdGiftCard += giftCard.getQuantidade();
		            System.out.println("GiftCard adicionado com sucesso!");
		        } else if (produto instanceof Snack) {
		            Snack snack = (Snack) produto;
		            snack.setEstoque(this);
		            for (int i = 0; i < snack.getQuantidade(); i++) {
		                Snacks.add(snack);
		            }
		            qtdSnack += snack.getQuantidade();
		            System.out.println("Snack adicionado com sucesso!");
		        } else {
		            System.out.println("Tipo de produto desconhecido. Adição não é possível.");
		            return false;
		        }

		        return true;
		    } catch (NullPointerException e) {
		        System.out.println("Ocorreu uma exceção durante a adição do produto: " + e.getMessage()); // Tratando exceção
		        return false;
		    }
		}

	 
	 public boolean removerProduto(String nomeProduto, int quantidade) {
		    Produto produtoRemovido = null;

		    try {
		        // Procura o produto nas diferentes listas
		        for (Produto produto : Medicamentos) {
		            if (produto.getNome().equals(nomeProduto)) { // Achou o produto
		                if (quantidade > produto.getQuantidade()) { // Ve se a quantidade que to removendo é maior que a quantidade que tem no estoque
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto; // recebe o produto
		                produto.setQuantidade(produto.getQuantidade() - quantidade); // Atualiza a quantidade do produto
		                if (produto.getQuantidade() <= 0) {
		                    Medicamentos.remove(produto); // Remove o produto do estoque se a quantidade ficar menor ou igual a zero
		                }
		                break;
		            }
		        }

		        // Repete o processo para o restante
		        for (Produto produto : Acessorios) {
		            if (produto.getNome().equals(nomeProduto)) {
		                if (quantidade > produto.getQuantidade()) {
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto;
		                produto.setQuantidade(produto.getQuantidade() - quantidade);
		                if (produto.getQuantidade() <= 0) {
		                    Acessorios.remove(produto);
		                }
		                break;
		            }
		        }

		        for (Produto produto : GiftCards) {
		            if (produto.getNome().equals(nomeProduto)) {
		                if (quantidade > produto.getQuantidade()) {
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto;
		                produto.setQuantidade(produto.getQuantidade() - quantidade);
		                if (produto.getQuantidade() <= 0) {
		                    GiftCards.remove(produto);
		                }
		                break;
		            }
		        }

		        for (Produto produto : Snacks) {
		            if (produto.getNome().equals(nomeProduto)) {
		                if (quantidade > produto.getQuantidade()) {
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto;
		                produto.setQuantidade(produto.getQuantidade() - quantidade);
		                if (produto.getQuantidade() <= 0) {
		                    Snacks.remove(produto);
		                }
		                break;
		            }
		        }

		        for (Produto produto : Cosmeticos) {
		            if (produto.getNome().equals(nomeProduto)) {
		                if (quantidade > produto.getQuantidade()) {
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto;
		                produto.setQuantidade(produto.getQuantidade() - quantidade);
		                if (produto.getQuantidade() <= 0) {
		                    Cosmeticos.remove(produto);
		                }
		                break;
		            }
		        }

		        if (produtoRemovido != null) {
		            atualizarQtd(); // Atualiza a quantidade dos produtos no estoque com base no tamanho das listas
		            return true;
		        } else {
		            System.out.println("O produto " + nomeProduto + " não foi encontrado.");
		            return false;
		        }
		    } catch (Exception e) {
		        System.out.println("Ocorreu um erro ao remover a quantidade do produto: " + e.getMessage());
		        return false;
		    }
		}

	 // Funcao basica que exibe a quantidade de cada tipo de produto no estoque
	public void exibirQtd() {
		System.out.println("Quantidade de Medicamentos: " + getQtdMedicamento());
		System.out.println("Quantidade de Cosméticos: " + getQtdCosmetico());
		System.out.println("Quantidade de GiftCards: " + getQtdGiftCard());
		System.out.println("Quantidade de Snacks: " + getQtdSnack());
		System.out.println("Quantidade de Acessórios: " + getQtdAcessorio());
	}
}

/*
 * "Fazer o cast do produto" significa converter o tipo de uma variável para outro tipo relacionado. No contexto do código fornecido,
 * o cast é usado para converter a variável produto do tipo mais genérico Produto para um tipo mais específico, como Medicamento, 
 * Cosmetico, GiftCard, Snack ou Acessorio.
 * 
 * Iterar significa percorrer cada elemento de uma coleção de dados, um por um.
 */
