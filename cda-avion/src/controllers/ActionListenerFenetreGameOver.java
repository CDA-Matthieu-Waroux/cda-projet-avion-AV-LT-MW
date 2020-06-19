package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tools.MeteoriteAleatoire;
import vues.FenetreGameOver;
import vues.MaFenetre;

public class ActionListenerFenetreGameOver implements ActionListener {

	private FenetreGameOver vFenetre;

	public ActionListenerFenetreGameOver(FenetreGameOver pFenetre) {
		this.vFenetre = pFenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("click");
		String name = ((JButton) e.getSource()).getName();

		if (name.equalsIgnoreCase("Replay")) {
			vFenetre.dispose();
			MeteoriteAleatoire.RafraichirListe();
			new MaFenetre();

		} else if (name.equalsIgnoreCase("Score")) {

			File file = new File("scoring.txt");
			String text = "";
			String recup = "";
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				while ((text = br.readLine()) != null) {
					recup += text + "\n";
				}
			} catch (IOException ec) {
				ec.printStackTrace();
			}

			JOptionPane.showMessageDialog(vFenetre, recup);

		} else if (name.equalsIgnoreCase("Quitter")) {
			System.exit(0);

		} else if (name.equalsIgnoreCase("Crédits")) {

			File file = new File("credit.txt");
			String text = "";
			String recup = "";
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				while ((text = br.readLine()) != null) {
					recup += text + "\n";
				}
			} catch (IOException ec) {
				ec.printStackTrace();
			}

			JOptionPane.showMessageDialog(vFenetre, recup);

		}
	}

}
