package controllers;

import java.awt.Rectangle;
import java.util.Random;

import models.Heineken;
import models.Meteorite;
import tools.AffichageImage;
import tools.Game;
import tools.MeteoriteAleatoire;
import vues.MaFenetre;
import vues.PanelAvion;
import vues.PanelFooter;
import vues.PanelMeteorite;

public class MonThread extends Thread {

	private boolean continuer = true;
	private PanelAvion vPnA;
	private PanelMeteorite vPnMe;
	private MaFenetre vMaFenetre;
	private PanelFooter vPf;
	private Rectangle rectAvion;
	private Rectangle rectMeteo;

	public MonThread(PanelAvion pnA, PanelMeteorite pnMe, MaFenetre pFenetre, PanelFooter pPf) {
		this.vPnA = pnA;
		this.vPnMe = pnMe;
		this.vMaFenetre = pFenetre;
		this.vPf = pPf;
	}

	@Override
	public void run() {
		while (continuer) {

			try {
				Thread.sleep(300); // Limite la consommation de mémoire de la boucle while
				calculerCollision(vPnA, vPnMe);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void calculerCollision(PanelAvion pAv, PanelMeteorite pMe) {

		rectAvion = pAv.getBounds();
		rectMeteo = pMe.getBounds();

		if (rectAvion.intersects(rectMeteo)) { // Collision avec cette météorite.

			if (!(pMe.getMeteorite() instanceof Heineken)) { // ajoute le son d'explosion
				Game.SON_EXPLOSION.play();
			}

			pAv.getAvion().setPv(pAv.getAvion().getPv() - pMe.getMeteorite().getDegat()); // Gère les dégats subits
			vPf.getLabelVie().setText("Vie : " + pAv.getAvion().getPv());
			if (pAv.getAvion().getPv() <= 0) { // Game Over permet la sortie du thread
				Game.end(vMaFenetre);
				this.interrupt();
				System.out.println(this.getState());

			} else {

				try { // Ajout d'une image d'explosion et empêche de subir les dégats de la même
						// météorite

					if (!(pMe.getMeteorite() instanceof Heineken)) {

						pAv.setVaisseau(Game.IMAGE_EXPLOSION);
						pAv.repaint();
						Thread.sleep(500);
						pAv.setVaisseau(Game.IMAGE_VAISSEAU);
						Thread.sleep(1000);
						pAv.repaint();
					}
					pMe.setMeteorite(MeteoriteAleatoire.choixAleatoireMeteorite());
					Meteorite meteorite = pMe.getMeteorite();
					pMe.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
					pMe.setImgMeteorite(AffichageImage.afficherIMG(meteorite.getvLienPhoto()));
					pMe.repaint();
					Random rnd = new Random();
					pMe.setLocation(rnd.nextInt(621), -meteorite.getHeightOJ());
				} catch (InterruptedException e) {
					System.out.println("Mode Fantôme");
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isContinuer() {
		return continuer;
	}

	public void setContinuer(boolean continuer) {
		this.continuer = continuer;
	}
}
