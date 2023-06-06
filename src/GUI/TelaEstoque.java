package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Font;
import com.excript.Farmacia.*;

import main.Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	
	/**
	 * Create the frame.
	 */
	public TelaEstoque(Estoque estoque, String funcionarioLogado) {
		
		cardLayout = new CardLayout();
		System.out.println(estoque);
		
		setTitle("Opções Estoque");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Remover Produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverProduto telaRemProd = new TelaRemoverProduto(estoque, funcionarioLogado);
				telaRemProd.setVisible(true);
				// dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(133, 244, 251, 39);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Adicionar Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaAddProduto = new TelaAdicionarProduto(Main.ESTOQUE, funcionarioLogado);
				telaAddProduto.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(133, 48, 251, 39);
		getContentPane().add(btnNewButton_1);

		JButton btnAtualizarProduto = new JButton("Atualizar Produto");
		btnAtualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarProduto telaAttProd = new TelaAtualizarProduto(estoque, funcionarioLogado);
				telaAttProd.setVisible(true);
				dispose();
			}
		});
		
				JButton btnNewButton_2 = new JButton("Voltar");
				btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaFuncionario telaFuncionario = new TelaFuncionario(funcionarioLogado);
						telaFuncionario.setVisible(true);
						dispose();
					}
				});
				btnNewButton_2.setBounds(10, 305, 81, 42);
				getContentPane().add(btnNewButton_2);
		btnAtualizarProduto.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizarProduto.setBounds(133, 114, 251, 39);
		getContentPane().add(btnAtualizarProduto);

		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FALTANDO
			}
		});
		btnListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListarProdutos.setBounds(133, 178, 250, 39);
		getContentPane().add(btnListarProdutos);
	}

}
