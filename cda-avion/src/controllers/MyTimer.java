package controllers;

import java.util.Timer;
import java.util.TimerTask;

import models.MaFenetre;

public class MyTimer extends Timer {

	public MyTimer(MaFenetre vpnlM, long vTime) {

		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("coucou");

				vpnlM.repaint();

			}
		}, 0, vTime);
	}

}
