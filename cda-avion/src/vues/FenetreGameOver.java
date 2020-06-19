package vues;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ActionListenerFenetreGameOver;

public class FenetreGameOver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreGameOver() {

		ActionListenerFenetreGameOver listener = new ActionListenerFenetreGameOver(this);
		JPanel pn = new JPanel();

		pn.setSize(this.getWidth(), this.getHeight());
		pn.setLayout(null);
		this.add(pn);

		this.setTitle("Vous avez Perdu !");
		this.setResizable(false);
		this.setSize(400, 400);
		this.setLocation(550, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton buttonReplay = new JButton("Go");
		JButton buttonAffichageDesScores = new JButton("Go");
		JButton buttonQuitter = new JButton("Go");
		JButton buttonCredits = new JButton("Go");

		buttonReplay.setName("Replay");
		buttonAffichageDesScores.setName("Score");
		buttonQuitter.setName("Quitter");
		buttonCredits.setName("Crédits");

		buttonQuitter.addActionListener(listener);
		buttonReplay.addActionListener(listener);
		buttonAffichageDesScores.addActionListener(listener);
		buttonCredits.addActionListener(listener);

		JLabel label1 = new JLabel("Replay");
		JLabel label2 = new JLabel("Voir Score");
		JLabel label3 = new JLabel("Quitter");
		JLabel label4 = new JLabel("Crédits");

		buttonReplay.setBounds(170, 15, 60, 30);
		buttonAffichageDesScores.setBounds(170, 115, 60, 30);
		buttonQuitter.setBounds(170, 215, 60, 30);
		buttonQuitter.setBounds(170, 315, 60, 30);

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
