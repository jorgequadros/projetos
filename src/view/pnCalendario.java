package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pnCalendario extends JPanel implements ActionListener{
		
	public pnCalendario() {
		super();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		adicionarBotao("1", c, 0, 0);
	}
	
	@SuppressWarnings("unused")
	private void adicionarBotao(String texto, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		Dia dia = new Dia(texto);
		dia.addActionListener(this);
		add(dia, c);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton  dia = (JButton) e.getSource();
			
			
		}
	}

	public static void main(String[] args) {
		
	}
	
}

