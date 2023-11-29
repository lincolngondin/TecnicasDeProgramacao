package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InputFile {
	private Scanner sn;
	private String filename;
	public InputFile(String filename) throws FileNotFoundException {
		this.sn = new Scanner(new BufferedReader(new FileReader("input/"+filename)));
		this.filename = filename;
	}
	public String getNextLine() {
		if(sn != null) {
			if(sn.hasNextLine()) {
				return sn.nextLine();
			}
		}
		return "";
	}
	public String getFilename() {
		return this.filename;
	}

}
