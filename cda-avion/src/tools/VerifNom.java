package tools;

import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vues.MaFenetre;

public class VerifNom {
	private static String nomJoueur;
	private static boolean continuer = true;
	private static boolean saisie = true;

	public static void verificationNom(MaFenetre pMf) {
		pMf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (saisie) {
			nomJoueur = JOptionPane.showInputDialog("Saisissez votre nom");

			if ((nomJoueur != null) && (nomJoueur.length() > 0)) {

				saisie = true;

				Pattern vPattern = Pattern.compile("^[a-zA-Z]+$");

				while (continuer) {

					if (vPattern.matcher(nomJoueur).matches()) {
						if (nomJoueur.length() > 6) {
							JOptionPane.showMessageDialog(pMf, "Le nom doit contenir 6 caractères maximum");
							verificationNom(pMf);

						} else if (nomJoueur.length() < 3) {

							JOptionPane.showMessageDialog(pMf, "Le nom doit contenir 3 caractères minimum");
							verificationNom(pMf);
						} else {
							// Game.MY_PLAYER.setNom(nomJoueur);
							saisie = false;
							continuer = false;

						}

					} else {
						JOptionPane.showMessageDialog(pMf, " Le nom ne doit contenir que des lettres");
						verificationNom(pMf);
					}

				}
			} else {
				saisie = false;
				pMf.dispatchEvent(new WindowEvent(pMf, WindowEvent.WINDOW_CLOSING)); // Merci Isame finalement la
																						// méthode sert ici!
			}
		}
	}
}
