package View;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewCadTarefa extends JInternalFrame {

	private JFormattedTextField ftfDataTarefa;
	private JTextField tfTituloTarefa;
	/**
	 * Cadastro de Tarefa Criado em Windows Builder
	 * data 06/11/2022
	 * autor: Jorge Quadros
	 * 
	 * Descrição: Criado InternalFrame Utilizado no DesktopPane
	 */

	public ViewCadTarefa() {
		setClosable(true);
		setBounds(100, 100, 261, 300);
		getContentPane().setLayout(null);
		ftfDataTarefa = new JFormattedTextField();
		ftfDataTarefa.setBounds(10, 25, 90, 20);
		formatarCampo();
		getContentPane().add(ftfDataTarefa);
		
		JLabel lbDataTarefa = new JLabel("Data Tarefa");
		lbDataTarefa.setBounds(10, 11, 90, 14);
		getContentPane().add(lbDataTarefa);
		
		JLabel lbTituloTarefa = new JLabel("Titulo Tarefa");
		lbTituloTarefa.setBounds(10, 56, 90, 14);
		getContentPane().add(lbTituloTarefa);
		
		tfTituloTarefa = new JTextField();
		tfTituloTarefa.setBounds(10, 70, 212, 20);
		getContentPane().add(tfTituloTarefa);
		tfTituloTarefa.setColumns(10);
		
		JLabel lbAssunto = new JLabel("Assunto :");
		lbAssunto.setBounds(10, 101, 46, 14);
		getContentPane().add(lbAssunto);
		
		JScrollPane spAssunto = new JScrollPane();
		spAssunto.setBounds(10, 114, 212, 105);
		getContentPane().add(spAssunto);
		
		JTextArea taAssunto = new JTextArea();
		spAssunto.setViewportView(taAssunto);
		
		JButton btCadastro = new JButton("Cadastro");
		btCadastro.setBounds(11, 230, 89, 23);
		getContentPane().add(btCadastro);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(133, 230, 89, 23);
		getContentPane().add(btCancelar);

	}
	
	private void formatarCampo() {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(ftfDataTarefa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showInputDialog(null,"Erro ao formatar campo de Texto.","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
}
