package view;

import javax.swing.JPanel;

import model.Operacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Teclado1 extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	public Teclado1() {
		setLayout(null);
		
		JButton btSete = new JButton("7");
		btSete.setBounds(10, 41, 49, 23);
		btSete.addActionListener(this);
		add(btSete);
		
		JButton btOito = new JButton("8");
		btOito.setBounds(59, 41, 50, 23);
		btOito.addActionListener(this);
		add(btOito);
		
		JButton btNove = new JButton("9");
		btNove.setBounds(110, 41, 49, 23);
		btNove.addActionListener(this);
		add(btNove);
		
		JButton btSubtrair = new JButton("-");
		btSubtrair.setBounds(159, 11, 50, 23);
		btSubtrair.addActionListener(this);
		add(btSubtrair);
		
		JButton btQuatro = new JButton("4");
		btQuatro.setBounds(10, 65, 49, 23);
		btQuatro.addActionListener(this);
		add(btQuatro);
		
		JButton btCinco = new JButton("5");
		btCinco.setBounds(59, 65, 50, 23);
		btCinco.addActionListener(this);
		add(btCinco);
		
		JButton btSeis = new JButton("6");
		btSeis.setBounds(110, 65, 49, 23);
		btSeis.addActionListener(this);
		add(btSeis);
		
		JButton btSomar = new JButton("+");
		btSomar.setBounds(160, 41, 50, 23);
		btSomar.addActionListener(this);
		add(btSomar);
		
		JButton btUm = new JButton("1");
		btUm.setBounds(10, 90, 49, 23);
		btUm.addActionListener(this);
		add(btUm);
		
		JButton btDois = new JButton("2");
		btDois.setBounds(59, 90, 50, 23);
		btDois.addActionListener(this);
		add(btDois);
		
		JButton btTres = new JButton("3");
		btTres.setBounds(110, 90, 49, 23);
		btTres.addActionListener(this);
		add(btTres);
		
		JButton btMultiplicar = new JButton("*");
		btMultiplicar.setBounds(160, 65, 50, 23);
		btMultiplicar.addActionListener(this);
		add(btMultiplicar);
		
		JButton btZero = new JButton("0");
		btZero.setBounds(10, 116, 99, 23);
		btZero.addActionListener(this);
		add(btZero);
		
		JButton btAC = new JButton("AC");
		btAC.setBounds(10, 11, 149, 23);
		btAC.addActionListener(this);
		add(btAC);
		
		JButton btIqual = new JButton("=");
		btIqual.setBounds(160, 116, 50, 23);
		btIqual.addActionListener(this);
		add(btIqual);
		
		JButton btDividir = new JButton("/");
		btDividir.setBounds(160, 90, 50, 23);
		btDividir.addActionListener(this);
		add(btDividir);
		
		JButton btPonto = new JButton(".");
		btPonto.setBounds(110, 116, 49, 23);
		btPonto.addActionListener(this);
		add(btPonto);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Operacao.getInstanca().processaComando(botao.getText());
		}
		
	}
}
