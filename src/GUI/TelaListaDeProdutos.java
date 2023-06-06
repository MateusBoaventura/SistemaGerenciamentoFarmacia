package GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import com.excript.Farmacia.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaDeProdutos extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListaDeProdutos(Estoque estoque, String funcionarioLogado) {
		setLayout(null);
		
		JTextPane txtpnAquiEstoOs = new JTextPane();
		txtpnAquiEstoOs.setBackground(new Color(240, 240, 240));
		txtpnAquiEstoOs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAquiEstoOs.setText("Aqui estão os items em estoque:");
		txtpnAquiEstoOs.setBounds(10, 11, 195, 20);
		add(txtpnAquiEstoOs);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(estoque.toString());
		
		textArea.setBounds(20, 42, 420, 197);
		add(textArea);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque(estoque, funcionarioLogado);
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 266, 89, 23);
		add(btnNewButton);

	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
