package vues;

import models.Avion;
import models.ObjetVolant;

public class MonThread extends Thread {

	private boolean continuer = true;
	private PanelAvion pnA;
	private PanelMeteorite pnM1;
	private PanelMeteorite pnM2;
	private PanelMeteorite pnM3;

	public MonThread(PanelAvion pnA, PanelMeteorite pnM1, PanelMeteorite pnM2, PanelMeteorite pnM3) {

		this.pnA = pnA;
		this.pnM1 = pnM1;
		this.pnM2 = pnM2;
		this.pnM3 = pnM3;

	}

	public MonThread(PanelAvion pnA, PanelMeteorite pnM1) {
		this.pnA = pnA;
		this.pnM1 = pnM1;
	}

	@Override
	public void run() {
		ObjetVolant avion = new Avion(80, 80, 10, "/ressources/VaisseauGayyyyy.png", 5);
		while (continuer) {
			calculerColision(pnA, pnM1);
			calculerColision(pnA, pnM2);
			calculerColision(pnA, pnM3);
			// calculerColision(pnA,pnM1);

		}
		super.run();
	}

	public void calculerColision(PanelAvion pAv, PanelMeteorite pMe) {
		int xMet1 = pMe.getX(); // abcisse du pixel inital du panneau
		int xMet2 = pMe.getWidth() + pMe.getX(); // abcisse du pixel opposé du panneau

		int xAv1 = pAv.getX();
		int xAv2 = pAv.getX() + pAv.getWidth();

		int yMet1 = pMe.getY();
		int yMet2 = pMe.getY() + pMe.getHeight();

		int yAv1 = pAv.getY();
		int yAv2 = pAv.getY() + pAv.getHeight();

		double chevauchementX = Math.signum((xMet1 - xAv2) * (xMet2 - xAv1));

		double chevauchementY = Math.signum((yMet1 - yAv2) * (yMet2 - yAv1));

		if (chevauchementX == chevauchementY && chevauchementX == -1.0) {
			System.out.println("BOOOOM!!!!!!");

			try {
				this.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("Mode Fantôme");
				e.printStackTrace();
			}

		} else {
			System.out.println();
		}
	}
}
