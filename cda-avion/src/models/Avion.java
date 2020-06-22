package models;

public class Avion extends ObjetVolant {

	private int pv;

	public Avion(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pPv) {
		super(pHeight, pWidth, pVitesse, pLienPhoto);
		this.pv = pPv;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
}
