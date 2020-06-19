package vues;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.MyActionListener;
import models.Player;

@SuppressWarnings("serial")

public class FenetreNom extends JFrame {// premiere fenetre qui s'ouvre au demarragé, le joueur renseigne son nom

	private JLabel label = new JLabel("Saisissez votre nom");
	private JFormattedTextField jtf1 = new JFormattedTextField();

	private final JButton boutonEnregistrement;

	private JPanel containerNom = new JPanel();
	private JPanel containerBouton = new JPanel();

	private String nomJoueur;

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public final static Player MY_PLAYER = new Player();

	private final static int HAUTEUR_FENETRE = 150;
	private final static int LARGEUR_FENETRE = 500;

	private final static int HAUTEUR_CONTAINER_NOM = 75;
	private final static int LARGEUR_CONTAINER_NOM = 500;

	private final static int HAUTEUR_CONTAINER_BOUTON = 75;
	private final static int LARGEUR_CONTAINER_BOUTON = 500;

	public FenetreNom() {

		this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);// largeur, hauteur
		this.setLocation(550, 100);// abscisse ordonnée, 0 : point en haut à gauche de la fenetre
		this.setResizable(false);// pour que la taille d'écran ne bouge pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Saisissez votre nom pour jouer  à EVITATOR D'ASTEROIDES 3000");
		this.setLayout(null);// definition du layout pour la fenetre

//		containerNom.setBackground(Color.GRAY);
		containerNom.setSize(LARGEUR_CONTAINER_NOM, HAUTEUR_CONTAINER_NOM);
		containerNom.setLayout(null);
		containerNom.setLocation(0, 0);

		Font police = new Font("Arial", Font.BOLD, 14);
		jtf1.setFont(police);
		jtf1.setBounds(200, 10, 200, 30);

		label.setBounds(50, 0, 150, 50);

		containerNom.add(label);
		containerNom.add(jtf1);

		this.add(containerNom);

		containerBouton.setSize(LARGEUR_CONTAINER_BOUTON, HAUTEUR_CONTAINER_BOUTON);
		containerBouton.setLayout(null);
		containerBouton.setLocation(0, 75);

		this.boutonEnregistrement = new JButton();
		MyActionListener mAction = new MyActionListener(this);

		jtf1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					afficherCaseNom();
				}

			}
		});
		this.boutonEnregistrement.setText("Get Start!");
		this.boutonEnregistrement.setBounds(200, HAUTEUR_CONTAINER_BOUTON, 100, 30);
		this.boutonEnregistrement.addActionListener(mAction);
		containerBouton.add(boutonEnregistrement);

//		this.add(containerBouton);
		getContentPane().add(this.boutonEnregistrement);

		this.setVisible(true);
	}

	public void afficherCaseNom() {

		nomJoueur = jtf1.getText();

		Pattern vPattern = Pattern.compile("^[a-zA-Z]+$");

		if (vPattern.matcher(nomJoueur).matches()) {
			if (nomJoueur.length() > 6) {
				JOptionPane.showMessageDialog(this, "Le nom doit contenir 6 caractères maximum");
				jtf1.setText("");

			} else if (nomJoueur.length() < 3) {

				JOptionPane.showMessageDialog(this, "Le nom doit contenir 3 caractères minimum");
				jtf1.setText("");

			} else {
				MY_PLAYER.setNom(nomJoueur);
				this.dispose();
				this.setVisible(false);
				new MaFenetre();
			}

		} else {
			JOptionPane.showMessageDialog(this, " Le nom ne doit contenir que des lettres");
			jtf1.setText("");
		}
	}

}
