package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class ViewTarefa extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -146990239737090873L;
	private JTextField tfPesquisa;
	private JTextField tfTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTarefa frame = new ViewTarefa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ViewTarefa() {
		setClosable(true);
		setBounds(100, 100, 450, 411);
		getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 414, 359);
		getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 394, 226);
		layeredPane.add(panel, Integer.valueOf(1));
		panel.setLayout(null);
		
		JLabel lbTitulo = new JLabel("Titulo");
		lbTitulo.setBounds(21, 11, 46, 14);
		panel.add(lbTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(77, 8, 86, 20);
		panel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lbData = new JLabel("Data");
		lbData.setBounds(21, 43, 46, 14);
		panel.add(lbData);
		
		JFormattedTextField ftfData = new JFormattedTextField();
		ftfData.setBounds(77, 40, 101, 20);
		panel.add(ftfData);
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setBounds(21, 68, 46, 14);
		panel.add(lbDescricao);
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBounds(21, 88, 217, 127);
		panel.add(taDescricao);
		
		JLabel lbPesquisa = new JLabel("Pesquisa :");
		lbPesquisa.setBounds(10, 11, 60, 14);
		layeredPane.add(lbPesquisa,Integer.valueOf(0));
		
		JList lsResultado = new JList<String>();
		lsResultado.setBounds(67, 34, 125, 64);
		layeredPane.add(lsResultado);
		lsResultado.setVisibleRowCount(2);
		lsResultado.setVisible(false);
		lsResultado.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"teste1", "teste2", "teste3", "teste4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(67, 11, 125, 20);
		layeredPane.add(tfPesquisa,Integer.valueOf(0));
		tfPesquisa.setColumns(10);

	}
}
