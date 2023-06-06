package GUI;

import javax.swing.JPanel;
import com.excript.Farmacia.*;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.*;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdicionarCosmetico extends JPanel {
	private JTextField txtNome;
	private JTextField txtFabricante;
	private JTextField txtDataDeFabricao;
	private JTextField txtDataDeValidade;
	private JTextPane txtpnNome;
	private JTextPane txtpnFabricante;
	private JTextPane txtpnDataDeFabricao;
	private JTextPane txtpnDataDeValidade;
	private JTextPane txtpnCdigo;
	private JTextField txtCodigo;
	protected Component contentPane;
	private JTextPane txtpnPreo;
	private JTextField txtPreco;

	/**
	 * Create the panel.
	 */
	public TelaAdicionarCosmetico(Estoque estoque, String funcionarioLogado) {
		setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(240, 240, 240));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(118, 11, 322, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtFabricante = new JTextField();
		txtFabricante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFabricante.setColumns(10);
		txtFabricante.setBackground(SystemColor.menu);
		txtFabricante.setBounds(118, 41, 322, 20);
		add(txtFabricante);
		
		txtDataDeFabricao = new JTextField();
		txtDataDeFabricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDataDeFabricao.setColumns(10);
		txtDataDeFabricao.setBackground(SystemColor.menu);
		txtDataDeFabricao.setBounds(118, 72, 322, 20);
		add(txtDataDeFabricao);
		
		txtDataDeValidade = new JTextField();
		txtDataDeValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDataDeValidade.setColumns(10);
		txtDataDeValidade.setBackground(SystemColor.menu);
		txtDataDeValidade.setBounds(118, 103, 322, 20);
		add(txtDataDeValidade);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String fabricante = txtFabricante.getText();
				String dataFrabricacao = txtDataDeFabricao.getText();
				String dataValidade = txtDataDeValidade.getText();
				int cod = Integer.parseInt(txtCodigo.getText());
				Float preco = Float.parseFloat(txtPreco.getText());
				
				
				Produto cosmetico = new Cosmetico(nome, fabricante, dataFrabricacao, dataValidade);
				
				try {
					estoque.cadastrarProduto(cosmetico, cod);
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(304, 272, 136, 23);
		add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarProduto telaProduto = new TelaAdicionarProduto(estoque, funcionarioLogado);
                telaProduto.setVisible(true);
                dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(10, 274, 113, 23);
		add(btnVoltar);
		
		txtpnNome = new JTextPane();
		txtpnNome.setBorder(null);
		txtpnNome.setBackground(new Color(240, 240, 240));
		txtpnNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNome.setText("Nome:");
		txtpnNome.setBounds(10, 11, 43, 20);
		add(txtpnNome);
		
		txtpnFabricante = new JTextPane();
		txtpnFabricante.setText("Fabricante:");
		txtpnFabricante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnFabricante.setBorder(null);
		txtpnFabricante.setBackground(SystemColor.menu);
		txtpnFabricante.setBounds(10, 41, 64, 20);
		add(txtpnFabricante);
		
		txtpnDataDeFabricao = new JTextPane();
		txtpnDataDeFabricao.setText("Data de fabricação:");
		txtpnDataDeFabricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnDataDeFabricao.setBorder(null);
		txtpnDataDeFabricao.setBackground(SystemColor.menu);
		txtpnDataDeFabricao.setBounds(10, 72, 113, 20);
		add(txtpnDataDeFabricao);
		
		txtpnDataDeValidade = new JTextPane();
		txtpnDataDeValidade.setText("Descrição:");
		txtpnDataDeValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnDataDeValidade.setBorder(null);
		txtpnDataDeValidade.setBackground(SystemColor.menu);
		txtpnDataDeValidade.setBounds(10, 103, 113, 20);
		add(txtpnDataDeValidade);
		
		txtpnCdigo = new JTextPane();
		txtpnCdigo.setText("Código:");
		txtpnCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnCdigo.setBorder(null);
		txtpnCdigo.setBackground(SystemColor.menu);
		txtpnCdigo.setBounds(10, 129, 113, 20);
		add(txtpnCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(SystemColor.menu);
		txtCodigo.setBounds(118, 129, 322, 20);
		add(txtCodigo);
		
		txtpnPreo = new JTextPane();
		txtpnPreo.setText("Preço:");
		txtpnPreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPreo.setBorder(null);
		txtpnPreo.setBackground(SystemColor.menu);
		txtpnPreo.setBounds(10, 156, 113, 20);
		add(txtpnPreo);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPreco.setColumns(10);
		txtPreco.setBackground(SystemColor.menu);
		txtPreco.setBounds(118, 155, 322, 20);
		add(txtPreco);

	}
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
