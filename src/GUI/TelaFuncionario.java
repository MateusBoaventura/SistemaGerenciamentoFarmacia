package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.excript.Farmacia.Estoque;

public class TelaFuncionario extends JFrame {
	
	private Estoque estoque;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @paramfuncionarioLogado 
	 */
	public TelaFuncionario(String funcionarioLogado) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 238, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(funcionarioLogado);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(152, 11, 139, 82);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Estoque");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
	                TelaEstoque telaEstoque = new TelaEstoque(estoque, funcionarioLogado);
	                
	                telaEstoque.setVisible(true);
	                dispose();
	            }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(133, 104, 122, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Venda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda telaVenda = new TelaVenda(estoque, funcionarioLogado);
                
                telaVenda.setVisible(true);
                dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(133, 188, 122, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Exame");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(133, 270, 122, 63);
		contentPane.add(btnNewButton_1_1);
	}
}
