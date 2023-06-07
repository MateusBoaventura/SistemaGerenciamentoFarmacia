package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.excript.Farmacia.Estoque;

import excessoes.CadastroInvalido;
import main.Main;
import mercadoria.Produto;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaVenda(Estoque estoque, String funcionarioLogado) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 242, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FUNCIONÁRIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 27, 141, 44);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 112, 568, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome:", "Pre\u00E7o:", "Qtd:"
				}
			) {
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
				
			}
		});
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpar os dados existentes na tabela

		model.addRow(new Object[]{"Nome:", "Preço:", "Qtd:"}); // Adicionar cabeçalhos das colunas

		for (Map.Entry<Integer, Produto> entry : Main.ESTOQUE.getMercadorias().entrySet()) {
		    int codigo = entry.getKey();
		    Produto produto = entry.getValue();
		    
		    int quantidade = -1;
		    float preco = -1.0f;

		    try {
		        quantidade = Main.ESTOQUE.consultarQuantidade(codigo);
		        preco = Main.ESTOQUE.consultarPreco(codigo);
		    } catch (CadastroInvalido e) {
		        // Lidar com a exceção de cadastro inválido, se necessário
		    }

		    model.addRow(new Object[]{produto.getNome(), preco, quantidade});
		}

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(472);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);

		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Nome:", "Pre\u00E7o:", "Qtd:"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, String.class, Integer.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(0).setResizable(false);
//		table.getColumnModel().getColumn(0).setPreferredWidth(472);
//		table.getColumnModel().getColumn(1).setResizable(false);
//		table.getColumnModel().getColumn(2).setResizable(false);
//		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(464, 380, 65, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("VALOR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(513, 380, 65, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(463, 416, 115, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario telaFuncionario = new TelaFuncionario(funcionarioLogado);
                telaFuncionario.setVisible(true);
                dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(25, 414, 106, 33);
		contentPane.add(btnNewButton_1);
	}
}
