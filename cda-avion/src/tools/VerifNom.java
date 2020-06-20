package tools;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import vues.MaFenetre;

public class VerifNom {

	private static String nomJoueur;
	private static boolean continuer = true;

	public static void verificationNom(MaFenetre pMf) {

		nomJoueur = JOptionPane.showInputDialog("Saisissez votre nom .");

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
					MaFenetre.MY_PLAYER.setNom(nomJoueur);
					continuer = false;

				}

			} else {
				JOptionPane.showMessageDialog(pMf, " Le nom ne doit contenir que des lettres");
				verificationNom(pMf);
			}
		}
	}
}
