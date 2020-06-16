package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controllers.MyKeyListener;

public class PanelAvion extends JPanel {

	private BufferedImage vaisseau;

	private int deplacementVertical = 620;
	private int deplacementHorizontal = 310;

	public PanelAvion() {

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/VaisseauGayyyyy.png");

		try {
			vaisseau = ImageIO.read(img);// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(700, 800);
		this.setFocusable(true);// le focus sera fait sur ce panel !

		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		this.setBackground(Color.BLUE);
		this.addKeyListener(new MyKeyListener(this));
	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image

		super.paintComponent(g);

		if (deplacementHorizontal < 0) {

			deplacementHorizontal = deplacementHorizontal + 10;
		} else if (deplacementHorizontal > 610) {

			deplacementHorizontal = deplacementHorizontal - 10;

		}

		if (deplacementVertical < 0) {
			deplacementVertical = deplacementVertical + 10;

		} else if (deplacementVertical > 610) {// hauteur panel de 800 pixels - hauteur de l'image, 800-80

		} else if (deplacementVertical > 620) {// hauteur panel de 800 pixels - hauteur de l'image, 800-80

			deplacementVertical = deplacementVertical - 10;
		}

		g.drawImage(vaisseau, deplacementHorizontal, deplacementVertical, 80, 80, null);// taile de l'image, vaisseau

	}

	public BufferedImage getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(BufferedImage vaisseau) {
		this.vaisseau = vaisseau;
	}

	public int getDeplacementVertical() {
		return deplacementVertical;
	}

	public void setDeplacementVertical(int deplacementVertical) {
		this.deplacementVertical = deplacementVertical;
	}

	public int getDeplacementHorizontal() {
		return deplacementHorizontal;
	}

	public void setDeplacementHorizontal(int deplacementHorizontal) {
		this.deplacementHorizontal = deplacementHorizontal;
	}
}
