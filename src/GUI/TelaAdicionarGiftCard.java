package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mercadoria.Comida;
import mercadoria.GiftCard;
import mercadoria.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import main.Main;

public class TelaAdicionarGiftCard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_6;
	private JTextField textField_3;
	private JTextField textField_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public TelaAdicionarGiftCard(String funcionarioLogado) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 27, 74, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 34, 329, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fabricante:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 71, 88, 40);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 78, 329, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 122, 329, 30);
		contentPane.add(textField_2);
		
		lblNewLabel_2 = new JLabel("Fabricação:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 115, 88, 40);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String fabricante = textField_1.getText();
				String dataFrabricacao = textField_2.getText();
				String dataValidade = textField_6.getText();
				float valor = Float.parseFloat(textField_5.getText());
				int cod = Integer.parseInt(textField_4.getText());
				String jogo = textField_7.getText();
				float preco = Float.parseFloat(textField_3.getText());
				
				Produto giftCard = new GiftCard(nome, fabricante, dataFrabricacao, dataValidade, valor, jogo);				
				
				try {
					Main.ESTOQUE.cadastrarProduto(giftCard, cod);
					JOptionPane.showMessageDialog(contentPane, "Produto cadastrado!");
				
				} catch (JaCadastrado ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao cadastrar o produto, código já cadastrado");
				}
				
				try {
					Main.ESTOQUE.atualizarPreco(cod, preco);
				} catch (CadastroInvalido ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao registrar o preço, código inválido");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(322, 412, 137, 48);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaProduto = new TelaAdicionarProduto(Main.ESTOQUE, funcionarioLogado);
                telaProduto.setVisible(true);
                dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBounds(20, 412, 137, 48);
		contentPane.add(btnVoltar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 213, 329, 30);
		contentPane.add(textField_4);
		
		lblNewLabel_4 = new JLabel("Código:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 206, 88, 40);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(23, 353, 88, 40);
		contentPane.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(100, 163, 329, 30);
		contentPane.add(textField_6);
		
		lblNewLabel_6 = new JLabel("Validade:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(23, 156, 88, 40);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 360, 329, 30);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 263, 329, 30);
		contentPane.add(textField_5);
		
		lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 256, 88, 40);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_7 = new JLabel("Jogo:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(20, 304, 88, 40);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 316, 329, 30);
		contentPane.add(textField_7);
		
		
		
	}
}
