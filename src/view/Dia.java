package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Dia extends JButton{

	public Dia(String texto) {
		super();
		// TODO Auto-generated constructor stub
		setText(texto);
		setOpaque(true);
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setFont(new Font("courier", Font.PLAIN, 25));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	

}
