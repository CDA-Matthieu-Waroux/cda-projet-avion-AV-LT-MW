package vues;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controllers.MyTimer;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int TAUX_RAFRAICHESSEMENT = 25;
	public static final int HAUTEUR = 800;
	public static final int POSITION_X = 400;
	public static final int POSITION_Y = 0;
	public static final int LARGEUR = 700;
	private final MonThread t1;
	private final MonThread t2;
	private final MonThread t3;
	private final MonThread t4;
	private final PanelFooter pf;

	public MaFenetre() {

		this.setSize(LARGEUR, HAUTEUR);// largeur, hauteur
		this.setLocation(POSITION_X, POSITION_Y);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EVITATOR D'ASTEROÏDES 3000");
		this.setLayout(null);// definition du layout pour la fenetre
		PanelCentral pnC = new PanelCentral();
		pf = new PanelFooter(FenetreNom.MY_PLAYER.getNom());

		try { // Tout dans le try permet de lire la musqiue du jeu en boucle.
			InputStream urlMusique = MonThread.class.getResourceAsStream("/ressources/5Keer.wav");
			InputStream bufferedIn = new BufferedInputStream(urlMusique);
			AudioInputStream monExplosion = AudioSystem.getAudioInputStream(bufferedIn);
			Clip clip = AudioSystem.getClip();
			clip.open(monExplosion);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			throw new RuntimeException(e);
		}

		PanelMeteorite pnM1 = new PanelMeteorite();
		PanelMeteorite pnM2 = new PanelMeteorite();
		PanelMeteorite pnM3 = new PanelMeteorite();
		PanelMeteorite pnM4 = new PanelMeteorite();

		PanelAvion pnA = new PanelAvion(pnC);
		pnC.add(pf);
		pnC.add(pnA);
		pnC.add(pnM1);
		pnC.add(pnM2);
		pnC.add(pnM3);
		pnC.add(pnM4);
		new MyTimer(TAUX_RAFRAICHESSEMENT, pnA.getAvion(), FenetreNom.MY_PLAYER, pf, pnM1, pnM2, pnM3, pnM4);
		this.add(pnC);

		this.setVisible(true);// tj en dernier mais avant le démarrage des threads!
		t1 = new MonThread(pnA, pnM1, this, pf);
		t2 = new MonThread(pnA, pnM2, this, pf);
		t3 = new MonThread(pnA, pnM3, this, pf);
		t4 = new MonThread(pnA, pnM4, this, pf);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void finDePartie() {

		t1.setContinuer(false);
		t2.setContinuer(false);
		t3.setContinuer(false);
		t4.setContinuer(false);

		File file = new File("scoring.txt");

		if (!file.exists()) {

			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.newLine();
			bw.write(this.pf.getLabelNom().getText() + " " + LocalDateTime.now() + " " + pf.getLabelScore().getText());

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.dispose();
		this.setVisible(false);
		new FenetreGameOver();
	}

}
