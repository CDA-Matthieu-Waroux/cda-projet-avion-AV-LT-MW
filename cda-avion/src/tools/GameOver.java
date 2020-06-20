
package tools;

import javax.swing.JOptionPane;

import vues.MaFenetre;

//import controllers.ActionListenerFenetreGameOver;

public class GameOver extends JOptionPane {

	private static final long serialVersionUID = 1L;
	private static String recup = " ";
	private static boolean saisie = true; // pour le while

	public static String getRecup() {
		return recup;
	}

	public static void setRecup(String recup) {
		GameOver.recup = recup;
	}

	public static boolean isSaisie() {
		return saisie;
	}

	public static void setSaisie(boolean saisie) {
		GameOver.saisie = saisie;
	}

	public static void afficherGameOver(MaFenetre pFenetre) {

//		pFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pFenetre.dispatchEvent(new WindowEvent(pFenetre, WindowEvent.WINDOW_CLOSING));
//	
//
//		Object[] choix = { "Replay", "HighScores", "Exit", "Crédits" };
//		
//		int choixClic = JOptionPane.showOptionDialog(null, "Que souhaitez vous faire?", "Game-Over",
//				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
//		
//		System.out.println(choix);
//
//	
//		switch (choix) { 
//		
//		saisie = ((JButton) e.getSource()).getSaisie();
//		
//		case Replay:
//			
//			if (name.equalsIgnoreCase("Replay")) {
//
//				MeteoriteAleatoire.RafraichirListe();
//				new MaFenetre(); 
//				JOptionPane.showMessageDialog(vFenetre, recup);
//				recup = "";}
//
//			break;
//
//			
//		case HighScores:
//			
//			if (name.equalsIgnoreCase("Score")) {
//
//				MaFenetre.getListScore().forEach(x -> {
//					recup += x + "\n";
//				});
//				JOptionPane.showMessageDialog(vFenetre, recup);
//				recup = "";}
//
//			break;
//			
//
//		case Exit:
//			
//			if (name.equalsIgnoreCase("Quitter")) {
//				System.exit(0);
//				JOptionPane.showMessageDialog(vFenetre, recup);
//				recup = "";}
//		
//			break;
//
//			
//		case Crédits:
//			
//			if (name.equalsIgnoreCase("Crédits")) {
//
//				recup = "************** DEVELOPPEURS **************** \n" + " Loreen TOURON \n" + " Matthieu WAROUX \n"
//						+ " Aurélien VANNIER \n" + "************* MUSIQUE ************ \n"
//						+ "Titre:  Cascade, Auteur: Kubbi, \n"
//						+ "Licence: https://creativecommons.org/licenses/by-sa/3.0/deed.fr, \n"
//						+ "Téléchargement (8MB): https://auboutdufil.com/?id=485";
//
//				JOptionPane.showMessageDialog(vFenetre, recup);
//				recup = "";}
//
//			break;
//			
//
//		default:
//			if (name.equalsIgnoreCase("Quitter")) {
//				System.exit(0);
//			
//			break;
//		}
//
//	}
//			
//
//	while(recup.equals("HighScores")||recup.equals("Crédits"))
//
//	{
//		// on garde la popup ouverte
//		afficherGameOver(null);
//
//	}

	}
}