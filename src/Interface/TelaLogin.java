package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.excript.Farmacia.*;

import excessoes.LoginInvalido;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private String funcionarioLogado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		
		
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA FARMACIA");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 11, 181, 72);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setToolTipText("");
		textField.setBounds(121, 114, 171, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(121, 178, 171, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(66, 115, 46, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(65, 186, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText();
                String senha = new String(textField_1.getPassword());

                try {
                    if (nome.equals("Mateus") && senha.equals("123")) {
                    	funcionarioLogado = "Mateus";
                        JOptionPane.showMessageDialog(contentPane, "Olá, Mateus!"); // Exibe caixa de texto com a mensagem "ACERTOU"
                    } else if (nome.equals("Victor") && senha.equals("1234")) {
                    	funcionarioLogado = "Victor";
                        JOptionPane.showMessageDialog(contentPane, "Olá, Victor!"); // Exibe caixa de texto com a mensagem "ACERTOU"
                    } else {
                        throw new LoginInvalido(); // Lança exceção caso o login esteja incorreto
                    }
                    
                    TelaFuncionario telaFuncionario = new TelaFuncionario(funcionarioLogado);
                    telaFuncionario.setVisible(true);
                    dispose();
                } catch (LoginInvalido ex) {
                    JOptionPane.showMessageDialog(contentPane, "Nome ou Senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE); // Exibe caixa de alerta com a mensagem "ERROU"
                }
            }
        });
        btnNewButton.setBounds(152, 247, 107, 41);
        contentPane.add(btnNewButton);
    }
}
