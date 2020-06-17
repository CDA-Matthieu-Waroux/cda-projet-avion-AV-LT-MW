package models;

public abstract class Meteorite extends ObjetVolant {

	public Meteorite(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pDegat) {
		super(pHeight, pWidth, pVitesse, pLienPhoto);
		this.degat = pDegat;
	}

	private int degat;

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

}
