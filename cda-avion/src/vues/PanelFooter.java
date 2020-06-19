package vues;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFooter extends JPanel {

	private JPanel containerVie = new JPanel();
	private JPanel containerScore = new JPanel();
	private JPanel containerNom = new JPanel();
	private static final long serialVersionUID = 1L;
	private final static int HAUTEUR_FOOTER = 100;
	private final static int LARGEUR_FOOTER = 700;
	private JLabel labelScore = new JLabel("Score :  0");
	private JLabel labelNom = new JLabel("Nom :");
	private JLabel labelVie = new JLabel("Vie : 5");

	public PanelFooter(String nom) {
		this.labelNom.setText("Joueur : " + nom);
		this.setLayout(new GridLayout(1, 3));

		this.setBounds(0, 700, LARGEUR_FOOTER, HAUTEUR_FOOTER);// set size + set location

		this.add(containerScore);
		containerScore.setBackground(Color.GRAY);
		this.add(containerNom);
		containerNom.setBackground(Color.GRAY);
		this.add(containerVie);
		containerVie.setBackground(Color.GRAY);

		labelScore.setBounds(50, 0, 150, 50);
		labelScore.setForeground(Color.black);
		labelNom.setForeground(Color.black);
		labelVie.setForeground(Color.black);
		labelNom.setBounds(50, 0, 150, 50);
		labelVie.setBounds(50, 0, 150, 50);
		labelScore.setForeground(Color.WHITE);
		labelNom.setForeground(Color.WHITE);
		labelVie.setForeground(Color.WHITE);

		containerNom.add(labelNom);
		containerScore.add(labelScore);
		containerVie.add(labelVie);

	}

	public JLabel getLabelScore() {
		return labelScore;
	}

	public void setLabelScore(JLabel labelScore) {
		this.labelScore = labelScore;
	}

	public JLabel getLabelNom() {
		return labelNom;
	}

	public void setLabelNom(JLabel labelNom) {
		this.labelNom = labelNom;
	}

	public JLabel getLabelVie() {
		return labelVie;
	}

	public void setLabelVie(JLabel labelVie) {
		this.labelVie = labelVie;
	}

}
