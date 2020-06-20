package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tools.GameOver;
import tools.Game;
import tools.MeteoriteAleatoire;
import vues.MaFenetre;

public class ActionListenerFenetreGameOver implements ActionListener {

	private GameOver vFenetre;
	private FenetreGameOver vFenetre;
	private MaFenetre vFenetre2;
	private static String recup = "";
	private String name = "";

	public ActionListenerFenetreGameOver(GameOver pFenetre) {
	public ActionListenerFenetreGameOver(FenetreGameOver pFenetre, MaFenetre pFenetre2) {
		this.vFenetre = pFenetre;
		this.vFenetre2 = pFenetre2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		name = ((JButton) e.getSource()).getName();

		if (name.equalsIgnoreCase("Replay")) {

			vFenetre.setVisible(false);
			MeteoriteAleatoire.RafraichirListe();

		} else if (name.equalsIgnoreCase("Score")) {

			Game.listScore.forEach(x -> {
				recup += x + "\n";

			});

			JOptionPane.showMessageDialog(vFenetre, recup);
			recup = "";
		} else if (name.equalsIgnoreCase("Quitter")) {
			System.exit(0);

		} else if (name.equalsIgnoreCase("Crédits")) {

			recup = "************** DEVELOPPEURS **************** \n" + " Loreen TOURON \n" + " Matthieu WAROUX \n"
					+ " Aurélien VANNIER \n" + "************* MUSIQUE ************ \n"
					+ "Titre:  Cascade, Auteur: Kubbi, \n"
					+ "Licence: https://creativecommons.org/licenses/by-sa/3.0/deed.fr, \n"
					+ "Téléchargement (8MB): https://auboutdufil.com/?id=485";

			JOptionPane.showMessageDialog(vFenetre, recup);

		}
	}

}
