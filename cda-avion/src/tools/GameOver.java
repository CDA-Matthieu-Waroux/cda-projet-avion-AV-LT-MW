
package tools;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import vues.MaFenetre;

public class GameOver extends JOptionPane {

	private static final long serialVersionUID = 1L;
	private static String recup = "";
	public static boolean clic = true;// ajouté par loreen pour le while

	public static void afficherGameOver(MaFenetre pFenetre) {

		while (clic) {

			Object[] choix = { "Replay", "HighScores", "Exit", "Crédits" };
			int choixClic = JOptionPane.showOptionDialog(null, "Que souhaitez vous faire?", "Game-Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);

			System.out.println(choixClic);

			switch (choixClic) {
			case 0:
				clic = false;
				MeteoriteAleatoire.RafraichirListe();
				Game.replay(pFenetre);
				break;
			case 1:
				Game.listScore.forEach(x -> {
					recup += x + "\n";
				});
				JOptionPane.showMessageDialog(pFenetre, recup);
				recup = "";
				break;
			case 2:
				clic = false;
				pFenetre.dispatchEvent(new WindowEvent(pFenetre, WindowEvent.WINDOW_CLOSING));
				break;
			case 3:
				recup = "************** DEVELOPPEURS **************** \n" + " Loreen TOURON \n" + " Matthieu WAROUX \n"
						+ " Aurélien VANNIER \n" + "************* MUSIQUE ************ \n"
						+ "Titre:  Cascade, Auteur: Kubbi, \n"
						+ "Licence: https://creativecommons.org/licenses/by-sa/3.0/deed.fr, \n"
						+ "Téléchargement (8MB): https://auboutdufil.com/?id=485";
				JOptionPane.showMessageDialog(pFenetre, recup);
				break;
			default:
				break;
			}

		}
	}
}
