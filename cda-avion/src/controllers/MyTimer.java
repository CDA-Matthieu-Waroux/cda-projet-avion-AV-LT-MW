package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import models.Meteorite;
import models.MeteoriteZigZag;
import tools.MeteoriteAleatoire;
import tools.MyDeamon;
import vues.MaFenetre;
import vues.PanelCentral;
import vues.PanelMeteorite;

public class MyTimer extends Timer {
	private static Meteorite meteorite;
	private int choix = 10;
	private int borne = 0;

	public MyTimer(long vTime, PanelMeteorite... pPnM) {

		Random rnd = new Random();
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				MyDeamon dmd = new MyDeamon(pPnM);
				dmd.start();

				for (PanelMeteorite panelMeteorite : pPnM) {
					meteorite = panelMeteorite.getMeteorite();

					if (panelMeteorite.getY() > (MaFenetre.HAUTEUR - meteorite.getHeightOJ())) {
						panelMeteorite.setMeteorite(MeteoriteAleatoire.choixAleatoireMeteorite());
						meteorite = panelMeteorite.getMeteorite();
						panelMeteorite.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
						InputStream img = PanelCentral.class.getResourceAsStream(meteorite.getvLienPhoto());

						try {
							panelMeteorite.setImgMeteorite(ImageIO.read(img));

						} catch (IOException e) {
							e.printStackTrace();
						}
						panelMeteorite.repaint();
						panelMeteorite.setLocation(rnd.nextInt(621), -meteorite.getHeightOJ());
					}
					int y = panelMeteorite.getY() + meteorite.getVitesse();
					if (meteorite instanceof MeteoriteZigZag) {

						zigZag(panelMeteorite, y, meteorite);

					} else {
						panelMeteorite.setLocation(panelMeteorite.getX(), y);
					}

				}
			}
		}, 0, vTime);
	}

	private void zigZag(PanelMeteorite vPanelMeteorite, int vY, Meteorite meteo) {
		if (choix == -10) {
			borne--;
			vPanelMeteorite.setLocation(vPanelMeteorite.getX() + 1, vY);
			if (borne == choix) {
				choix = 10;
			}

		} else {
			vPanelMeteorite.setLocation(vPanelMeteorite.getX() - 1, vY);
			borne++;
			if (borne == choix) {
				choix = -10;
			}
		}

	}

}
