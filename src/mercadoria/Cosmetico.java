package mercadoria;

public class Cosmetico extends Produto {
	
	private String descricao; // Este produto possui uma descrição

	public Cosmetico() {
		super();
		this.descricao = new String();
	}
	
	// Criando seu construtor
	public Cosmetico(String nome,String empresa,String dataFabricacao,String descricao) {
		super(nome, empresa, dataFabricacao);
		this.descricao = descricao;
	}

	// Getters e Setters
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("Cosmético%s\nDescrição:%s", super.toString(), this.getDescricao());
	}
	
}
