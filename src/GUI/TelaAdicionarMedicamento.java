package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import main.Main;
import mercadoria.Medicamento;
import mercadoria.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdicionarMedicamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	

	/**
	 * Create the frame.
	 */
	public TelaAdicionarMedicamento(String funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 11, 74, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(32, 59, 114, 45);
		contentPane.add(lblFabricante);
		
		JLabel lblFabricao = new JLabel("Fabricação:");
		lblFabricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricao.setBounds(32, 108, 74, 40);
		contentPane.add(lblFabricao);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade.setBounds(38, 159, 74, 40);
		contentPane.add(lblValidade);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(122, 18, 329, 30);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 66, 329, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 115, 329, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 166, 329, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(122, 220, 329, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(122, 261, 329, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(122, 389, 329, 30);
		contentPane.add(textField_6);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(48, 213, 74, 40);
		contentPane.add(lblPeso);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(38, 254, 74, 40);
		contentPane.add(lblCdigo);
		
		JLabel lblValidade_3 = new JLabel("Validade:");
		lblValidade_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade_3.setBounds(32, 336, 74, 40);
		contentPane.add(lblValidade_3);
		
		JLabel lblValidade_4 = new JLabel("Validade:");
		lblValidade_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade_4.setBounds(32, 297, 74, 40);
		contentPane.add(lblValidade_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Receita");
		rdbtnNewRadioButton.setBounds(120, 308, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Genérico");
		rdbtnNewRadioButton_1.setBounds(120, 347, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblValidade_3_1 = new JLabel("Preço:");
		lblValidade_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade_3_1.setBounds(38, 379, 74, 40);
		contentPane.add(lblValidade_3_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaProduto = new TelaAdicionarProduto(Main.ESTOQUE, funcionarioLogado);
                telaProduto.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(37, 441, 98, 44);
		contentPane.add(btnNewButton);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String fabricante = textField_1.getText();
				String dataFrabricacao = textField_2.getText();
				String dataValidade = textField_3.getText();
				Float peso = Float.parseFloat(textField_4.getText());
				int cod = Integer.parseInt(textField_5.getText());
				boolean receita = rdbtnNewRadioButton.isSelected();
				boolean generico = rdbtnNewRadioButton_1.isSelected();
				Float preco = Float.parseFloat(textField_6.getText());
				
				
				Produto medicamento = new Medicamento(nome, fabricante, dataFrabricacao, dataValidade, peso, receita, generico);
				
				try {
					Main.ESTOQUE.cadastrarProduto(medicamento, cod);
					JOptionPane.showMessageDialog(contentPane, "Produto cadastrado!");
					dispose();
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
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdicionar.setBounds(342, 441, 109, 44);
		contentPane.add(btnAdicionar);
	}
}
