package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelMeteorite extends JPanel {

	private BufferedImage meteorite;
	private int positionHorizontale;
	private int positionVerticale;
	private Random rnd = new Random();
	private int choix = 1;

	public PanelMeteorite() {
		positionVerticale = -50;
		int rand = rnd.nextInt(721);
		positionHorizontale = rand;

		InputStream img = PanelCentral.class.getResourceAsStream("/ressources/meteorite.png");

		try {
			meteorite = ImageIO.read(img);
			// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(800, 800);
		// this.setFocusable(false);// le focus sera fait sur ce panel !

		this.setOpaque(false);// definir opacity du panel à 0, pour voir le fond
		// d'écran
		this.setBackground(Color.BLUE);
	}

	@Override
	protected void paintComponent(Graphics g) {// dessiner image
		// super.paintComponent(g);
		positionVerticale = positionVerticale + 1;
		if (positionVerticale > 600) {
			positionVerticale = 0;
			positionHorizontale = rnd.nextInt(721);
		}

		if (choix == 1) {
			g.drawImage(meteorite, positionHorizontale + 30, positionVerticale, 30, 30, null);
			choix = 2;
		} else {
			g.drawImage(meteorite, positionHorizontale - 30, positionVerticale, 30, 30, null);
			choix = 1;
		}

	}

}
