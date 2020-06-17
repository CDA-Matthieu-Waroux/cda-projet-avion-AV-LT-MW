package controllers;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import vues.PanelMeteorite;

public class MyTimer extends Timer {

	public MyTimer(PanelMeteorite vpnlM, long vTime) {

		Random rnd = new Random();
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				if (vpnlM.getY() > 720) {
					vpnlM.setLocation(rnd.nextInt(621), -30);
				}
				int y = vpnlM.getY() + 10;
				vpnlM.setLocation(vpnlM.getX(), y);
			}
		}, 0, vTime);
	}

}
