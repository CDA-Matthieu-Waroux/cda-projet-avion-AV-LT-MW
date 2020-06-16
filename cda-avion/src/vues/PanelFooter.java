package vues;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelFooter extends JPanel {

	public PanelFooter() {

		this.setLayout(new GridLayout(3, 3));// 3lignes, 3colonnes
		JButton bouton1 = new JButton("Haut");
		JButton bouton2 = new JButton("Bas");
		JButton bouton3 = new JButton("Gauche");
		JButton bouton4 = new JButton("Droite");

		bouton1.setSize(50, 10);
		bouton2.setSize(50, 10);
		bouton3.setSize(50, 10);
		bouton4.setSize(50, 10);

		this.add(bouton1, 1, 2);
		this.add(bouton2, 3, 2);
		this.add(bouton3, 2, 1);
		this.add(bouton4, 2, 3);

		this.setVisible(true);

	}

}
