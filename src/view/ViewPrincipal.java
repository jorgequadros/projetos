package view;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ViewPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 44, 764, 331);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 571, 22);
		contentPane.add(menuBar);
		
		JMenu mnuCadastro = new JMenu("Cadastro");
		menuBar.add(mnuCadastro);
		
		JMenuItem mnitTarefa = new JMenuItem("Tarefa");
		mnuCadastro.add(mnitTarefa);
		
		JMenu mnConsulta = new JMenu("New menu");
		menuBar.add(mnConsulta);
		
		JMenuItem MenuItemTarefa = new JMenuItem("Tarefa");
		mnConsulta.add(MenuItemTarefa);
	}
}
