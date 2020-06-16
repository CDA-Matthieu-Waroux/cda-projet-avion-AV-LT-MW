package models;

import javax.swing.JFrame;

import vues.PanelCentral;

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

		this.add(pnC);

		// ajout du panel central, placer le panneau central au
		// centre,

		// this.add(new PanelFooter(), BorderLayout.SOUTH);
		// this.add(new PanelAvion());

		this.setVisible(true);// tj en dernier
	}

}
