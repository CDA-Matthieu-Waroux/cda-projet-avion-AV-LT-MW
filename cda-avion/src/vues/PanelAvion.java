package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import models.Avion;
import tools.Game;

public class PanelAvion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage vaisseau;

	public static final byte HAUTEUR = 80;
	public static final byte LARGEUR = 80;

	private Avion avion = new Avion(80, 80, 10, "/ressources/VaisseauGayyyyy.png", 5);

	public PanelAvion(PanelCentral pCentral) {

		vaisseau = Game.IMAGE_VAISSEAU;
		this.setSize(LARGEUR, HAUTEUR);
		this.setLocation((MaFenetre.LARGEUR / 2) - LARGEUR, MaFenetre.HAUTEUR - HAUTEUR - 100);
		this.setIgnoreRepaint(true);
		this.setFocusable(true);// le focus sera fait sur ce panel !
		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		// this.addKeyListener(new MyKeyListener(this));
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@Override
	public void paintComponent(Graphics g) {// dessiner image

		super.paintComponent(g);

		g.drawImage(vaisseau, 0, 0, this.getWidth(), this.getHeight(), null);// taile de l'image, vaisseau

	}

	public BufferedImage getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(BufferedImage vaisseau) {
		this.vaisseau = vaisseau;
	}

}
