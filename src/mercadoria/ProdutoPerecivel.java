package mercadoria;

// Classe-Filha que indica produtos que possuem validade
public abstract class ProdutoPerecivel extends Produto{
	private String dataValidade; // //A data será passada em string, para que a funcao estaVencido() funcione corretamente

	// Construtor vazio
	public ProdutoPerecivel() {
		super();
		this.dataValidade = new String();
	}
	
	// Construtor
	public ProdutoPerecivel(String nome,String fabricante,String dataFabricacao,String dataValidade) {
		super(nome,fabricante,dataFabricacao);
		this.dataValidade = dataValidade;
	}
	
	//Getters e Setters
	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	@Override
	public String toString() {
		return String.format("(Perecível)%s\nData_Validade:%s",super.toString(),this.getDataValidade());
	}
}
