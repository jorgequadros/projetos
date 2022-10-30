package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calc extends  JFrame{

	public Calc(){
		super("Calculadora");
		organizarLayout();
		setSize(235, 250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display1 display = new Display1();
		display.setPreferredSize(new Dimension(220,60));
		add(display, BorderLayout.NORTH);
		
		Teclado1 teclado= new Teclado1();
		add(teclado,BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new Calc();
	}
}
