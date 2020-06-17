package models;

public class MeteoriteZigZag extends Meteorite {

	private int deplacement = 10;
	private int widthMax;
	private int widthMin;

	public MeteoriteZigZag(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pWidthMin, int pWidhtMAx) {
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1, 5);
		this.setWidthMax(pWidhtMAx);
		this.setWidthMin(pWidthMin);
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public MeteoriteZigZag(int pHeight, int pWidth, int pVitesse, String pLienPhoto) {
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1, 5);
	}

	public int getAbcisse() {
		return abcisse;
	}

	public void setAbcisse(int abcisse) {
		this.abcisse = abcisse;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacementGauche(int deplacement) {
		this.deplacement = deplacement;
	}

}
