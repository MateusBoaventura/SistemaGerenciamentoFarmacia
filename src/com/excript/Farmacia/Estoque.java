package com.excript.Farmacia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Estoque implements GestorEstoque {
	
	private static int qtdMedicamento, qtdAcessorio, qtdGiftCard, qtdSnack, qtdCosmetico;
	
	private ArrayList<Produto> Medicamentos;
	private ArrayList<Produto> Acessorios;
	private ArrayList<Produto> GiftCards;
	private ArrayList<Produto> Snacks;
	private ArrayList<Produto> Cosmeticos;
	
	public Estoque() {
		Medicamentos = new ArrayList<>();
		Acessorios = new ArrayList<>();
		GiftCards = new ArrayList<>();
		Snacks = new ArrayList<>();
		Cosmeticos = new ArrayList<>();
	}
	
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

	
	public boolean verificarCodigo(int codigo) {
	    for (Produto medicamento : Medicamentos) {
	        if (medicamento.getId() == codigo && medicamento.getQuantidade() > 0) {
	            return true;
	        }
	    }

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

	    return false;
	}

	
	public boolean verificarDisponibilidade(Produto produto, int quantidade) {
	    if (produto instanceof Medicamento) {
	        Medicamento medicamento = (Medicamento) produto;
	        return Medicamentos.contains(medicamento) && medicamento.getQuantidade() >= quantidade;
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
	        return false;
	    }
	}
	

	public int quantidadeDisponivel(Produto produto) {
	    int quantidadeDisponivel = 0;

	    if (produto instanceof Medicamento) {
	        for (Produto p : Medicamentos) {
	            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
	                Medicamento medicamento = (Medicamento) p;
	                quantidadeDisponivel = medicamento.getQuantidade();
	                break; // interrompe o loop após encontrar a primeira ocorrência
	            }
	        }
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

	    return quantidadeDisponivel;
	}


	
	public boolean adicionarCarrinho(Produto produto, int quantidade) {
	    if (produto instanceof Medicamento && Medicamentos.contains(produto)) {
	        int quantidadeDisponivel = quantidadeDisponivel(produto);
	        if (quantidadeDisponivel >= quantidade) {
	            int index = Medicamentos.indexOf(produto);
	            Produto medicamento = Medicamentos.get(index);
	            if (medicamento.getQuantidade() >= quantidade) {
	                medicamento.setQuantidade(medicamento.getQuantidade() - quantidade);
	                System.out.println(quantidade + " unidades de " + produto.getNome() + " foram adicionadas no carrinho.");
	                atualizarQtd();
	                return true;
	            }
	        } else {
	            System.out.println("Quantidade indisponível. Apenas " + quantidadeDisponivel + " unidades de " + produto.getNome() + " estão disponíveis no estoque.");
	            System.out.println("");
	        }
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
	    return false;
	}


	
	public void exibirListaProdutos() {
        Map<String, Integer> nomeQuantidadeMap = new HashMap<>();

        atualizarNomeQuantidadeMap(Medicamentos, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Acessorios, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(GiftCards, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Snacks, nomeQuantidadeMap);
        atualizarNomeQuantidadeMap(Cosmeticos, nomeQuantidadeMap);

        for (Map.Entry<String, Integer> entry : nomeQuantidadeMap.entrySet()) {
            String nome = entry.getKey();
            int quantidade = entry.getValue();

            Produto produtoEncontrado = encontrarProdutoPorNome(nome);
            if (produtoEncontrado != null) {
                String preco = formatarPreco(produtoEncontrado.getPreco());
                String alerta = produtoEncontrado.estaVencido() ? " [PRODUTO VENCIDO!]" : "";
                System.out.println(nome + " (" + quantidade + "): R$" + preco + alerta);
            }
        }
    }
	
	private Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : Medicamentos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

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

        return null;
    }

	private void atualizarNomeQuantidadeMap(List<Produto> produtos, Map<String, Integer> nomeQuantidadeMap) {
	    for (Produto produto : produtos) {
	        String nome = produto.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	}

	private String formatarPreco(double preco) {
	    DecimalFormat df = new DecimalFormat("#.00");
	    return df.format(preco);
	}

	public boolean verificarProduto(List<Produto> produtos, Produto produto) {
	    try {
	        return produtos.contains(produto);
	    } catch (NullPointerException e) {
	        System.out.println("Lista de produtos é nula.");
	        return false;
	    }
	}
	
	 public void atualizarQtd() {
		 	qtdMedicamento = Medicamentos.size();
		 	qtdCosmetico = Cosmeticos.size();
		 	qtdSnack = Snacks.size();
		 	qtdAcessorio = Acessorios.size();
		 	qtdGiftCard = GiftCards.size();
	    }

	 public boolean adicionarProduto(Produto produto) {
		    try {
		        if (produto instanceof Medicamento) {
		            Medicamento medicamento = (Medicamento) produto;
		            medicamento.setEstoque(this);
		            for (int i = 0; i < medicamento.getQuantidade(); i++) {
		                Medicamentos.add(medicamento);
		            }
		            qtdMedicamento += medicamento.getQuantidade();
		            System.out.println("Medicamento adicionado com sucesso!");
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
		        System.out.println("Ocorreu uma exceção durante a adição do produto: " + e.getMessage());
		        return false;
		    }
		}

	 
	 public boolean removerProduto(String nomeProduto, int quantidade) {
		    Produto produtoRemovido = null;

		    try {
		        // Procura o produto nas diferentes listas
		        for (Produto produto : Medicamentos) {
		            if (produto.getNome().equals(nomeProduto)) {
		                if (quantidade > produto.getQuantidade()) {
		                    System.out.println("Quantidade solicitada é maior do que a disponível no estoque!");
		                    return false;
		                }
		                produtoRemovido = produto;
		                produto.setQuantidade(produto.getQuantidade() - quantidade);
		                if (produto.getQuantidade() <= 0) {
		                    Medicamentos.remove(produto);
		                }
		                break;
		            }
		        }

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
		            atualizarQtd();
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



	
	public void exibirQtd() {
		System.out.println("Quantidade de Medicamentos: " + getQtdMedicamento());
		System.out.println("Quantidade de Cosméticos: " + getQtdCosmetico());
		System.out.println("Quantidade de GiftCards: " + getQtdGiftCard());
		System.out.println("Quantidade de Snacks: " + getQtdSnack());
		System.out.println("Quantidade de Acessórios: " + getQtdAcessorio());
	}
}
