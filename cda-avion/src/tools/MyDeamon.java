package tools;

import models.MeteoriteZigZag;
import vues.PanelMeteorite;

public class MyDeamon extends Thread {

	private PanelMeteorite[] tab;
	private int compteur;

	public MyDeamon(PanelMeteorite[] tab) {
		this.tab = tab;
		this.setDaemon(true);
	}

	@Override
	public void run() {
		compteur = 0;
		for (PanelMeteorite panelMeteorite : tab) {
			if (panelMeteorite.getMeteorite() instanceof MeteoriteZigZag) {
				compteur++;
			}

		}
	}

	public int getCompteur() {
		return compteur;
	}

}
