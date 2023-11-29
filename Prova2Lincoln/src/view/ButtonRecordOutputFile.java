package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AppController;

public class ButtonRecordOutputFile extends Button {
	private static final long serialVersionUID = 1L;
	private static final String text = "Gravar arquivo de saída";
	public ButtonRecordOutputFile(JPanel pane) {
		super(pane, text);
	}
	@Override
	public void act() {
		boolean state = AppController.getInstance().recordOutputFile();
		if(!state) {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "O arquivo de saida não pôde ser gravado pois não há dados carregados!\nClique em \"Ler dados de outros participantes\"", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Arquivo salvo com sucesso na pasta \"output/\".", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
