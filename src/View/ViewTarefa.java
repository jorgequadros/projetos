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
	private JTextField textField;

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
	public ViewTarefa() {
		setClosable(true);
		setBounds(100, 100, 450, 411);
		getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 414, 359);
		getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 55, 394, 226);
		layeredPane.add(panel, Integer.valueOf(1));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(21, 11, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(77, 8, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(21, 43, 46, 14);
		panel.add(lblNewLabel_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(77, 40, 101, 20);
		panel.add(formattedTextField);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(21, 68, 46, 14);
		panel.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 88, 217, 127);
		panel.add(textArea);
		
		JLabel lbPesquisa = new JLabel("Pesquisa :");
		lbPesquisa.setBounds(10, 11, 60, 14);
		layeredPane.add(lbPesquisa,Integer.valueOf(0));
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(67, 11, 125, 20);
		layeredPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JScrollPane spLsResultado = new JScrollPane();
		spLsResultado.setBounds(67, 35, 125, 50);
		layeredPane.add(spLsResultado,Integer.valueOf(3));
		
		JList lsResultado = new JList();
		lsResultado.setVisibleRowCount(3);
		lsResultado.setModel(new AbstractListModel() {
			String[] values = new String[] {"teste1", "teste2", "teste3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		spLsResultado.setViewportView(lsResultado);

	}
}
