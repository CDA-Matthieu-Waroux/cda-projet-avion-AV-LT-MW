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

	public PanelAvion(PanelCentral pCentral) {

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/VaisseauGayyyyy.png");

		try {
			vaisseau = ImageIO.read(img);// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(80, 80);
		this.setLocation(320, 620);
		this.setIgnoreRepaint(true);
		this.setFocusable(true);// le focus sera fait sur ce panel !
		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		this.addKeyListener(new MyKeyListener(this, pCentral));
	}

	@Override
	public void paintComponent(Graphics g) {// dessiner image

		super.paintComponent(g);

		g.drawImage(vaisseau, 0, 0, 80, 80, null);// taile de l'image, vaisseau

	}

}
