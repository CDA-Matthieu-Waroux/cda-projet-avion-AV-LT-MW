package models;

public abstract class Meteorite extends ObjetVolant {

	private int degat;

	public Meteorite(int pHeight, int pWidth, int pVitesse, int pDegat) {
		super(pHeight, pWidth, pVitesse);
		this.degat = pDegat;
	}

}
