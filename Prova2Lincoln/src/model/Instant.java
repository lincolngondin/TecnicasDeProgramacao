package model;

import java.util.Scanner;

public class Instant {
	public int instantID;
	public int pythonInstant;
	public int javascriptInstant;
	public int rubyOnRailsInstant;
	public int PHPInstant;
	public int csharpInstant;
	public int cplusplusInstant;
	public int cInstant;
	public int qBug;
	public int qDev;
	public Instant(String lineInput) {
		if(lineInput != null || lineInput != "") {
			Scanner sc = new Scanner(lineInput);
			sc.useDelimiter(",");
			instantID = sc.nextInt();
			pythonInstant = sc.nextInt();
			javascriptInstant = sc.nextInt();
			rubyOnRailsInstant = sc.nextInt();
			PHPInstant = sc.nextInt();
			csharpInstant = sc.nextInt();
			cplusplusInstant= sc.nextInt();
			cInstant = sc.nextInt();
			qBug = sc.nextInt();
			qDev = sc.nextInt();
			sc.close();
		}
	}
}
