package vues;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import models.Meteorite;
import tools.MeteoriteAleatoire;

public class MonThread extends Thread {

	private boolean continuer = true;
	private PanelAvion vPnA;
	private PanelMeteorite vPnMe;
	private MaFenetre vMaFenetre;

	public MonThread(PanelAvion pnA, PanelMeteorite pnMe, MaFenetre pFenetre) {
		this.vPnA = pnA;
		this.vPnMe = pnMe;
		this.vMaFenetre = pFenetre;
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
		int xMet1 = pMe.getX(); // abcisse du pixel inital du panneau
		int xMet2 = pMe.getWidth() + pMe.getX(); // abcisse du pixel opposé du panneau

		int xAv1 = pAv.getX();
		int xAv2 = pAv.getX() + pAv.getWidth();

		int yMet1 = pMe.getY();
		int yMet2 = pMe.getY() + pMe.getHeight();

		int yAv1 = pAv.getY();
		int yAv2 = pAv.getY() + pAv.getHeight();

		double chevauchementX = Math.signum((xMet1 - xAv2) * (xMet2 - xAv1)); // signum retourne 1.0, 0.0 ou -1.0

		double chevauchementY = Math.signum((yMet1 - yAv2) * (yMet2 - yAv1));

		if (chevauchementX == chevauchementY && chevauchementX == -1.0) { // Collision avec cette météorite.
			try {

				InputStream urlExplosion = MonThread.class.getResourceAsStream("/ressources/sonExplosion.wav");
				InputStream bufferedIn = new BufferedInputStream(urlExplosion);
				AudioInputStream monExplosion = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(monExplosion);
				clip.start();

			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
				throw new RuntimeException(e);
			}

			pAv.getAvion().setPv(pAv.getAvion().getPv() - pMe.getMeteorite().getDegat()); // Gère les dégats subits
			System.out.println(pAv.getAvion().getPv());
			if (pAv.getAvion().getPv() <= 0) { // Game Over permet la sortie du thread
				this.continuer = false;
				vMaFenetre.finDePartie();

			} else {
				try { // Ajout d'une image d'explosion et empêche de subir les dégats de la même
						// météorite

					pMe.setMeteorite(MeteoriteAleatoire.choixAleatoireMeteorite());
					Meteorite meteorite = pMe.getMeteorite();
					pMe.setSize(meteorite.getWidthOJ(), meteorite.getHeightOJ());
					InputStream imphotoMeteor = PanelCentral.class.getResourceAsStream(meteorite.getvLienPhoto());

					try {
						pMe.setImgMeteorite(ImageIO.read(imphotoMeteor));
						// avec read, tj ioexception
					} catch (IOException e) {
						e.printStackTrace();
					}
					pMe.repaint();
					Random rnd = new Random();
					pMe.setLocation(rnd.nextInt(621), -meteorite.getHeightOJ());

					pAv.getAvion().setvLienPhoto("/ressources/explosion.png");

					InputStream img = PanelCentral.class.getResourceAsStream(pAv.getAvion().getvLienPhoto());

					try {
						pAv.setVaisseau(ImageIO.read(img));
						// avec read, tj ioexception
					} catch (IOException e) {
						e.printStackTrace();
					}
					pAv.repaint();
					Thread.sleep(500);
					pAv.getAvion().setvLienPhoto("/ressources/VaisseauGayyyyy.png");
					img = PanelCentral.class.getResourceAsStream(pAv.getAvion().getvLienPhoto());

					try {
						pAv.setVaisseau(ImageIO.read(img));
						Thread.sleep(1000);
						// avec read, tj ioexception
					} catch (IOException e) {
						e.printStackTrace();
					}

					pAv.repaint();
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
