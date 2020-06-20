
package tools;

import javax.swing.JOptionPane;

import vues.MaFenetre;

//import controllers.ActionListenerFenetreGameOver;

public class GameOver extends JOptionPane {

//	private ActionListenerFenetreGameOver listener;
//	private JButton buttonCredits = new JButton("Go");;
//	private JButton buttonQuitter = new JButton("Go");;
//	private JButton buttonAffichageDesScores = new JButton("Go");;
//	private JButton buttonReplay = new JButton("Go");;
//	private JLabel label1 = new JLabel("Replay");
//	private JLabel label2 = new JLabel("Voir Score");
//	private JLabel label3 = new JLabel("Quitter");
//	private JLabel label4 = new JLabel("Crédits");
	private static final long serialVersionUID = 1L;
	private static MaFenetre vMf;

	public GameOver() {

	}

	public GameOver(MaFenetre pMf) {
		this.vMf = pMf;

	}
//		listener = new ActionListenerFenetreGameOver(this);
//
//		buttonReplay.setName("Replay");
//		buttonAffichageDesScores.setName("Score");
//		buttonQuitter.setName("Quitter");
//		buttonCredits.setName("Crédits");
//
//		buttonQuitter.addActionListener(listener);
//		buttonReplay.addActionListener(listener);
//		buttonAffichageDesScores.addActionListener(listener);
//		buttonCredits.addActionListener(listener);
//
//		buttonReplay.setBounds(170, 15, 60, 30);
//		buttonAffichageDesScores.setBounds(170, 115, 60, 30);
//		buttonQuitter.setBounds(170, 215, 60, 30);
//		buttonCredits.setBounds(170, 315, 60, 30);
//
//		label1.setBounds(120, 15, 100, 30);
//		label2.setBounds(100, 115, 100, 30);
//		label3.setBounds(120, 215, 100, 30);
//		label4.setBounds(120, 315, 100, 30);
//
//		pn.add(buttonReplay);
//		pn.add(buttonAffichageDesScores);
//		pn.add(buttonQuitter);
//		pn.add(buttonCredits);
//
//		pn.add(label1);
//		pn.add(label2);
//		pn.add(label3);
//		pn.add(label4);

	public void afficherGameOver() {

		Object[] choix = { "Replay", "HighScores", "Exit", "Crédits" };
		int choixClic = JOptionPane.showOptionDialog(null, "Que souhaitez vous faire?", "Game-Over",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
		System.out.println(choixClic);

		switch (choixClic) {
		case 0:

			break;

		case 1:

			break;

		case 2:

			break;

		case 3:

			break;

		default:
			break;
		}

	}

	public static void afficherGameOver(MaFenetre maFenetre) {

	}

}
