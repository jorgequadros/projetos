package View;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 22, 624, 328);
		contentPane.add(desktop);
		
		JMenuBar Barra = new JMenuBar();
		Barra.setBounds(0, 0, 624, 22);
		contentPane.add(Barra);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		Barra.add(mnCadastro);
		
		JMenuItem mnItemTarefa = new JMenuItem("New menu item");
		mnItemTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewCadTarefa frame = new ViewCadTarefa();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnCadastro.add(mnItemTarefa);
		
		JMenu mnConsulta = new JMenu("Consulta");
		Barra.add(mnConsulta);
	}
}
