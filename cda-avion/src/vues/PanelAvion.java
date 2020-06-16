package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelAvion extends JPanel {

	private BufferedImage vaisseau;

	public PanelAvion() {

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/VaisseauGayyyyy.png");

		try {
			vaisseau = ImageIO.read(img);// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(800, 800);
		this.setFocusable(true);// le focus sera fait sur ce panel !

		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		this.setBackground(Color.BLUE);
	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image

		super.paintComponent(g);
		g.drawImage(vaisseau, 360, 680, 80, 80, null);
	}

}
