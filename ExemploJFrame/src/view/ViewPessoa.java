package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controll.PessoaController;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ViewPessoa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPessoa frame = new ViewPessoa();
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
	public ViewPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 25, 132, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblPosicao = new JLabel("Posição");
		lblPosicao.setBounds(10, 56, 46, 14);
		contentPane.add(lblPosicao);
		
		JFormattedTextField ftfPosicao = new JFormattedTextField();
		ftfPosicao.setBounds(10, 70, 46, 20);
		contentPane.add(ftfPosicao);
		
		JButton btListar = new JButton("Listar");
		btListar.setBounds(310, 101, 89, 23);
		contentPane.add(btListar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setBounds(109, 101, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.setBounds(211, 101, 89, 23);
		contentPane.add(btConsultar);
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.setBounds(10, 101, 89, 23);
		contentPane.add(btAdicionar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 135, 393, 115);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		PessoaController pCtrl = new PessoaController(tfNome,ftfPosicao,taLista);
		
		btAdicionar.addActionListener(pCtrl);
		btConsultar.addActionListener(pCtrl);
		btExcluir.addActionListener(pCtrl);
		btListar.addActionListener(pCtrl);
	}
}
