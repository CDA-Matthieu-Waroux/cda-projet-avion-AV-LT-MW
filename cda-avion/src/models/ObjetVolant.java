package models;

public abstract class ObjetVolant {

	private int vHeight;
	private int vWidth;
	private int vVitesse;
	private String vLienPhoto;

	public ObjetVolant(int pHeight, int pWidth, int pVitesse, String pLienPhoto) {
		this.vHeight = pHeight;
		this.vWidth = pWidth;
		this.vVitesse = pVitesse;
		this.setvLienPhoto(pLienPhoto);

	}

	public int getHeightOJ() {
		return vHeight;
	}

	public void setHeightOJ(int pHeight) {
		this.vHeight = pHeight;
	}

	public int getWidthOJ() {
		return vWidth;
	}

	public void setWidthOJ(int pWidth) {
		this.vWidth = pWidth;
	}

	public int getVitesse() {
		return vVitesse;
	}

	public void setVitesse(int pVitesse) {
		this.vVitesse = pVitesse;
	}

	public String getvLienPhoto() {
		return vLienPhoto;
	}

	public void setvLienPhoto(String vLienPhoto) {
		this.vLienPhoto = vLienPhoto;
	}

}
