package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controllers.MyTimer;

public class PanelMeteorite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage meteorite;
	private int positionHorizontale;
	private int positionVerticale;
	private Random rnd = new Random();

	public PanelMeteorite() {
		positionVerticale = -30;

		positionHorizontale = rnd.nextInt(720);

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/meteorite.png");

		try {
			meteorite = ImageIO.read(img);
			// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(30, 30);
		this.setLocation(positionHorizontale, positionVerticale);
		this.setOpaque(false);
		new MyTimer(this, rnd.nextInt(51));

	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image
		super.paintComponent(g);
		g.drawImage(meteorite, 0, 0, 30, 30, null);

	}

}
