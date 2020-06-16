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

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() - 10);
			this.avion.repaint();

			break;

		case KeyEvent.VK_DOWN:
			this.avion.setDeplacementVertical(this.avion.getDeplacementVertical() + 10);
			this.avion.repaint();

			break;

		case KeyEvent.VK_LEFT:
			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() - 10);
			this.avion.repaint();

			break;

		case KeyEvent.VK_RIGHT:
			this.avion.setDeplacementHorizontal(this.avion.getDeplacementHorizontal() + 10);
			this.avion.repaint();

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
