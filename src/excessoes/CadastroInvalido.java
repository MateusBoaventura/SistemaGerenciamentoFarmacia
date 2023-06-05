package excessoes;

public class CadastroInvalido extends Exception{
	private static final long serialVersionUID = 1L;

	public final int codigoDeErro = -2;
	public static final String mensagem = "O cadastro de %s %s e invalido";
	
	public CadastroInvalido(String tipo,String valor) {
		super(String.format(mensagem, tipo,valor));
	}
}
