package controller;

import model.App;
import view.FileState;

public class AppController {
	private static AppController instance;
	App app;
	private AppController() {
		app = new App();
	}
	public boolean recordReport() {
		return app.recordReport();
	}
	public boolean readData() {
		return app.readData();
	}
	public boolean recordOutputFile() {
		return app.recordOutputFile();
	}
	public boolean readNewInputFile(String filename) {
		return app.readNewInputFile(filename);
	}
	public FileState processNextInstant() {
		return app.processNextInstant();
	}
	public static AppController getInstance() {
		if(instance == null) {
			instance = new AppController();
		}
		return instance;
	}
}
