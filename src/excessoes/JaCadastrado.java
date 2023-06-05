package excessoes;

	// Tratando exceção caso produto já cadastrado
public class JaCadastrado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public final int codigoDeErro = -1; // Um numero inteiro que representa um código de erro
	public static final String mensagem = "O(a) %s %s ja tem cadastro"; // Mensagem que contém o erro padrão. %s e %s serão preenchidos com o tipo e valor do produto já cadastrado

	public JaCadastrado(String tipo,String valor) {
		super(String.format(mensagem, tipo,valor)); // Mostrando a mensagem de erro
	}
}
