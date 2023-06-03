package com.excript.Farmacia;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
		for(Produto medicamento : Medicamentos) {
			if (medicamento.getId() == codigo) {
				return true;
			}
		}
		for (Produto acessorio : Acessorios) {
			if(acessorio.getId() == codigo) {
				return true;
			}
		}
		for (Produto cosmetico : Cosmeticos) {
			if(cosmetico.getId() == codigo) {
				return true;
			}
		}
		for (Produto giftCard : GiftCards) {
			if(giftCard.getId() == codigo) {
				return true;
			}
		}
		for (Produto snack : Snacks) {
			if(snack.getId() == codigo) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean verificarDisponibilidade(Produto produto) {
	    if (produto instanceof Medicamento) {
	        return Medicamentos.contains(produto);
	    } else if (produto instanceof Cosmetico) {
	        return Cosmeticos.contains(produto);
	    } else if (produto instanceof GiftCard) {
	        return GiftCards.contains(produto);
	    } else if (produto instanceof Snack) {
	        return Snacks.contains(produto);
	    } else if (produto instanceof Acessorio) {
	        return Acessorios.contains(produto);
	    } else {
	        return false;
	    }
	}
	
	public boolean adicionarCarrinho(Produto produto) {
	    if (produto instanceof Medicamento) {
	        if (Medicamentos.remove(produto)) {
	            System.out.println(produto.getNome() + " foi adicionado no carrinho.");
	            atualizarQtd();
	            return true;
	        }
	    } else if (produto instanceof Cosmetico) {
	        if (Cosmeticos.remove(produto)) {
	            System.out.println(produto.getNome() + " foi adicionado no carrinho.");
	            atualizarQtd();
	            return true;
	        }
	    } else if (produto instanceof GiftCard) {
	        if (GiftCards.remove(produto)) {
	            System.out.println(produto.getNome() + " foi adicionado no carrinho.");
	            atualizarQtd();
	            return true;
	        }
	    } else if (produto instanceof Snack) {
	        if (Snacks.remove(produto)) {
	            System.out.println(produto.getNome() + " foi adicionado no carrinho.");
	            atualizarQtd();
	            return true;
	        }
	    } else if (produto instanceof Acessorio) {
	        if (Acessorios.remove(produto)) {
	            System.out.println(produto.getNome() + " foi adicionado no carrinho.");
	            atualizarQtd();
	            return true;
	        }
	    }
	    
	    System.out.println("O produto " + produto.getNome() + " não foi encontrado.");
	    return false;
	}
	
	public void exibirListaProdutos() {
	    Map<String, Integer> nomeQuantidadeMap = new HashMap<>(); // Cria um mapa para armazenar os nomes dos produtos e suas quantidades
	    
	    // Percorre a lista dos produtos e atualiza o mapa com os nomes e quantidades correspondentes
	    for (Produto medicamento : Medicamentos) {
	        String nome = medicamento.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	    
	    for (Produto acessorio : Acessorios) {
	        String nome = acessorio.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	    
	    for (Produto giftCard : GiftCards) {
	        String nome = giftCard.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	    
	    for (Produto snack : Snacks) {
	        String nome = snack.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	    
	    for (Produto cosmetico : Cosmeticos) {
	        String nome = cosmetico.getNome();
	        int quantidade = nomeQuantidadeMap.getOrDefault(nome, 0);
	        nomeQuantidadeMap.put(nome, quantidade + 1);
	    }
	    
	    // Exibe os nomes e preços dos produtos com suas quantidades
	    for (Map.Entry<String, Integer> entry : nomeQuantidadeMap.entrySet()) {
	        String nome = entry.getKey(); // Obtém a chave (nome do produto) do mapa
	        int quantidade = entry.getValue(); // Obtém o valor (quantidade do produto) do mapa
	        
	        // Percorre cada lista de produtos para encontrar o produto com o nome correspondente e exibir seu preço
	        for (Produto produto : Medicamentos) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println(nome + " (" + quantidade + "): R$" + produto.getPreco());
	                break;
	            }
	        }
	        for (Produto produto : Acessorios) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println(nome + " (" + quantidade + "): R$" + produto.getPreco());
	                break;
	            }
	        }
	        for (Produto produto : GiftCards) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println(nome + " (" + quantidade + "): R$" + produto.getPreco());
	                break;
	            }
	        }
	        for (Produto produto : Snacks) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println(nome + " (" + quantidade + "): R$" + produto.getPreco());
	                break;
	            }
	        }
	        for (Produto produto : Cosmeticos) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println(nome + " (" + quantidade + "): R$" + produto.getPreco());
	                break;
	            }
	        }
	    }
	}

	
	 public void atualizarQtd() {
		 	qtdMedicamento = Medicamentos.size();
		 	qtdCosmetico = Cosmeticos.size();
		 	qtdSnack = Snacks.size();
		 	qtdAcessorio = Acessorios.size();
		 	qtdGiftCard = GiftCards.size();
	    }
	
	public boolean adicionarMedicamento(Produto medicamento) {
	    if (verificarCodigo(medicamento.getId())) {
	        System.out.println("Código já existe. Adição não é possível.");
	        return false;
	    }

	    Medicamentos.add(medicamento);
	    ((Medicamento) medicamento).setEstoque(this); // Configurando o estoque no medicamento adicionado

	    System.out.println("Medicamento adicionado com sucesso!");
	    qtdMedicamento++;
	    return true;
	};
	
	public boolean verificarMedicamento(Produto medicamento) {
		return Medicamentos.contains(medicamento);
    }
	
	public boolean removerMedicamento(int codigoMedicamento) {
		for (Produto medicamento : Medicamentos) {
			if(medicamento.getId() == codigoMedicamento) {
				Medicamentos.remove(medicamento);
				System.out.println("O Medicamento "+ medicamento.getNome() + " foi removido com sucesso!");
				atualizarQtd();
				return true;
			}
		}
		System.out.println("O código " + codigoMedicamento + " não foi encontrado.");
		return false;
	};
	
	public boolean adicionarAcessorio(Produto acessorio) {
		if (verificarCodigo(acessorio.getId())) {
			System.out.println("Código já existe. Adição não é possível.");
			acessorio = null;
			return false;
		}
		Acessorios.add(acessorio);
		((Acessorio) acessorio).setEstoque(this); // Configurando o estoque no acessorio adicionado
		
		System.out.println("Acessório adicionado com sucesso!");
		qtdAcessorio++;
		return true;
	}
	
	public boolean verificarAcessorio(Produto acessorio) {
        return Acessorios.contains(acessorio);
    }
	
	public boolean removerAcessorio(int codigoAcessorio) {
		for(Produto acessorio : Acessorios) {
			if(acessorio.getId() == codigoAcessorio) {
				Acessorios.remove(acessorio);
				System.out.println("O acessório "+ acessorio.getNome() + " foi removido com sucesso!");
				atualizarQtd();
				return true;
			}
		}
		System.out.println("O código "+ codigoAcessorio +" não foi encontrado.");
		return false;
	}
	
	public boolean adicionarCosmetico(Produto cosmetico) {
		if (verificarCodigo(cosmetico.getId())) {
			System.out.println("Código já existe. Adição não é possível.");
			return false;
		}
		Cosmeticos.add(cosmetico);
		((Cosmetico) cosmetico).setEstoque(this); // Configurando o estoque no cosmetico adicionado
		
		System.out.println("Cosmético adicionado com sucesso!");
		qtdCosmetico++;
		return true;
	}
	
	public boolean verificarCosmetico(Produto cosmetico) {
       return Cosmeticos.contains(cosmetico);
    }
	
	public boolean removerCosmetico(int codigoCosmetico) {
		for(Produto cosmetico : Cosmeticos) {
			if(cosmetico.getId() == codigoCosmetico) {
				Cosmeticos.remove(cosmetico);
				System.out.println("O cosmético "+ cosmetico.getNome() +" foi removido com sucesso!");
				atualizarQtd();
				return true;
			}
		}
		System.out.println("O código "+ codigoCosmetico +" não foi encontrado.");
		return false;
	}
	
	public boolean adicionarGiftCard(Produto giftCard) {
		if (verificarCodigo(giftCard.getId())) {
			System.out.println("Código já existe. Adição não é possível.");
			return false;
		}
		GiftCards.add(giftCard);
		((GiftCard) giftCard).setEstoque(this); // Configurando o estoque no GiftCard adicionado
		
		System.out.println("GiftCard adicionado com sucesso!");
		qtdGiftCard++;
		return true;
	}
	
	public boolean verificarGiftCard(Produto giftCard) {
		return GiftCards.contains(giftCard);
    }
	
	public boolean removerGiftCard(int codigoGiftCard) {
		for(Produto giftCard : GiftCards) {
			if(giftCard.getId() == codigoGiftCard) {
				GiftCards.remove(giftCard);
				System.out.println("O GiftCard "+ giftCard.getNome() +" foi removido com sucesso!");
				atualizarQtd();
				return true;
			}
		}
		System.out.println("O código "+ codigoGiftCard +" não foi encontrado.");
		return false;
	}
	
	public boolean adicionarSnack(Produto snack) {
		if (verificarCodigo(snack.getId())) {
			System.out.println("Código já existe. Adição não é possível.");
			return false;
		}
		Snacks.add(snack);
		((Snack) snack).setEstoque(this); // Configurando o estoque no Snack adicionado
		
		System.out.println("Snack adicionado com sucesso!");
		qtdSnack++;
		return true;
	}
	
	public boolean verificarSnack(Produto snack) {
		return Snacks.contains(snack);
    }
	
	public boolean removerSnack(int codigoSnack) {
		for (Produto snack : Snacks) {
			if(snack.getId() == codigoSnack) {
				Snacks.remove(snack);
				System.out.println("O Snack "+ snack.getNome() + " foi removido com sucesso!");
				atualizarQtd();
				return true;
			}
		}
		System.out.println("O código "+ codigoSnack +" não foi encontrado.");
		return false;
	}
	
	public void exibirQtd() {
		System.out.println("Quantidade de Medicamentos: " + getQtdMedicamento());
		System.out.println("Quantidade de Cosméticos: " + getQtdCosmetico());
		System.out.println("Quantidade de GiftCards: " + getQtdGiftCard());
		System.out.println("Quantidade de Snacks: " + getQtdSnack());
		System.out.println("Quantidade de Acessórios: " + getQtdAcessorio());
	}
}
