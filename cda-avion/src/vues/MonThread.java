package vues;

public class MonThread extends Thread {

	private boolean continuer = true;
	private PanelAvion vPnA;
	private PanelMeteorite vPnMe;
	private MaFenetre vMaFenetre;

	public MonThread(PanelAvion pnA, PanelMeteorite pnMe, MaFenetre pFenetre) {
		this.vPnA = pnA;
		this.vPnMe = pnMe;
		this.vMaFenetre = pFenetre;
	}

	@Override
	public void run() {
		while (continuer) {

			try {
				this.sleep(300);
				calculerColision(vPnA, vPnMe);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void calculerColision(PanelAvion pAv, PanelMeteorite pMe) {
		int xMet1 = pMe.getX(); // abcisse du pixel inital du panneau
		int xMet2 = pMe.getWidth() + pMe.getX(); // abcisse du pixel opposé du panneau

		int xAv1 = pAv.getX();
		int xAv2 = pAv.getX() + pAv.getWidth();

		int yMet1 = pMe.getY();
		int yMet2 = pMe.getY() + pMe.getHeight();

		int yAv1 = pAv.getY();
		int yAv2 = pAv.getY() + pAv.getHeight();

		double chevauchementX = Math.signum((xMet1 - xAv2) * (xMet2 - xAv1));

		double chevauchementY = Math.signum((yMet1 - yAv2) * (yMet2 - yAv1));

		if (chevauchementX == chevauchementY && chevauchementX == -1.0) {
			System.out.println("BOOOOM!!!!!!");
			pAv.getAvion().setPv(pAv.getAvion().getPv() - pMe.getMeteorite().getDegat());
			System.out.println(pAv.getAvion().getPv());
			if (pAv.getAvion().getPv() <= 0) {
				this.continuer = false;
				vMaFenetre.finDePartie();
			} else {
				try {
					this.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println("Mode Fantôme");
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isContinuer() {
		return continuer;
	}

	public void setContinuer(boolean continuer) {
		this.continuer = continuer;
	}
}
