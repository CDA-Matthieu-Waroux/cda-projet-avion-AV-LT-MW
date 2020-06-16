package vues;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	public MaFenetre() {

		this.setSize(700, 800);// largeur, hauteur
		this.setLocation(300, 0);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EVITATOR D'ASTEROÏDES 3000");
		this.setLayout(null);// definition du layout pour la fenetre
		PanelCentral pnC = new PanelCentral();

		PanelMeteorite pnM1 = new PanelMeteorite();
		PanelMeteorite pnM2 = new PanelMeteorite();
		PanelMeteorite pnM3 = new PanelMeteorite();
		PanelAvion pnA = new PanelAvion(pnC);
		pnC.add(pnA);
		pnC.add(pnM1);
		pnC.add(pnM2);
		pnC.add(pnM3);

		this.add(pnC);

		// this.add(new PanelAvion());

		this.setVisible(true);// tj en dernier
	}

}