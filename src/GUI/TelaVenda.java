package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.excript.Farmacia.Estoque;

import excessoes.CadastroInvalido;
import main.Main;
import mercadoria.Produto;

public class TelaVenda extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblTotal;

    public TelaVenda(Estoque estoque, String funcionarioLogado) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 662, 512);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(funcionarioLogado);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(25, 27, 141, 44);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 112, 568, 257);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "Preço:", "Qtd:" }) {
            private static final long serialVersionUID = 1L;
            Class<?>[] columnTypes = new Class[] { String.class, Float.class, Integer.class };

            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        model.addRow(new Object[] { "Nome:", "Preço:", "Qtd:" });

        final float[] total = {0.0f};

        for (Map.Entry<Integer, Produto> entry : Main.ESTOQUE.getMercadorias().entrySet()) {
            int codigo = entry.getKey();
            Produto produto = entry.getValue();

            int quantidade = 0;
            float preco = 0.0f;

            try {
                quantidade = Main.ESTOQUE.consultarQuantidade(codigo);
                preco = Main.ESTOQUE.consultarPreco(codigo);
            } catch (CadastroInvalido e) {
                JOptionPane.showMessageDialog(contentPane,"Erro cadastro inválido!");
            }

            model.addRow(new Object[] { produto.getNome(), preco, quantidade });
            total[0] += preco * quantidade;
        }

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(472);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);

        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("Total:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(464, 380, 65, 25);
        contentPane.add(lblNewLabel_1);

        lblTotal = new JLabel(String.format("%.2f", total[0]));
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotal.setBounds(525, 380, 68, 25);
        contentPane.add(lblTotal);

        JButton btnAdicionar = new JButton("+");
        btnAdicionar.setBounds(603, 124, 39, 32);
        contentPane.add(btnAdicionar);

        JButton btnRemover = new JButton("-");
        btnRemover.setBounds(597, 177, 39, 23);
        contentPane.add(btnRemover);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow > 0) {
                    int codigo = Main.ESTOQUE.buscarProduto(model.getValueAt(selectedRow, 0).toString());
                    int quantidade = 0;
					try {
						quantidade = Main.ESTOQUE.consultarQuantidade(codigo);
					} catch (CadastroInvalido e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    if (quantidade > 0) {
                        quantidade--;
                        try {
							Main.ESTOQUE.atualizarQuantidade(codigo, quantidade);
						} catch (CadastroInvalido e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        model.setValueAt(quantidade, selectedRow, 2);
                        float preco = 0;
						try {
							preco = Main.ESTOQUE.consultarPreco(codigo);
						} catch (CadastroInvalido e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						total[0] += preco;
						lblTotal.setText(String.format("%.2f", total[0]));
                    }
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow > 0) {
                    int codigo = Main.ESTOQUE.buscarProduto(model.getValueAt(selectedRow, 0).toString());
                    int quantidade = 0;
					try {
						quantidade = Main.ESTOQUE.consultarQuantidade(codigo);
					} catch (CadastroInvalido e2) {
						JOptionPane.showMessageDialog(contentPane,"Erro cadastro inválido!");
						e2.printStackTrace();
					}
                    quantidade++;
                    try {
						Main.ESTOQUE.atualizarQuantidade(codigo, quantidade);
					} catch (CadastroInvalido e1) {
						JOptionPane.showMessageDialog(contentPane,"Erro cadastro inválido!");
						e1.printStackTrace();
					}
                    model.setValueAt(quantidade, selectedRow, 2);
                    float preco = 0;
					try {
						preco = Main.ESTOQUE.consultarPreco(codigo);
					} catch (CadastroInvalido e1) {
						JOptionPane.showMessageDialog(contentPane,"Erro cadastro inválido!");
						e1.printStackTrace();
					}
					total[0] -= preco;
					lblTotal.setText(String.format("%.2f", total[0]));
                }
            }
        });

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBounds(25, 431, 617, 32);
        contentPane.add(btnFinalizar);

        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para finalizar a venda
            }
        });
    }
}
