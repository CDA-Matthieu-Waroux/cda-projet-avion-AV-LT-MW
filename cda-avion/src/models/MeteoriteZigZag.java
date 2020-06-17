package models;

public class MeteoriteZigZag extends Meteorite {

	private int deplacement = 30;
	private int abcisse;
	private int compteur;
	private boolean left = true;

	public boolean isLeft() {
		return left;
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
		super(pHeight, pWidth, pVitesse, pLienPhoto, 1);
	}

	public int getAbcisse() {
		return abcisse;
	}

	public void setAbcisse(int abcisse) {
		this.abcisse = abcisse;
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
