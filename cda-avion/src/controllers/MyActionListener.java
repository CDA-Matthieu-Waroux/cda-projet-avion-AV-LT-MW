package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.MaFenetre;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("La partie va commencer");
		new MaFenetre();

	}

}
