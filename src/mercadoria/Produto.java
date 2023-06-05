package mercadoria;

// Criando uma classe abstrata produto porque ela é o padrão para todos os produtos que teremos na farmacia
public abstract class Produto {
	
	// Atribuindo atributos
	private String nome, fabricante;
	private String dataFabricacao; // A data será passada em string

	// Construtor para caso não passe nada, saia vazio
	public Produto() {
		this.nome = new String();
		this.fabricante = new String();
		this.dataFabricacao = new String();
	}
	
	// Criando o básico de um construtor Produto
	public Produto(String nome,String empresa,String dataFabricacao) {
	    this.nome = nome;
	    this.fabricante = empresa;
	    this.dataFabricacao = dataFabricacao;
	}

	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String toString() { // Utilizando toString 
		return String.format("\nNome:%s\nEmpresa:%s\nData_Frab:%s",this.getNome(),this.getFabricante(),this.getDataFabricacao()); // Exibindo info do produto
	}
}
