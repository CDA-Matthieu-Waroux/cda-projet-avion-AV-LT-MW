package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controllers.MyTimer;
import models.Meteorite;
import tools.MeteoriteAleatoire;

public class PanelMeteorite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage imgMeteorite;
	private int positionHorizontale;
	private int positionVerticale;
	private Random rnd = new Random();
	private Meteorite meteorite = MeteoriteAleatoire.choixAleatoireMeteorite();

	public PanelMeteorite() {
		positionVerticale = -30;

		positionHorizontale = rnd.nextInt(720);

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/meteorite.png");

		try {
			imgMeteorite = ImageIO.read(img);
			// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(30, 30);
		this.setLocation(positionHorizontale, positionVerticale);
		this.setOpaque(false);
		new MyTimer(this, 50);

	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image
		super.paintComponent(g);
		g.drawImage(imgMeteorite, 0, 0, 30, 30, null);

	}

}
