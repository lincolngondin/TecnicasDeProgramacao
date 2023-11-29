package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AppController;

public class ButtonRecordReport extends Button {
	private static final long serialVersionUID = 1L;
	private static final String text = "Gravar Relatório";
	public ButtonRecordReport(JPanel pane) {
		super(pane, text);
	}
	@Override
	public void act() {
		boolean state = AppController.getInstance().recordReport();
		if(state) {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Informacoes salva com sucesso no banco de dados!");
		}
		else {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Houve algum erro na comunicação com o banco de dados!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
