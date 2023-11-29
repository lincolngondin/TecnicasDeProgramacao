package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageManager {
	private static ImageManager instance;
	private BufferedImage javaImage;
	private BufferedImage pythonImage;
	private BufferedImage javascriptImage;
	private BufferedImage rubyonrailsImage;
	private BufferedImage phpImage;
	private BufferedImage cplusplusImage;
	private BufferedImage csharpImage;
	private BufferedImage cImage;
	private BufferedImage devImage;
	private BufferedImage bugImage;
	private BufferedImage nothing;
	private BufferedImage background;
	private ImageManager() {
		try {
			this.javaImage = ImageIO.read(new File("resources/java.png"));
			this.pythonImage = ImageIO.read(new File("resources/python.png"));
			this.javascriptImage = ImageIO.read(new File("resources/javascript.png"));
			this.rubyonrailsImage = ImageIO.read(new File("resources/rubyonrails.png"));
			this.phpImage = ImageIO.read(new File("resources/php.png"));
			this.cplusplusImage = ImageIO.read(new File("resources/cpp.png"));
			this.csharpImage = ImageIO.read(new File("resources/csharp.png"));
			this.cImage = ImageIO.read(new File("resources/c.png"));
			this.devImage = ImageIO.read(new File("resources/dev.png"));
			this.bugImage = ImageIO.read(new File("resources/bug.png"));
			this.nothing = ImageIO.read(new File("resources/nothing.png"));
			this.background = ImageIO.read(new File("resources/background.jpg"));
		}
		catch(IOException err) {
			err.printStackTrace();
		}
	}
	public BufferedImage getBackground() {
		return this.background;
	}
	public BufferedImage getImage(CelestialBodies cb) {
		switch(cb) {
			case JAVA:
				return this.javaImage;
			case PYTHON:
				return this.pythonImage;
			case JAVASCRIPT:
				return this.javascriptImage;
			case RUBY_ON_RAILS:
				return this.rubyonrailsImage;
			case PHP:
				return this.phpImage;
			case CSHARP:
				return this.csharpImage;
			case CPLUS_PLUS:
				return this.cplusplusImage;
			case C:
				return this.cImage;
			case DEV:
				return this.devImage;
			case BUG:
				return this.bugImage;
			case NOTHING:
				return this.nothing;
			default:
				return null;
		}
	}
	public static ImageManager getInstance() {
		if(instance == null) {
			instance = new ImageManager();
		}
		return instance;
	}
}
