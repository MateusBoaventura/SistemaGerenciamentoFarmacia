package mercadoria;

public class Comida extends ProdutoPerecivel{
	private float calorias;
	private String detalhes;
	
	public Comida() {
		super();
		this.calorias = 0;
		this.detalhes = new String();
	}
	
	public Comida(String nome,String fabricante,String dataFabricacao,String dataValidade,float calorias,String detalhes) {
		super(nome,fabricante,dataFabricacao,dataValidade);
		this.calorias = calorias;
		this.detalhes = detalhes;
	}
	
	//Getters e setters
	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	@Override
	public String toString() {
		return String.format("Comida%s\nCalorias:%.2f\nDetalhes:%s", super.toString(),this.getCalorias(),this.getDetalhes());
	}
}
