package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel() {
		
		this.setLayout(new GridLayout(0, 1));
		this.add(new ButtonProcessNextInstant(this));
		this.add(new ButtonReadNewInputFile(this));
		this.add(new ButtonRecordReport(this));
		this.add(new ButtonReadData(this));
		this.add(new ButtonRecordOutputFile(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		btn.act();
	}
}
