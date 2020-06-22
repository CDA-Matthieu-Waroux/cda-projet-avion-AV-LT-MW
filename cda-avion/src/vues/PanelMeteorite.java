package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import models.Meteorite;
import tools.AffichageImage;
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
		this.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
		this.setOpaque(false);
		positionVerticale = -meteorite.getHeightOJ();
		positionHorizontale = rnd.nextInt(MaFenetre.LARGEUR - meteorite.getWidthOJ());
		imgMeteorite = AffichageImage.afficherIMG(meteorite.getvLienPhoto());
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
