package mercadoria;

//Importando as devidas bibliotecas para fazer o sistema de data:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.excript.Farmacia.Estoque;

public class Acessorio extends Produto {
	
    // Criando seu construtor
    public Acessorio(String nome, String empresa, int id, double preco, String dataFabricacao, String dataValidade, int quantidade) {
        super(nome, empresa, id, preco, dataFabricacao, dataValidade, quantidade);
    }

	// Getters e Setters
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	// Função estaVencido para verificar se o produto já passou da data de validade que eu informei no parâmetro
	public boolean estaVencido() {
	    LocalDate dataAtual = LocalDate.now(); // Ele cria uma variáveo do tipo LocalDate que recebe a data atual do SO;
	    LocalDate dataValidadeFormatada = LocalDate.parse(getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Ele formata a data para o formato de DIA/MÊS/ANO como usamos no Brasil; 
	    return dataValidadeFormatada.isBefore(dataAtual); // Ele retorna true caso a dataFormatada seja anterior à data atual do SO;
	}

	@Override
	public void MostrarDados() { // Essa função mostra todas as informações do produto, em seu parâmetro é passado de qual estoque ele está;
	    if (estoque.verificarProduto(estoque.getAcessorios(), this)) { // Ele realiza uma verificação de se o produto está no estoque correspondente
	        System.out.println("Nome: " + getNome());
	        System.out.println("Empresa: " + getEmpresa());
	        System.out.println("Id: " + getId());
	        System.out.println("Preço: R$" + getPreco());
	        System.out.println("Data de Fabricação: " + getDataFabricacao());
	        System.out.println("Data de Validade: " + getDataValidade());

	        if (estaVencido()) { // Ele verifica se o produto está vencido ou não, e avisa
	            System.out.println("Status: Vencido!");
	        } else {
	            System.out.println("Status: Não vencido.");
	        }
	    } else {
	        System.out.println("O Acessório não está no estoque.");
	    }
	}
}
