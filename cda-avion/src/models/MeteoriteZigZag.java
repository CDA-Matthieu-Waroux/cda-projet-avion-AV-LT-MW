package models;

public class MeteoriteZigZag extends Meteorite {

	private int deplacement = 10;
	private int widthMax;
	private int widthMin;

	public MeteoriteZigZag(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pWidthMin, int pWidhtMAx) {
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1);
		this.setWidthMax(pWidhtMAx);
		this.setWidthMin(pWidthMin);
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacementGauche(int deplacement) {
		this.deplacement = deplacement;
	}

	public int getWidthMin() {
		return widthMin;
	}

	public void setWidthMin(int widthMin) {
		this.widthMin = widthMin;
	}

	public int getWidthMax() {
		return widthMax;
	}

	public void setWidthMax(int widthMax) {
		this.widthMax = widthMax;
	}

}
