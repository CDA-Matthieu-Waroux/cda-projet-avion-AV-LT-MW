package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import models.Avion;
import models.Meteorite;
import models.MeteoriteZigZag;
import models.Player;
import tools.MeteoriteAleatoire;
import vues.MaFenetre;
import vues.PanelCentral;
import vues.PanelFooter;
import vues.PanelMeteorite;

public class MyTimer extends Timer {
	private static Meteorite meteorite;

	public static final int SCORE_MAX = 999;

	public MyTimer(long vTime, Avion pMyAvion, Player pPlayer, PanelFooter vPanelFooter, PanelMeteorite... pPnM) {

		Random rnd = new Random();
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				if (pMyAvion.getPv() <= 0) {

					this.cancel();
				}
				for (PanelMeteorite panelMeteorite : pPnM) {
					meteorite = panelMeteorite.getMeteorite();

					if (panelMeteorite.getY() > (MaFenetre.HAUTEUR - meteorite.getHeightOJ())) {
						if (pPlayer.getScore() < SCORE_MAX) {
							pPlayer.setScore(pPlayer.getScore() + meteorite.getScore());

							vPanelFooter.getLabelScore().setText("Score : " + pPlayer.getScore());
							if (pPlayer.getScore() > SCORE_MAX) {
								pPlayer.setScore(SCORE_MAX);
							}
						}
						System.out.println(pPlayer.getScore());

						MeteoriteAleatoire.AddMeteoriteList(meteorite);
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
						int abcisse = zigZag((MeteoriteZigZag) meteorite, panelMeteorite);
						panelMeteorite.setLocation(abcisse, y + 2);

					}
					panelMeteorite.setLocation(panelMeteorite.getX(), y);
				}
			}
		}, 0, vTime);
//		t.cancel();

	}

	private int zigZag(MeteoriteZigZag pMeteore, PanelMeteorite pPMe) {
		int abcisse = 0;

		if (pMeteore.isLeft() == true) {
			abcisse = pPMe.getX() - pMeteore.getVitesse() - 10;
			pMeteore.setCompteur(pMeteore.getCompteur() + 1);
			if (pMeteore.getCompteur() == 10) {
				pMeteore.setLeft(false);
				pMeteore.setCompteur(0);
			}
		} else {
			abcisse = pPMe.getX() + pMeteore.getVitesse() + 10;
			pMeteore.setCompteur(pMeteore.getCompteur() + 1);
			if (pMeteore.getCompteur() == 10) {
				pMeteore.setLeft(true);
				pMeteore.setCompteur(0);
			}

		}

		return abcisse;
	}

}
