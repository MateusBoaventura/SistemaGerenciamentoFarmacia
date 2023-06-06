package mercadoria;

public class GiftCard extends ProdutoPerecivel {
	
	private float valor; // O valor se refere ao valor no jogo, e não o preço do produto
	private String jogo;
	
	public GiftCard() {
		super();
		this.valor = 0;
		this.jogo = new String();
	}
	
	// Criando seu construtor
	public GiftCard(String nome,String empresa,String dataFabricacao,String dataValidade,float valor,String jogo) {
		super(nome, empresa, dataFabricacao, dataValidade);
		this.valor = valor;
		this.jogo = jogo;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	
	public String getJogo() {
		return jogo;
	}
	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	@Override
	public String toString() {
		return String.format("GiftCard%s\nJogo:%s\nValor:%.2f", super.toString(),this.getJogo(),this.getValor());
	}
	
}
