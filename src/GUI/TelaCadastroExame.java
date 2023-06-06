package GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import com.excript.Farmacia.*;

import excessoes.JaCadastrado;

public class TelaCadastroExame extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	protected Component contentPane;
	private JTextField txtTipo;
	private JTextField txtHorario;
	private JTextField txtPreco;

	/**
	 * Create the panel.
	 */
	public TelaCadastroExame(CadastroDeExames cadastroExame) {
		setLayout(null);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(new Color(240, 240, 240));
		txtpnNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNome.setText("Nome:");
		txtpnNome.setBounds(10, 25, 53, 20);
		add(txtpnNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(73, 25, 367, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setBounds(10, 56, 53, 20);
		add(txtpnEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(73, 56, 367, 20);
		add(txtEmail);
		
		JTextPane txtpnTelefone = new JTextPane();
		txtpnTelefone.setText("Telefone:");
		txtpnTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnTelefone.setBackground(SystemColor.menu);
		txtpnTelefone.setBounds(10, 87, 62, 20);
		add(txtpnTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(73, 87, 367, 20);
		add(txtTelefone);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String cpf = txtCPF.getText();
				String tipo = txtTipo.getText();
				LocalDateTime horario = LocalDateTime.parse(txtHorario.getText());
				double preco = Double.parseDouble(txtPreco.getText());
				
				Cliente cliente = new Cliente(nome, email, telefone, cpf, 0);
				
				Exame exame = new Exame(tipo, horario, preco, cliente);
				
				if (cadastroExame.checaHorario(exame)) {
					JOptionPane.showMessageDialog(contentPane,"Horário não disponível");
				} else {
					cadastroExame.cadastraExame(exame);
				}
				
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(325, 268, 115, 23);
		add(btnCadastrar);
		
		JTextPane txtpnCpf = new JTextPane();
		txtpnCpf.setText("CPF:");
		txtpnCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCpf.setBackground(SystemColor.menu);
		txtpnCpf.setBounds(10, 118, 62, 20);
		add(txtpnCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(73, 118, 367, 20);
		add(txtCPF);
		
		JTextPane txtpnTipo = new JTextPane();
		txtpnTipo.setText("Tipo:");
		txtpnTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnTipo.setBackground(SystemColor.menu);
		txtpnTipo.setBounds(10, 149, 62, 20);
		add(txtpnTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(73, 149, 367, 20);
		add(txtTipo);
		
		JTextPane txtpnCpf_1_1 = new JTextPane();
		txtpnCpf_1_1.setText("Horário:");
		txtpnCpf_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCpf_1_1.setBackground(SystemColor.menu);
		txtpnCpf_1_1.setBounds(10, 180, 62, 20);
		add(txtpnCpf_1_1);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(73, 180, 367, 20);
		add(txtHorario);
		
		JTextPane txtpnCpf_1_1_1 = new JTextPane();
		txtpnCpf_1_1_1.setText("Preço:");
		txtpnCpf_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCpf_1_1_1.setBackground(SystemColor.menu);
		txtpnCpf_1_1_1.setBounds(10, 211, 62, 20);
		add(txtpnCpf_1_1_1);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(73, 211, 367, 20);
		add(txtPreco);
		
	}
}