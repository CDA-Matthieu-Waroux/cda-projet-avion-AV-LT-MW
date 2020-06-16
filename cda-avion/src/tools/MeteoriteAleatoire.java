package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Meteorite;
import models.MeteoriteFeu;
import models.MeteoriteGlace;
import models.MeteoriteIceBerg;
import models.MeteoriteSimple;
import models.MeteoriteZigZag;

public class MeteoriteAleatoire {
	private final static int NB_RANDOM = 5;
	private static MeteoriteSimple simple = new MeteoriteSimple(30, 30, 2, "/ressources/meteorite.png");
	private static MeteoriteFeu feu = new MeteoriteFeu(40, 40, 1, "/ressources/meteoriteDeFeu.png");
	private static MeteoriteGlace glace = new MeteoriteGlace(35, 35, 1, "/ressources/meteoriteGlace.png");
	private static MeteoriteIceBerg iceBerg = new MeteoriteIceBerg(70, 70, 1, "/ressources/meteoriteIceBerg.png");
	private static MeteoriteZigZag zigzag = new MeteoriteZigZag(30, 30, 1, "/ressources/meteoriteZigzag.png");

	private static List<Meteorite> listMeteo = new ArrayList<>();

	public static Meteorite choixAleatoireMeteorite() {
		listMeteo.add(simple);
		listMeteo.add(feu);
		listMeteo.add(glace);
		listMeteo.add(iceBerg);
		listMeteo.add(zigzag);

		for (int i = 0; i < NB_RANDOM; i++) {

			Collections.shuffle(listMeteo);
		}

		return listMeteo.get(1);
	}
}
