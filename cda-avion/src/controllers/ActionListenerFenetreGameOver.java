package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import vues.FenetreGameOver;
import vues.MaFenetre;

public class ActionListenerFenetreGameOver implements ActionListener {

	private FenetreGameOver vFenetre;
	private static String recup = "";

	public ActionListenerFenetreGameOver(FenetreGameOver pFenetre) {
		this.vFenetre = pFenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("click");
		String name = ((JButton) e.getSource()).getName();

		if (name.equalsIgnoreCase("Replay")) {
			vFenetre.dispose();
			new MaFenetre();

		} else if (name.equalsIgnoreCase("Score")) {

			MaFenetre.getListScore().forEach(x -> {
				recup += x + "\n";

			});

			JOptionPane.showMessageDialog(vFenetre, recup);
			recup = "";
		} else if (name.equalsIgnoreCase("Quitter")) {
			System.exit(0);

		}
	}

}
