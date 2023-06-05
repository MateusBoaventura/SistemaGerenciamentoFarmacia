package mercadoria;

public class Variado extends Produto {
	
	private String descricao;
	
	//	Construtor vazio
	public Variado() {
		super();
		this.descricao = new String();
	}
	
    // Criando seu construtor
    public Variado(String nome, String empresa, String dataFabricacao, String descricao) {
        super(nome, empresa, dataFabricacao);
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return String.format("Variado:%s\nDescricao:%s",super.toString(),this.getDescricao());
	}

}
