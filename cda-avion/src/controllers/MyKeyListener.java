package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vues.PanelAvion;

public class MyKeyListener implements KeyListener {

	private PanelAvion avion;

	public MyKeyListener(PanelAvion pAvion) {
		this.avion = pAvion;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (this.avion.getDeplacementHorizontal() < 0) {

			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() + 10);
		} else if (this.avion.getDeplacementHorizontal() > 610) {

			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() - 10);

		}

		if (this.avion.getDeplacementVertical() < 0) {
			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() + 10);

		} else if (this.avion.getDeplacementVertical() > 610) {// hauteur panel de 800 pixels - hauteur de l'image,
																// 800-80
			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() - 10);
		}

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:

			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() - 10);
			// this.avion.repaint();

			break;

		case KeyEvent.VK_DOWN:
			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() + 10);
			// this.avion.repaint();

			break;

		case KeyEvent.VK_LEFT:
			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() - 10);
			// this.avion.repaint();

			break;

		case KeyEvent.VK_RIGHT:
			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() + 10);
			// this.avion.repaint();

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
