package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.MyActionListener;

public class FenetreNom extends JFrame {// premiere fenetre qui s'ouvre au demarragé, le joueur renseigne son nom

	private JLabel label = new JLabel("Saisissez votre nom");
	private JFormattedTextField jtf1 = new JFormattedTextField();
	private final JButton boutonEnregistrement;
	private JPanel containerNom = new JPanel();
	private JPanel containerBouton = new JPanel();
	private JPanel top = new JPanel();

	private final static int HAUTEUR_FENETRE = 150;
	private final static int LARGEUR_FENETRE = 500;

	private final static int HAUTEUR_CONTAINER_NOM = 75;
	private final static int LARGEUR_CONTAINER_NOM = 500;

	private final static int HAUTEUR_CONTAINER_BOUTON = 75;
	private final static int LARGEUR_CONTAINER_BOUTON = 500;

	public FenetreNom() {

		this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);// largeur, hauteur
		this.setLocation(600, 0);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Saisissez votre nom pour jouer à EVITATOR D'ASTEROÏDES 3000");
		this.setLayout(new BorderLayout());// definition du layout pour la fenetre

		containerNom.setBackground(Color.GRAY);
		containerBouton.setBackground(Color.DARK_GRAY);

		containerNom.setSize(LARGEUR_CONTAINER_NOM, HAUTEUR_CONTAINER_NOM);
		containerBouton.setSize(LARGEUR_CONTAINER_BOUTON, HAUTEUR_CONTAINER_BOUTON);

		containerNom.setLayout(new BorderLayout());
		containerBouton.setLayout(null);

		Font police = new Font("Arial", Font.BOLD, 14);
		jtf1.setFont(police);
		jtf1.setPreferredSize(new Dimension(150, 30));
		jtf1.setForeground(Color.BLACK);

		containerNom.add(label);
		containerNom.add(jtf1);

		containerNom.add(top);
		this.add(containerNom, BorderLayout.NORTH);

		this.boutonEnregistrement = new JButton();
		this.boutonEnregistrement.setText("Cliquez ici pour commencer la partie");
		this.boutonEnregistrement.setBounds(50, 50, 300, 50);
		this.boutonEnregistrement.addActionListener(new MyActionListener());
		containerBouton.add(boutonEnregistrement, BorderLayout.CENTER);

		this.add(containerBouton, BorderLayout.SOUTH);

		getContentPane().add(this.boutonEnregistrement);

		this.setVisible(true);
	}

//		// public void afficherCaseNom() {
//
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Saisissez votre nom : ");
//		String nomJoueur = sc.nextLine();
//
//		Pattern vPattern = Pattern.compile("[1-9]");
//
//		if (vPattern.matcher(nomJoueur).find()) {
//			System.out.println(nomJoueur + " Nom correct ");
//		} else {
//			System.out.println(nomJoueur + "Le nom ne doit contenir que des lettres");
//		}
//
//		if (nomJoueur.length() > 6)
//
//		{
//			System.out.println("Le nom doit contenir 6 caractères maximum");
//		} else if (nomJoueur.length() < 2) {
//			System.out.println("Le nom doit contenir au moins 2 caractères");
//		} else {
//			System.out.println("Votre nom est bien enregistré");
//		}
//	}
}
