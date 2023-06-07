package GUI;

import com.excript.Farmacia.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaDeProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public TelaListaDeProdutos(Estoque estoque, String funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAquiEstoOs = new JTextPane();
		txtpnAquiEstoOs.setBackground(new Color(240, 240, 240));
		txtpnAquiEstoOs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAquiEstoOs.setText("Aqui estão os itens em estoque:");
		txtpnAquiEstoOs.setBounds(10, 11, 197, 20);
		contentPane.add(txtpnAquiEstoOs);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(Main.ESTOQUE.toString());
		textArea.setBounds(10, 42, 414, 178);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque(estoque, funcionarioLogado);
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
