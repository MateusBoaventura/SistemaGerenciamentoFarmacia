package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.excript.Farmacia.*;
import mercadoria.Produto;
import mercadoria.Variado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;

public class TelaAdicionarVariado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Create the frame.
	 */
	public TelaAdicionarVariado(Estoque estoque, String funcionarioLogado) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 497);
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 254, 329, 99);
		contentPane.add(textField_3);
		
		lblNewLabel_2 = new JLabel("Fabricação:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 115, 88, 40);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Descrição:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 281, 88, 40);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String fabricante = textField_1.getText();
				String dataFrabricacao = textField_2.getText();
				String descricao = textField_3.getText();
				int cod = Integer.parseInt(textField_4.getText());
				float preco = Float.parseFloat(textField_5.getText());
				
				Produto variado = new Variado(nome, fabricante, dataFrabricacao, descricao);
				
				
				try {
					estoque.cadastrarProduto(variado, cod);
					JOptionPane.showMessageDialog(contentPane, "Produto cadastrado!");
				} catch (JaCadastrado ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao cadastrar o produto, código já cadastrado");
				}
				
				try {
					estoque.atualizarPreco(cod, preco);
				} catch (CadastroInvalido ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao registrar o preço, código inválido");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(321, 376, 137, 48);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaProduto = new TelaAdicionarProduto(estoque, funcionarioLogado);
                telaProduto.setVisible(true);
                dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBounds(32, 376, 137, 48);
		contentPane.add(btnVoltar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 163, 329, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 204, 329, 30);
		contentPane.add(textField_5);
		
		lblNewLabel_4 = new JLabel("Código:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 156, 88, 40);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(23, 197, 88, 40);
		contentPane.add(lblNewLabel_5);
		
		
		
	}
}
