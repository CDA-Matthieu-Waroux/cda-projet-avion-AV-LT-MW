package vues;

import javax.swing.JFrame;

import tools.Game;
import tools.VerifNom;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int TAUX_RAFRAICHESSEMENT = 25;
	public static final int HAUTEUR = 800;
	public static final int POSITION_X = 400;
	public static final int POSITION_Y = 0;
	public static final int LARGEUR = 700;

	private PanelFooter pf;
	private PanelMeteorite pnM1;
	private PanelMeteorite pnM2;
	private PanelMeteorite pnM3;
	private PanelMeteorite pnM4;
	private PanelCentral pnC;
	private PanelAvion pnA;

	public MaFenetre() {

		VerifNom.verificationNom(this);

		Game.MY_PLAYER.setScore(0);
		this.setSize(LARGEUR, HAUTEUR);// largeur, hauteur
		this.setLocation(POSITION_X, POSITION_Y);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EVITATOR D'ASTEROÏDES 3000");
		this.setLayout(null);// definition du layout pour la fenetre
		pnC = new PanelCentral();
		pf = new PanelFooter(Game.MY_PLAYER.getNom());

		pnM1 = new PanelMeteorite();
		pnM2 = new PanelMeteorite();
		pnM3 = new PanelMeteorite();
		pnM4 = new PanelMeteorite();

		pnA = new PanelAvion(pnC);
		pnC.add(pf);
		pnC.add(pnA);
		pnC.add(pnM1);
		pnC.add(pnM2);
		pnC.add(pnM3);
		pnC.add(pnM4);

		this.add(pnC);

		this.setVisible(true);// tj en dernier mais avant le démarrage des threads!

		Game.start(this);

	}

	public PanelFooter getPf() {
		return pf;
	}

	public PanelMeteorite getPnM1() {
		return pnM1;
	}

	public PanelMeteorite getPnM2() {
		return pnM2;
	}

	public PanelMeteorite getPnM3() {
		return pnM3;
	}

	public PanelMeteorite getPnM4() {
		return pnM4;
	}

	public PanelCentral getPnC() {
		return pnC;
	}

	public PanelAvion getPnA() {
		return pnA;
	}

}
