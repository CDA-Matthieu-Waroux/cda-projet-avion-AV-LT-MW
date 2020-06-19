package vues;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ActionListenerFenetreGameOver;

public class FenetreGameOver extends JFrame {

	private ActionListenerFenetreGameOver listener;
	private JButton buttonCredits = new JButton("Go");;
	private JButton buttonQuitter = new JButton("Go");;
	private JButton buttonAffichageDesScores = new JButton("Go");;
	private JButton buttonReplay = new JButton("Go");;
	private JLabel label1 = new JLabel("Replay");
	private JLabel label2 = new JLabel("Voir Score");
	private JLabel label3 = new JLabel("Quitter");
	private JLabel label4 = new JLabel("Crédits");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreGameOver(MaFenetre pFenetre) {

		listener = new ActionListenerFenetreGameOver(this, pFenetre);
		JPanel pn = new JPanel();

		pn.setSize(this.getWidth(), this.getHeight());
		pn.setLayout(null);
		this.add(pn);

		this.setTitle("Vous avez Perdu !");
		this.setResizable(false);
		this.setSize(400, 400);
		this.setLocation(550, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		buttonReplay.setName("Replay");
		buttonAffichageDesScores.setName("Score");
		buttonQuitter.setName("Quitter");
		buttonCredits.setName("Crédits");

		buttonQuitter.addActionListener(listener);
		buttonReplay.addActionListener(listener);
		buttonAffichageDesScores.addActionListener(listener);
		buttonCredits.addActionListener(listener);

		buttonReplay.setBounds(170, 15, 60, 30);
		buttonAffichageDesScores.setBounds(170, 115, 60, 30);
		buttonQuitter.setBounds(170, 215, 60, 30);
		buttonCredits.setBounds(170, 315, 60, 30);

		label1.setBounds(120, 15, 100, 30);
		label2.setBounds(100, 115, 100, 30);
		label3.setBounds(120, 215, 100, 30);
		label4.setBounds(120, 315, 100, 30);

		pn.add(buttonReplay);
		pn.add(buttonAffichageDesScores);
		pn.add(buttonQuitter);
		pn.add(buttonCredits);

		pn.add(label1);
		pn.add(label2);
		pn.add(label3);
		pn.add(label4);

		this.setVisible(true);

	}

}
