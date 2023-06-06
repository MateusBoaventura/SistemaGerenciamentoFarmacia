package GUI;

import javax.swing.JPanel;
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
import com.excript.Farmacia.*;

import excessoes.CadastroInvalido;
import excessoes.JaCadastrado;
import mercadoria.*;

public class TelaAdicionarGiftCard extends JPanel {
	private JTextField txtNome;
	private JTextField txtFabricante;
	private JTextField txtDataDeFabricao;
	private JTextField txtDataDeValidade;
	private JTextField txtValor;
	private JTextField txtCodgo;
	private JTextField txtJogo;
	private JTextPane txtpnNome;
	private JTextPane txtpnFabricante;
	private JTextPane txtpnDataDeFabricao;
	private JTextPane txtpnDataDeValidade;
	private JTextPane txtpnValor;
	private JTextPane txtpnJogo;
	private JTextPane txtpnCdigo;
	protected Component contentPane;

	/**
	 * Create the panel.
	 */
	public TelaAdicionarGiftCard(Estoque estoque, String funcionarioLogado) {
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
		
		txtValor = new JTextField();
		txtValor.setToolTipText("");
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtValor.setColumns(10);
		txtValor.setBackground(SystemColor.menu);
		txtValor.setBounds(118, 134, 322, 20);
		add(txtValor);
		
		txtCodgo = new JTextField();
		txtCodgo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodgo.setColumns(10);
		txtCodgo.setBackground(SystemColor.menu);
		txtCodgo.setBounds(118, 196, 322, 20);
		add(txtCodgo);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String fabricante = txtFabricante.getText();
				String dataFrabricacao = txtDataDeFabricao.getText();
				String dataValidade = txtDataDeValidade.getText();
				Float valor = Float.parseFloat(txtValor.getText());
				String jogo = txtJogo.getText();
				int cod = Integer.parseInt(txtCodgo.getText());
				
				
				
				
				Produto GiftCard = new GiftCard(nome, fabricante, dataFrabricacao, dataValidade, valor, jogo);
				
				try {
					estoque.cadastrarProduto(GiftCard, cod);
				} catch (JaCadastrado ex) {
					JOptionPane.showMessageDialog(contentPane,"Erro ao cadastrar o produto, código já cadastrado");
				}
				
				try {
					estoque.atualizarPreco(cod, valor);
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
		
		txtJogo = new JTextField();
		txtJogo.setToolTipText("");
		txtJogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtJogo.setColumns(10);
		txtJogo.setBackground(SystemColor.menu);
		txtJogo.setBounds(118, 165, 322, 20);
		add(txtJogo);
		
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
		txtpnDataDeValidade.setText("Data de validade:");
		txtpnDataDeValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnDataDeValidade.setBorder(null);
		txtpnDataDeValidade.setBackground(SystemColor.menu);
		txtpnDataDeValidade.setBounds(10, 103, 113, 20);
		add(txtpnDataDeValidade);
		
		txtpnValor = new JTextPane();
		txtpnValor.setText("Valor:");
		txtpnValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnValor.setBorder(null);
		txtpnValor.setBackground(SystemColor.menu);
		txtpnValor.setBounds(10, 134, 113, 20);
		add(txtpnValor);
		
		txtpnJogo = new JTextPane();
		txtpnJogo.setText("Jogo:");
		txtpnJogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnJogo.setBorder(null);
		txtpnJogo.setBackground(SystemColor.menu);
		txtpnJogo.setBounds(10, 165, 113, 20);
		add(txtpnJogo);
		
		txtpnCdigo = new JTextPane();
		txtpnCdigo.setText("Código:");
		txtpnCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnCdigo.setBorder(null);
		txtpnCdigo.setBackground(SystemColor.menu);
		txtpnCdigo.setBounds(10, 196, 113, 20);
		add(txtpnCdigo);

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
