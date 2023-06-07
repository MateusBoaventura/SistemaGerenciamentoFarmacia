package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverExame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
	}

	/**
	 * Create the frame.
	 */
	public TelaRemoverExame(String funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnDigiteOEmail = new JTextPane();
		txtpnDigiteOEmail.setBackground(new Color(240, 240, 240));
		txtpnDigiteOEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnDigiteOEmail.setText("Digite o email do cliente:");
		txtpnDigiteOEmail.setBounds(10, 45, 154, 20);
		contentPane.add(txtpnDigiteOEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 76, 414, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario telaFunc = new TelaFuncionario(funcionarioLogado);
				telaFunc.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				
				if (Main.EXAMES.removerExame(email)) {
					JOptionPane.showMessageDialog(contentPane,"Exame removido");
				} else {
					JOptionPane.showMessageDialog(contentPane,"Erro, exame não encontrado");
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemover.setBounds(335, 228, 89, 23);
		contentPane.add(btnRemover);
	}

}
