package tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import vues.PanelCentral;

public class AffichageImage {

	private static BufferedImage image;

	public static BufferedImage afficherIMG(String pChemin) {
		InputStream img = PanelCentral.class.getResourceAsStream(pChemin);

		try {
			image = ImageIO.read(img);// avec read, tj ioexception
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
