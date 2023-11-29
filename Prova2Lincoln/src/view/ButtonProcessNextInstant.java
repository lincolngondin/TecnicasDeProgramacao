package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AppController;

public class ButtonProcessNextInstant extends Button {
	private static final long serialVersionUID = 1L;
	private static final String text = "Processar Próximo instante";
	public ButtonProcessNextInstant(JPanel pane) {
		super(pane, text);
	}
	@Override
	public void act() {
		FileState answer = AppController.getInstance().processNextInstant();
		switch(answer) {
			case FILE_NOT_OPEN:
				JOptionPane.showMessageDialog(MainWindow.getInstance(), "Nenhum arquivo de entrada carregado!", "Erro!", JOptionPane.ERROR_MESSAGE);
				break;
			case FILE_ENDED:
				JOptionPane.showMessageDialog(MainWindow.getInstance(), "O arquivo chegou no final!", "Aviso!", JOptionPane.WARNING_MESSAGE);
				break;
			default:
				break;
		}
	}
}
