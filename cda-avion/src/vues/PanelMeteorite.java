package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.Meteorite;
import models.MeteoriteZigZag;
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
	private MeteoriteZigZag meteorite2;

	public MeteoriteZigZag getMeteorite2() {
		return meteorite2;
	}

	public PanelMeteorite() {
		this.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
		this.setOpaque(false);
		positionVerticale = -meteorite.getHeightOJ();
		positionHorizontale = rnd.nextInt(MaFenetre.LARGEUR - meteorite.getWidthOJ());

		InputStream img = PanelCentral.class.getResourceAsStream(meteorite.getvLienPhoto());

		try {
			imgMeteorite = ImageIO.read(img);
			// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setLocation(positionHorizontale, positionVerticale);

	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image
		super.paintComponent(g);
		g.drawImage(imgMeteorite, 0, 0, meteorite.getWidthOJ(), meteorite.getHeightOJ(), null);

	}

	public BufferedImage getImgMeteorite() {
		return imgMeteorite;
	}

	public void setImgMeteorite(BufferedImage imgMeteorite) {
		this.imgMeteorite = imgMeteorite;
	}

	public Meteorite getMeteorite() {
		return meteorite;
	}

	public void setMeteorite(Meteorite meteorite) {
		this.meteorite = meteorite;
	}
}
