package GUI;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.EventQueue;

import com.excript.Farmacia.*;
import excessoes.*;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarProduto extends JPanel {
	private JTextField txtID;
	private JTextField txtQuantidade;
	protected Component contentPane;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarProduto (Estoque estoque, String funcionarioLogado) {
		setLayout(null);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setBackground(new Color(240, 240, 240));
		txtpnId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnId.setText("ID: ");
		txtpnId.setBounds(10, 55, 28, 20);
		add(txtpnId);
		
		txtID = new JTextField();
		txtID.setBounds(108, 55, 332, 20);
		add(txtID);
		txtID.setColumns(10);
		
		JTextPane txtpnQuantidade = new JTextPane();
		txtpnQuantidade.setText("Quantidade:");
		txtpnQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnQuantidade.setBackground(SystemColor.menu);
		txtpnQuantidade.setBounds(10, 86, 89, 20);
		add(txtpnQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(108, 86, 332, 20);
		add(txtQuantidade);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtID.getText());
				int qtd = Integer.parseInt(txtQuantidade.getText());
				
				try {
					estoque.atualizarQuantidade(id, qtd);
				} catch (CadastroInvalido ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro, código inválido");
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(322, 266, 118, 23);
		add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque(estoque, funcionarioLogado);
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnVoltar.setBounds(10, 268, 118, 23);
		add(btnVoltar);

	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
