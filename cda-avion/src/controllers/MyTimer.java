package controllers;

import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import models.Avion;
import models.Meteorite;
import models.MeteoriteZigZag;
import tools.AffichageImage;
import tools.Game;
import tools.MeteoriteAleatoire;
import vues.MaFenetre;
import vues.PanelFooter;
import vues.PanelMeteorite;

public class MyTimer extends Timer {
	private static Meteorite meteorite;
	private Timer t = new Timer();
	private Random rnd = new Random();
	private InputStream img;
	private int y;
	private int x;
	public static final int SCORE_MAX = 999;

	public MyTimer(long vTime, Avion pMyAvion, PanelFooter vPanelFooter, PanelMeteorite... pPnM) {

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				if (pMyAvion.getPv() <= 0) {

					this.cancel();
				}
				for (PanelMeteorite panelMeteorite : pPnM) {

					meteorite = panelMeteorite.getMeteorite();

					if (panelMeteorite.getY() > (MaFenetre.HAUTEUR - meteorite.getHeightOJ() - 100)) {
						if (Game.MY_PLAYER.getScore() < SCORE_MAX) {
							Game.MY_PLAYER.setScore(Game.MY_PLAYER.getScore() + meteorite.getScore());

							vPanelFooter.getLabelScore().setText("Score :  " + Game.MY_PLAYER.getScore());
							if (Game.MY_PLAYER.getScore() > SCORE_MAX) {
								Game.MY_PLAYER.setScore(SCORE_MAX);
							}
						}

						MeteoriteAleatoire.AddMeteoriteList(meteorite);
						panelMeteorite.setMeteorite(MeteoriteAleatoire.choixAleatoireMeteorite());
						meteorite = panelMeteorite.getMeteorite();
						panelMeteorite.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
						panelMeteorite.setImgMeteorite(AffichageImage.afficherIMG(meteorite.getvLienPhoto()));

						panelMeteorite.repaint();
						panelMeteorite.setLocation(rnd.nextInt(621), -meteorite.getHeightOJ());
					}

					y = panelMeteorite.getY() + meteorite.getVitesse();
					if (meteorite instanceof MeteoriteZigZag) {
						x = zigZag((MeteoriteZigZag) meteorite, panelMeteorite);
						panelMeteorite.setLocation(x, y + 2);

					}
					panelMeteorite.setLocation(panelMeteorite.getX(), y);
				}
			}
		}, 0, vTime);

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
