package vues;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelCentral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;

	public PanelCentral() {

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/background.png");// fond d'ecran

		try {
			background = ImageIO.read(img);

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		this.setSize(MaFenetre.LARGEUR, MaFenetre.HAUTEUR);

	}

	@Override
	public void paintComponent(Graphics g) {// dessiner image

		// super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	}

}
