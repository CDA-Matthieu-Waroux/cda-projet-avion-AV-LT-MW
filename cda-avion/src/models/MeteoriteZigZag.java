package models;

public class MeteoriteZigZag extends Meteorite {

	private int deplacement = 30;

	public MeteoriteZigZag(int pHeight, int pWidth, int pVitesse, String pLienPhoto) {
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1);
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacementGauche(int deplacement) {
		this.deplacement = deplacement;
	}

}
