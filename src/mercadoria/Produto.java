package mercadoria;

// Criando uma classe abstrata produto porque ela é o padrão para todos os produtos que teremos na farmacia
// A classe implementa a interface FuncoesProduto
public abstract class Produto {
	
	// Atribuindo atributos
	private String nome, fabricante;
	private int id;
	private String dataFabricacao; // A data será passada em string, para que a funcao estaVencido() funcione corretamente

	public Produto() {
		this.nome = new String();
		this.fabricante = new String();
		this.id = 0;
		this.dataFabricacao = new String();
	}
	
	// Criando o básico de um construtor Produto
	public Produto(String nome,String empresa,int id,String dataFabricacao) {
	    this.nome = nome;
	    this.fabricante = empresa;
	    this.id = id;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String toString() {
		return String.format("Nome:%s\nEmpresa:%s\nID:%d\nData_Frab:%s",this.getNome(),this.getFabricante(),this.getId(),this.getDataFabricacao());
	}
}
