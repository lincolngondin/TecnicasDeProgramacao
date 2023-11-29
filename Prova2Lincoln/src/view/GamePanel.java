package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.PixelManager;
import model.ImageManager;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public GamePanel() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void drawInstant(PixelManager px) {
		Graphics g = this.getGraphics();
		int width = this.getWidth();
		int height = this.getHeight();
		g.drawImage(ImageManager.getInstance().getBackground(), 
				0, 
				0, 
				width,
				height,
				null
			);
		int imageWidth = width/px.getWidth();
		int imageHeight = height/px.getHeight();
		int index = 0;
		for(int y = 0; y < px.getHeight(); y++) {
			for(int x = 0; x < px.getWidth(); x++) {
				g.drawImage(
						ImageManager.getInstance().getImage(px.getCelestialBody(index)),
						x*imageWidth,
						y*imageHeight,
						imageWidth,
						imageHeight,
						null
				);
				index++;
			}
		}
	}
}
