package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Observador;
import model.Operacao;

@SuppressWarnings("serial")
public class Display1 extends JPanel implements Observador {
	
	JLabel label;
	public Display1() {
		setForeground(Color.BLACK);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		Operacao.getInstanca().adicionarObservador(this);
		label = new JLabel(Operacao.getInstanca().getTextoAtual());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 11, 200, 80);
		add(label);

	}

	@Override
	public void valorAlterado(String novoValor) {
		// TODO Auto-generated method stub
		label.setText(novoValor);
	}
}
