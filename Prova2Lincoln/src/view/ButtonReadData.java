package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AppController;

public class ButtonReadData extends Button {
	private static final long serialVersionUID = 1L;
	private static final String text = "Ler dados de outros participantes";
	public ButtonReadData(JPanel panel) {
		super(panel, text);
	}
	@Override
	public void act() {
		boolean state = AppController.getInstance().readData();
		if(state) {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Informações lida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Erro na comunicação com o banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
