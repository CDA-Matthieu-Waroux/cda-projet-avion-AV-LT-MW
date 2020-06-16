package controllers;

import java.util.Timer;
import java.util.TimerTask;

import vues.PanelMeteorite;

public class MyTimer extends Timer {

	public MyTimer(PanelMeteorite vpnlM, long vTime) {

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
