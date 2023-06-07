package GUI;

import java.awt.EventQueue;
import com.excript.Farmacia.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excessoes.CadastroInvalido;
import main.Main;

import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.DrbgParameters;
import java.awt.event.ActionEvent;

public class TelaAtualizarRemoverProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtQtd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public TelaAtualizarRemoverProduto(Estoque estoque, String funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton removerBt = new JRadioButton("Remover");
		removerBt.setBounds(87, 37, 69, 23);
		contentPane.add(removerBt);
		
		JRadioButton atualizaQtdBt = new JRadioButton("Atualizar");
		atualizaQtdBt.setBounds(6, 37, 79, 23);
		contentPane.add(atualizaQtdBt);
		
		JTextPane txtpnOQueDeseja = new JTextPane();
		txtpnOQueDeseja.setBackground(new Color(240, 240, 240));
		txtpnOQueDeseja.setText("O que deseja?");
		txtpnOQueDeseja.setBounds(10, 11, 79, 20);
		contentPane.add(txtpnOQueDeseja);
		
		JTextPane txtpnEscolhaOParmetro = new JTextPane();
		txtpnEscolhaOParmetro.setText("Escolha o parâmetro:");
		txtpnEscolhaOParmetro.setBackground(SystemColor.menu);
		txtpnEscolhaOParmetro.setBounds(6, 67, 116, 20);
		contentPane.add(txtpnEscolhaOParmetro);
		
		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setBounds(6, 94, 37, 23);
		contentPane.add(rdbtnId);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setBounds(45, 94, 69, 23);
		contentPane.add(rdbtnNome);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("ID:");
		txtpnId.setBackground(SystemColor.menu);
		txtpnId.setBounds(6, 124, 37, 20);
		contentPane.add(txtpnId);
		
		txtID = new JTextField();
		txtID.setBounds(75, 124, 349, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome:");
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setBounds(6, 155, 37, 20);
		contentPane.add(txtpnNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(75, 155, 349, 20);
		contentPane.add(txtNome);
		
		JTextPane txtpnQuantidade = new JTextPane();
		txtpnQuantidade.setText("Quantidade:");
		txtpnQuantidade.setBackground(SystemColor.menu);
		txtpnQuantidade.setBounds(6, 186, 69, 20);
		contentPane.add(txtpnQuantidade);
		
		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		txtQtd.setBounds(75, 186, 349, 20);
		contentPane.add(txtQtd);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque(Main.ESTOQUE, funcionarioLogado);
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(6, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean remover = removerBt.isSelected();
				boolean atualizar = atualizaQtdBt.isSelected();
				
				if (remover == true && atualizar == true) {
					JOptionPane.showMessageDialog(contentPane,"Erro, selecione apenas uma função");
				} else if (remover) {
					boolean id = rdbtnId.isSelected();
					boolean nome = rdbtnNome.isSelected();
					
					if (id == true  && nome == true) {
						JOptionPane.showMessageDialog(contentPane,"Erro, escolha apenas o ID");
					} else if (id) {
						int idProd = Integer.parseInt(txtID.getText());
						
						try {
							Main.ESTOQUE.removerProduto(idProd);
							JOptionPane.showMessageDialog(contentPane,"Produto removido");
						} catch (CadastroInvalido ex) {
							JOptionPane.showMessageDialog(contentPane,"Erro, código inválido");
						}
					} else {
						JOptionPane.showMessageDialog(contentPane,"Erro, ID não selecionado");
					}
				} else if (atualizar) {
					boolean id = rdbtnId.isSelected();
					boolean nome = rdbtnNome.isSelected();
					
					if (nome == true && id == true) {
						JOptionPane.showMessageDialog(contentPane,"Erro, selecione apenas um parâmetro");
					} else if (id) {
						int idProd = Integer.parseInt(txtID.getText());
						int qtd = Integer.parseInt(txtQtd.getText());
						
						try {
							Main.ESTOQUE.atualizarQuantidade(idProd, qtd);
							JOptionPane.showMessageDialog(contentPane,"Produto atualizado");
						} catch (CadastroInvalido ex) {
							JOptionPane.showMessageDialog(contentPane,"Erro, código inválido");
						}
					} else if (nome){
						String nomeProd = txtNome.getText();
						int qtd = Integer.parseInt(txtQtd.getText());
						
						try {
							Main.ESTOQUE.atualizarQuantidade(nomeProd, qtd);
							JOptionPane.showMessageDialog(contentPane,"Produto atualizado");
						} catch (CadastroInvalido ex) {
							JOptionPane.showMessageDialog(contentPane,"Erro, nome inválido");
						}
					} else {
						JOptionPane.showMessageDialog(contentPane,"Erro, selecione um parâmetro");
					}
				} 
			}
		});
		btnOk.setBounds(335, 227, 89, 23);
		contentPane.add(btnOk);
	}
}
