package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controllers.MyKeyListener;

public class PanelAvion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage vaisseau;

	public static final byte HAUTEUR = 80;
	public static final byte LARGEUR = 80;

	public PanelAvion(PanelCentral pCentral) {

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/VaisseauGayyyyy.png");

		try {
			vaisseau = ImageIO.read(img);// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(LARGEUR, HAUTEUR);
		this.setLocation((MaFenetre.LARGEUR / 2) - LARGEUR, MaFenetre.HAUTEUR - HAUTEUR - 100);
		this.setIgnoreRepaint(true);
		this.setFocusable(true);// le focus sera fait sur ce panel !
		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		this.addKeyListener(new MyKeyListener(this));
	}

	@Override
	public void paintComponent(Graphics g) {// dessiner image

		super.paintComponent(g);

		g.drawImage(vaisseau, 0, 0, this.getWidth(), this.getHeight(), null);// taile de l'image, vaisseau

	}

}
