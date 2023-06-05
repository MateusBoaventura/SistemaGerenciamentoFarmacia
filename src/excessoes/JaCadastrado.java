package excessoes;

public class JaCadastrado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public final int codigoDeErro = -1;
	public static final String mensagem = "O(a) %s %s ja tem cadastro";

	public JaCadastrado(String tipo,String valor) {
		super(String.format(mensagem, tipo,valor));
	}
}
