package excessoes;

public class CadastroInvalido extends Exception{
	private static final long serialVersionUID = 1L;

	public final int codigoDeErro = -2; // Um numero inteiro que representa um código de erro
	public static final String mensagem = "O cadastro de %s %s e invalido"; // Mensagem que contém o erro padrão.%s e %s serão preenchidos com o tipo e valor do produto
	
	public CadastroInvalido(String tipo,String valor) {
		super(String.format(mensagem, tipo,valor)); // Mostrando a mensagem de erro
	}
}
