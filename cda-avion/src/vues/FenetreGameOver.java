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
		this.setSize(500, 300);
		this.setLocation(550, 100);

		JButton buttonReplay = new JButton("Go");
		JButton buttonAffichageDesScores = new JButton("Go");
		JButton buttonQuitter = new JButton("Go");

		buttonReplay.setName("Replay");
		buttonAffichageDesScores.setName("Score");
		buttonQuitter.setName("Quitter");

		buttonQuitter.addActionListener(listener);
		buttonReplay.addActionListener(listener);
		buttonAffichageDesScores.addActionListener(listener);

		JLabel label1 = new JLabel("Replay");
		JLabel label2 = new JLabel("Voir Score");
		JLabel label3 = new JLabel("Quitter");

		buttonReplay.setBounds(170, 15, 50, 30);
		buttonAffichageDesScores.setBounds(170, 115, 50, 30);
		buttonQuitter.setBounds(170, 215, 50, 30);

		label1.setBounds(120, 15, 100, 30);
		label2.setBounds(100, 115, 100, 30);
		label3.setBounds(120, 215, 100, 30);

		pn.add(buttonReplay);
		pn.add(buttonAffichageDesScores);
		pn.add(buttonQuitter);

		pn.add(label1);
		pn.add(label2);
		pn.add(label3);

		this.setVisible(true);

	}

}
