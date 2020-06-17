package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vues.PanelAvion;
import vues.PanelCentral;

public class MyKeyListener implements KeyListener {

	private PanelAvion avion;
	private PanelCentral viveLAdrogue;

	public MyKeyListener(PanelAvion pAvion, PanelCentral vCentral) {
		this.avion = pAvion;
		this.viveLAdrogue = vCentral;

	}

	private int deplacementVertical = 0;
	private int deplacementHorizontal = 0;

	@Override
	public void keyPressed(KeyEvent e) {
		if (deplacementHorizontal < 0) {

			deplacementHorizontal = deplacementHorizontal + 10;
		} else if (deplacementHorizontal > 610) {

			deplacementHorizontal = deplacementHorizontal - 10;

		}

		if (deplacementVertical < 0) {
			deplacementVertical = deplacementVertical + 10;

		} else if (deplacementVertical > 610) {// hauteur panel de 800 pixels - hauteur de l'image,
												// 800-80
			deplacementVertical = deplacementVertical - 10;
		}

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			deplacementVertical = deplacementVertical - 10;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);
			break;

		case KeyEvent.VK_DOWN:
			deplacementVertical = deplacementVertical + 10;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		case KeyEvent.VK_LEFT:
			deplacementHorizontal = deplacementHorizontal - 10;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		case KeyEvent.VK_RIGHT:
			deplacementHorizontal = deplacementHorizontal + 10;
			this.avion.setLocation(deplacementHorizontal, deplacementVertical);

			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
