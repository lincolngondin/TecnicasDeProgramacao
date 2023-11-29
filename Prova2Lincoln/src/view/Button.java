package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

abstract public class Button extends JButton {
	private static final long serialVersionUID = 1L;
	public Button(JPanel pane, String text) {
		super(text);
		this.addActionListener((ActionListener) pane);
		this.setPreferredSize(new Dimension(40, 20));
		this.setMaximumSize(new Dimension(40, 20));
	}
	abstract public void act();
}
