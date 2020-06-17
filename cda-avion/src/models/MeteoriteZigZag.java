package models;

public class MeteoriteZigZag extends Meteorite {

	private int deplacement = 10;
	private int widthMax;
	private int widthMin;

	public MeteoriteZigZag(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pWidthMin, int pWidhtMAx) {
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1);
		this.widthMax = pWidhtMAx;
		this.widthMin = pWidthMin;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacementGauche(int deplacement) {
		this.deplacement = deplacement;
	}

}
