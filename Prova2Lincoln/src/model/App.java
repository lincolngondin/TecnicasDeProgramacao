package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import view.FileState;
import view.MainWindow;

public class App {
	private ArrayList<Report> allData;
	private InputFile inputFile;
	private JavalarSystem sistema;
	private PixelManager pixelManager;
	public App() {
		view.MainWindow.getInstance();
		this.allData = null;
		this.inputFile = null;
		this.sistema = new JavalarSystem();
		this.pixelManager = new PixelManager(15, 15);
		this.pixelManager.update(this.sistema);
		MainWindow.getInstance().getGamePanel().drawInstant(this.pixelManager);
	}
	// Gravar relatorio
	public boolean recordReport() {
		Report rp = new ReportManager().createReport(this.sistema, "Lincoln", "548333", this.inputFile.getFilename());
		ReportDAO rpdao = new ReportDAO();
		boolean state = rpdao.inserir(rp);
		return state;
	}
	// Ler dados de outros participantes
	public boolean readData() {
		ReportDAO rpdao = new ReportDAO();
		this.allData = rpdao.getAllData();
		if(this.allData == null) {
			return false;
		}
		return true;
	}
	// Grravar arquivo de saida
	public boolean recordOutputFile() {
		if(this.allData != null) {
			OutputFile file = OutputFileController.getOutputFile(this.allData);
			OutputFileController.saveFile(file);
			return true;
		}
		return false;
	}
	//Ler novo arquivo de entrada
	public boolean readNewInputFile(String filename) {
		try {
			inputFile = new InputFile(filename);
			inputFile.getNextLine();
			this.resetState();
			return true;
		}
		catch(FileNotFoundException err) {
			err.printStackTrace();
			inputFile = null;
			return false;
		}
	}
	//Processar proximo instante
	public FileState processNextInstant() {
		if(this.inputFile == null) {
			return FileState.FILE_NOT_OPEN;
		}
		else {
			String line = this.inputFile.getNextLine();
			if(line == "") {
				return FileState.FILE_ENDED;
			}
			Instant instant = new Instant(line);
			
			this.sistema.moverSistema(instant);
			this.pixelManager.update(this.sistema);
			MainWindow.getInstance().getGamePanel().drawInstant(this.pixelManager);

			return FileState.FILE_OK;
		}
	}
	private void resetState() {
		this.sistema.getAsteroides().removerTodosObstaculos();
		this.sistema = new JavalarSystem();
		this.pixelManager = new PixelManager(15, 15);
		this.pixelManager.update(this.sistema);
		MainWindow.getInstance().getGamePanel().drawInstant(this.pixelManager);
	}
}
