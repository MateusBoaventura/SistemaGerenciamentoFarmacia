package mercadoria;

public abstract class ProdutoPerecivel extends Produto{
	private String dataValidade; // //A data será passada em string, para que a funcao estaVencido() funcione corretamente

	public ProdutoPerecivel() {
		super();
		this.dataValidade = new String();
	}
	
	public ProdutoPerecivel(String nome,String fabricante,int id,String dataFabricacao,String dataValidade) {
		super(nome,fabricante,id,dataFabricacao);
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
		return String.format("(Perecivel)\n%s\nData_Validade:%s",super.toString(),this.getDataValidade());
	}
}
