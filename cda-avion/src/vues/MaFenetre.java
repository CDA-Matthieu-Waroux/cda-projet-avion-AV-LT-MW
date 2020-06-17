package vues;

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
	private MyTimer myTimer;

	public MaFenetre() {

		this.setSize(LARGEUR, HAUTEUR);// largeur, hauteur
		this.setLocation(POSITION_X, POSITION_Y);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EVITATOR D'ASTEROÏDES 3000");
		this.setLayout(null);// definition du layout pour la fenetre
		PanelCentral pnC = new PanelCentral();

		PanelMeteorite pnM1 = new PanelMeteorite();
		PanelMeteorite pnM2 = new PanelMeteorite();
		PanelMeteorite pnM3 = new PanelMeteorite();
		PanelMeteorite pnM4 = new PanelMeteorite();

		PanelAvion pnA = new PanelAvion(pnC);

		pnC.add(pnA);
		pnC.add(pnM1);
		pnC.add(pnM2);
		pnC.add(pnM3);
		pnC.add(pnM4);

		myTimer = new MyTimer(TAUX_RAFRAICHESSEMENT, pnM1, pnM2, pnM3, pnM4);
		this.add(pnC);

		this.setVisible(true);// tj en dernier
		t1 = new MonThread(pnA, pnM1, this);
		t2 = new MonThread(pnA, pnM2, this);
		t3 = new MonThread(pnA, pnM3, this);
		t4 = new MonThread(pnA, pnM4, this);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// ça dépendra de l'avis d el'afpa
		// mais ça va repartir au niveau du COVID
		// Tout le monde s'en bat les couilles mtn des yep
		// this.add(new PanelAvion());

	}

	public void finDePartie() {
		t1.setContinuer(false);
		t2.setContinuer(false);
		t3.setContinuer(false);
		t4.setContinuer(false);
		if (myTimer != null) {
			myTimer.cancel();
		}

		myTimer = null;

	}

}
