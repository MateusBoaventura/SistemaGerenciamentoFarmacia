package GUI;

import java.awt.EventQueue;
import java.util.Date;
import com.excript.Farmacia.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.excript.Farmacia.Cliente;
import com.excript.Farmacia.Exame;

import main.Main;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class TelaCadastroExame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JTextField txtTipo;
	private JTextField txtHorario;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroExame(String funcioanarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(new Color(240, 240, 240));
		txtpnNome.setText("Nome: ");
		txtpnNome.setBounds(10, 11, 41, 20);
		contentPane.add(txtpnNome);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email: ");
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setBounds(10, 42, 41, 20);
		contentPane.add(txtpnEmail);
		
		JTextPane txtpnCpf = new JTextPane();
		txtpnCpf.setText("CPF: ");
		txtpnCpf.setBackground(SystemColor.menu);
		txtpnCpf.setBounds(10, 73, 41, 20);
		contentPane.add(txtpnCpf);
		
		JTextPane txtpnTelefone = new JTextPane();
		txtpnTelefone.setText("Telefone: ");
		txtpnTelefone.setBackground(SystemColor.menu);
		txtpnTelefone.setBounds(10, 104, 56, 20);
		contentPane.add(txtpnTelefone);
		
		JTextPane txtpnTipo = new JTextPane();
		txtpnTipo.setText("Tipo: ");
		txtpnTipo.setBackground(SystemColor.menu);
		txtpnTipo.setBounds(10, 135, 41, 20);
		contentPane.add(txtpnTipo);
		
		JTextPane txtpnHorrio = new JTextPane();
		txtpnHorrio.setText("Horário: ");
		txtpnHorrio.setBackground(SystemColor.menu);
		txtpnHorrio.setBounds(10, 166, 41, 20);
		contentPane.add(txtpnHorrio);
		
		JTextPane txtpnPreo = new JTextPane();
		txtpnPreo.setText("Preço: ");
		txtpnPreo.setBackground(SystemColor.menu);
		txtpnPreo.setBounds(10, 197, 41, 20);
		contentPane.add(txtpnPreo);
		
		txtNome = new JTextField();
		txtNome.setBounds(72, 11, 352, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(72, 42, 352, 20);
		contentPane.add(txtEmail);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(72, 73, 352, 20);
		contentPane.add(txtCPF);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(72, 104, 352, 20);
		contentPane.add(txtTelefone);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(72, 135, 352, 20);
		contentPane.add(txtTipo);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(72, 166, 352, 20);
		contentPane.add(txtHorario);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(72, 197, 352, 20);
		contentPane.add(txtPreco);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario telaFunc = new TelaFuncionario(funcioanarioLogado);
				telaFunc.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String cpf = txtCPF.getText();
				String tipo = txtTipo.getText();
				Date horario = null;
				try {
					horario = formatter.parse(txtHorario.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double preco = Double.parseDouble(txtPreco.getText());
				
				Cliente cliente = new Cliente(nome, email, telefone, cpf, 0);
				
				Exame exame = new Exame(tipo, horario, preco, cliente);
				if (nome == null || email == null || telefone == null || cpf == null || tipo == null || txtHorario.getText() == null ||  txtPreco.getText()== null) {
					JOptionPane.showMessageDialog(contentPane,"Erro, campos imcompletos");
				} else if (Main.EXAMES.checaHorario(exame)) {
					JOptionPane.showMessageDialog(contentPane,"Horário não disponível");
				} else {
					Main.EXAMES.cadastraExame(exame);
					JOptionPane.showMessageDialog(contentPane,"Exame cadastrado");
				}
			}
		});
		btnCadastrar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCadastrar);
	}

}
