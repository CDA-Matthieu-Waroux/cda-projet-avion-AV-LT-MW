package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.FenetreNom;
import vues.MaFenetre;

public class MyActionListener implements ActionListener {

	private FenetreNom fNom;

	public MyActionListener(FenetreNom pFnom) {
		this.fNom = pFnom;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("La partie va commencer");
		new MaFenetre();
	}

}
