package view;

import java.awt.FileDialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AppController;

public class ButtonReadNewInputFile extends Button{
	private static final long serialVersionUID = 1L;
	private static final String text = "Ler novo arquivo de entrada";

	public ButtonReadNewInputFile(JPanel pane) {
		super(pane, text);
	}

	@Override
	public void act() {
		FileDialog fd = new FileDialog(MainWindow.getInstance(), "Escolha o arquivo de entrada!", FileDialog.LOAD);
		fd.setFile("*.csv");
		fd.setDirectory("input");
		fd.setVisible(true);
		String filename = fd.getFile();
		if(filename != null) {
			boolean readed = AppController.getInstance().readNewInputFile(filename);
			if(!readed) {
				JOptionPane.showMessageDialog(MainWindow.getInstance(), "Arquivo não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(MainWindow.getInstance(), "Arquivo lido com sucesso!");
			}
		}
		else {
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Operação cancelada!", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}
	}
}
