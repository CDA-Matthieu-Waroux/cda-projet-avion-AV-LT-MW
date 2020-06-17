package models;

public abstract class Meteorite extends ObjetVolant {

	public Meteorite(int pHeight, int pWidth, int pVitesse, String pLienPhoto, int pDegat, int score) {
		super(pHeight, pWidth, pVitesse, pLienPhoto);
		this.degat = pDegat;
		this.setScore(score);
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	private int degat;
	private int score;

}
