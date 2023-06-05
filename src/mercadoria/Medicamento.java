package mercadoria;

public class Medicamento extends ProdutoPerecivel{
	private float peso; // Um peso, em gramas ou ml, de um medicamento é um atributo essencial
	private boolean receita, generico; // Um medicamento pode ou ser generico, assim como pode ou nao solicitar uma receita
	
	public Medicamento() {
		super();
		this.peso = 0;
		this.receita = false;
		this.generico = true;
	}
	
	public Medicamento(String nome,String fabricante,int id,String dataFabricacao,String dataValidade,float peso,boolean receita,boolean generico) {
		super(nome,fabricante,id,dataFabricacao,dataValidade);
		this.peso = peso;
		this.receita = receita;
		this.generico = generico;
	}

	
	//Getters e setters
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	
	public boolean isReceita() {
		return receita;
	}

	public void setReceita(boolean receita) {
		this.receita = receita;
	}

	
	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}
	
	@Override
	public String toString() {
		return String.format("Medicamento%s\nPeso:%f\nReceita:%b\nGenerico%b", super.toString(),this.getPeso(),this.isReceita(),this.isGenerico());
	}
}
