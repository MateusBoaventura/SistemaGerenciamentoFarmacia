package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	/**
	 * Create the frame.
	 */
	public TelaEstoque(Estoque estoque, String funcionarioLogado) {
		
		System.out.println(Main.ESTOQUE);
		
		setTitle("Opções Estoque");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JButton btnNewButton_1 = new JButton("Adicionar Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaAddProduto = new TelaAdicionarProduto(Main.ESTOQUE, funcionarioLogado);
				telaAddProduto.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(150, 69, 239, 39);
		getContentPane().add(btnNewButton_1);

		JButton btnAtualizarProduto = new JButton("Atualizar/Remover Produto");
		btnAtualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarRemoverProduto telaAttProd = new TelaAtualizarRemoverProduto(Main.ESTOQUE, funcionarioLogado);
				telaAttProd.setVisible(true);
				dispose();
			}
		});
		btnAtualizarProduto.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizarProduto.setBounds(150, 149, 251, 39);
		getContentPane().add(btnAtualizarProduto);

		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaDeProdutos telaProduto = new TelaListaDeProdutos(Main.ESTOQUE, funcionarioLogado);
				telaProduto.setVisible(true);
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
				btnNewButton_2.setBounds(18, 279, 92, 39);
				getContentPane().add(btnNewButton_2);
		btnListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListarProdutos.setBounds(150, 224, 239, 39);
		getContentPane().add(btnListarProdutos);
	}

}
