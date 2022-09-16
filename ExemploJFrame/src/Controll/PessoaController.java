package Controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import persistencia.PessoaDao;

public class PessoaController implements ActionListener{
	private JTextField tfPessoa;
	private JFormattedTextField tfPosicao;
	private JTextArea taLista;
	private PessoaDao pDao;

	
	public PessoaController(JTextField tfPessoa, JFormattedTextField tfPosicao, JTextArea taLista) {
		this.tfPessoa = tfPessoa;
		this.tfPosicao = tfPosicao;
		this.taLista = taLista;
		pDao = new PessoaDao();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Adicionar")) {
			adicionar(tfPessoa.getText());
		}
		
		if(cmd.equals("Excluir")) {
			int posicao = Integer.parseInt(tfPosicao.getText());
			Excluir(posicao);
		}

		if(cmd.equals("Consultar")) {
			int posicao = Integer.parseInt(tfPosicao.getText());
			consultar(posicao);
		}

		if(cmd.equals("Listar")) {
			listar();
		}
		
		
	}


	private void listar() {
		// TODO Auto-generated method stub
		String[] pessoas = pDao.consultaPessoas();
		StringBuffer buffer = new StringBuffer();
		
		for (String pessoa : pessoas) {
			buffer.append(pessoa);
			buffer.append("\n");
		}
		
		taLista.setText(buffer.toString());
	}


	private void consultar(int posicao) {
		// TODO Auto-generated method stub
		String pessoa = pDao.consultaPessoa(posicao);
		tfPessoa.setText(pessoa);
		tfPosicao.setText("0");
	}


	private void Excluir(int posicao) {
		// TODO Auto-generated method stub
		pDao.excluirPessoa(posicao);
		tfPosicao.setText("0");
		listar();
	}


	private void adicionar(String pessoa) {
		// TODO Auto-generated method stub
		String retorno = pDao.adicionaPessoa(pessoa);
		if(retorno.contains("Pessoa Inserida")) {
			JOptionPane.showMessageDialog(null, retorno, "Sucesso!!",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, retorno, "ERRO!!",JOptionPane.ERROR_MESSAGE);
		}
		
		tfPessoa.setText("");
		listar();
	}

}
