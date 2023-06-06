package GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.excript.Farmacia.*;

public class TelaRemoverExame extends JPanel {
	private JTextField txtEmail;
	protected Component contentPane;

	/**
	 * Create the panel.
	 */
	public TelaRemoverExame(CadastroDeExames cadastroExame, String funcionarioLogado) {
		setLayout(null);
		
		JTextPane txtpnDigiteOEmail = new JTextPane();
		txtpnDigiteOEmail.setBackground(new Color(240, 240, 240));
		txtpnDigiteOEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnDigiteOEmail.setText("Digite o email do cliente:");
		txtpnDigiteOEmail.setBounds(10, 34, 154, 20);
		add(txtpnDigiteOEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 65, 430, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Remover exame");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				
				if (cadastroExame.removerExame(email)) {
					
				} else {
					JOptionPane.showMessageDialog(contentPane,"Erro, exame não encontrado");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(293, 266, 147, 23);
		add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario telaFuncionario = new TelaFuncionario(funcionarioLogado);
				telaFuncionario.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setBounds(10, 267, 73, 23);
		add(btnVoltar);

	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
