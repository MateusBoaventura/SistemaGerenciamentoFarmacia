package excessoes;

public class LoginInvalido extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public final int codigoDeErro = -3;
	
	public LoginInvalido() {
		super("Login de funcionário incorreto");
	}
}
