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
	private final static byte VITESSE_NORMAL = 2;
	private final static byte VITESSE_LENTE = 1;

	private static MeteoriteSimple simple = new MeteoriteSimple(30, 30, VITESSE_NORMAL, "/ressources/meteorite.png");
	private static MeteoriteFeu feu = new MeteoriteFeu(40, 40, VITESSE_LENTE, "/ressources/meteoriteFeu.png");
	private static MeteoriteGlace glace = new MeteoriteGlace(35, 35, VITESSE_NORMAL, "/ressources/meteoriteGlace.png");
	private static MeteoriteIceBerg iceBerg = new MeteoriteIceBerg(70, 70, VITESSE_NORMAL,
			"/ressources/meteoriteIceBerg.png");
	private static MeteoriteZigZag zigzag = new MeteoriteZigZag(30, 30, VITESSE_LENTE,
			"/ressources/meteoriteZigzag.png");

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
