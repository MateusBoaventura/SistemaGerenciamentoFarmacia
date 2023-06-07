package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.excript.Farmacia.Cliente;

import excessoes.JaCadastrado;
import main.Main;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente(String funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNome.setBackground(new Color(240, 240, 240));
		txtpnNome.setText("Nome: ");
		txtpnNome.setBounds(10, 11, 41, 20);
		contentPane.add(txtpnNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 11, 348, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email: ");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setBounds(10, 42, 41, 20);
		contentPane.add(txtpnEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(76, 42, 348, 20);
		contentPane.add(txtEmail);
		
		JTextPane txtpnNome_1_1 = new JTextPane();
		txtpnNome_1_1.setText("CPF: ");
		txtpnNome_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNome_1_1.setBackground(SystemColor.menu);
		txtpnNome_1_1.setBounds(10, 73, 41, 20);
		contentPane.add(txtpnNome_1_1);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(76, 73, 348, 20);
		contentPane.add(txtCPF);
		
		JTextPane txtpnNome_1_1_1 = new JTextPane();
		txtpnNome_1_1_1.setText("Telefone: ");
		txtpnNome_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNome_1_1_1.setBackground(SystemColor.menu);
		txtpnNome_1_1_1.setBounds(10, 104, 66, 20);
		contentPane.add(txtpnNome_1_1_1);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(76, 104, 348, 20);
		contentPane.add(txtTelefone);
		
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String cpf = txtCPF.getText();
				
				Cliente cliente = new Cliente(nome, email, telefone, cpf, 0);
				
				try {
					Main.FARMACIA.cadastrarCliente(cliente);
					JOptionPane.showMessageDialog(contentPane,"Cliente cadastrado");

				} catch (JaCadastrado ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro, cliente já cadastrado");
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCadastrar);
	}

}
