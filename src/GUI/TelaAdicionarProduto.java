package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.excript.Farmacia.*;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class TelaAdicionarProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	
	public TelaAdicionarProduto(Estoque estoque, String funcionarioLogado) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Adicionar Medicamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarMedicamento telaMedicamento = new TelaAdicionarMedicamento (estoque, funcionarioLogado);
				telaMedicamento.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(151, 49, 207, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnAdicionar = new JButton(" Adicionar Cosmético");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarCosmetico telaCosmetico = new TelaAdicionarCosmetico(estoque, funcionarioLogado);
				telaCosmetico.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdicionar.setBounds(151, 106, 207, 38);
		getContentPane().add(btnAdicionar);
		
		JButton btnNewButton_1_1 = new JButton("Adicionar GiftCard");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarGiftCard telaGiftCard = new TelaAdicionarGiftCard(estoque, funcionarioLogado);
				telaGiftCard.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(151, 215, 207, 38);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Adicionar Comida");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarComida telaComida = new TelaAdicionarComida(estoque, funcionarioLogado);
				telaComida.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(151, 158, 207, 38);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Adicionar Variado");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarVariado telaVariado = new TelaAdicionarVariado(estoque, funcionarioLogado);
				telaVariado.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setBounds(151, 274, 207, 38);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque(estoque, funcionarioLogado);
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(16, 317, 79, 59);
		getContentPane().add(btnNewButton_1);

	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
