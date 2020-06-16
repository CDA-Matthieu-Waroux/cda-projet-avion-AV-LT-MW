package models;

public abstract class Meteorite extends ObjetVolant {

	public Meteorite(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pDegat) {
		super(pHeight, pWidth, pVitesse, pLienPhoto);
		this.degat = pDegat;
	}

	private int degat;

}
