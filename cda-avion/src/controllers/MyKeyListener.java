package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vues.MaFenetre;
import vues.PanelAvion;

public class MyKeyListener implements KeyListener {

	private PanelAvion avion;

	public MyKeyListener(PanelAvion pAvion) {
		this.avion = pAvion;

	}

	private int deplacementVertical = MaFenetre.HAUTEUR - PanelAvion.HAUTEUR - 100;
	private int deplacementHorizontal = (MaFenetre.LARGEUR / 2) - PanelAvion.LARGEUR;
	private static final int DEPLACEMENT_AVION = 10;

	@Override
	public void keyPressed(KeyEvent e) {
		if (deplacementHorizontal < 0) {

			deplacementHorizontal = deplacementHorizontal + DEPLACEMENT_AVION;
		} else if (deplacementHorizontal > MaFenetre.LARGEUR - PanelAvion.LARGEUR - DEPLACEMENT_AVION) {

			deplacementHorizontal = deplacementHorizontal - DEPLACEMENT_AVION;

		}

		if (deplacementVertical < 0) {
			deplacementVertical = deplacementVertical + DEPLACEMENT_AVION;

		} else if (deplacementVertical > MaFenetre.LARGEUR - PanelAvion.LARGEUR - DEPLACEMENT_AVION) {

			deplacementVertical = deplacementVertical - DEPLACEMENT_AVION;
		}

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			deplacementVertical = deplacementVertical - DEPLACEMENT_AVION;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);
			break;

		case KeyEvent.VK_DOWN:
			deplacementVertical = deplacementVertical + DEPLACEMENT_AVION;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		case KeyEvent.VK_LEFT:
			deplacementHorizontal = deplacementHorizontal - DEPLACEMENT_AVION;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		case KeyEvent.VK_RIGHT:
			deplacementHorizontal = deplacementHorizontal + DEPLACEMENT_AVION;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
