package tools;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import models.Heineken;
import models.Meteorite;
import models.MeteoriteFeu;
import models.MeteoriteGlace;
import models.MeteoriteIceBerg;
import models.MeteoriteSimple;
import models.MeteoriteZigZag;
import vues.MonThread;

public class MeteoriteAleatoire {
	private final static byte NB_RANDOM = 5;
	private final static byte VITESSE_NORMAL = 5;
	private final static byte VITESSE_LENTE = 2;
	private final static byte VITESSE_RAPIDE = 10;
	private final static byte HAUTEUR_METEORITE = 40;
	private final static byte LARGEUR_METEORITE = 40;

	private static MeteoriteSimple simple = new MeteoriteSimple(HAUTEUR_METEORITE, LARGEUR_METEORITE, VITESSE_RAPIDE,
			"/ressources/meteorite.png");
	private static MeteoriteSimple simple1 = new MeteoriteSimple(HAUTEUR_METEORITE, LARGEUR_METEORITE, VITESSE_RAPIDE,
			"/ressources/meteorite.png");
	private static MeteoriteSimple simple2 = new MeteoriteSimple(HAUTEUR_METEORITE, LARGEUR_METEORITE, VITESSE_RAPIDE,
			"/ressources/meteorite.png");
	private static MeteoriteSimple simple3 = new MeteoriteSimple(HAUTEUR_METEORITE, LARGEUR_METEORITE, VITESSE_RAPIDE,
			"/ressources/meteorite.png");

	private static MeteoriteFeu feu = new MeteoriteFeu(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10, VITESSE_NORMAL,
			"/ressources/meteorite.png");
	private static MeteoriteFeu feu1 = new MeteoriteFeu(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10, VITESSE_NORMAL,
			"/ressources/meteorite.png");
	private static MeteoriteFeu feu2 = new MeteoriteFeu(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10, VITESSE_NORMAL,
			"/ressources/meteorite.png");
	private static MeteoriteFeu feu3 = new MeteoriteFeu(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10, VITESSE_NORMAL,
			"/ressources/meteorite.png");

	private static MeteoriteGlace glace = new MeteoriteGlace(HAUTEUR_METEORITE + 5, LARGEUR_METEORITE + 5,
			VITESSE_RAPIDE, "/ressources/meteoriteGlace.png");
	private static MeteoriteGlace glace1 = new MeteoriteGlace(HAUTEUR_METEORITE + 5, LARGEUR_METEORITE + 5,
			VITESSE_RAPIDE, "/ressources/meteoriteGlace.png");
	private static MeteoriteGlace glace2 = new MeteoriteGlace(HAUTEUR_METEORITE + 5, LARGEUR_METEORITE + 5,
			VITESSE_RAPIDE, "/ressources/meteoriteGlace.png");
	private static MeteoriteGlace glace3 = new MeteoriteGlace(HAUTEUR_METEORITE + 5, LARGEUR_METEORITE + 5,
			VITESSE_RAPIDE, "/ressources/meteoriteGlace.png");

	private static MeteoriteIceBerg iceBerg = new MeteoriteIceBerg((HAUTEUR_METEORITE + 5) * 2,
			(LARGEUR_METEORITE + 5) * 2, VITESSE_NORMAL, "/ressources/meteoriteIceBerg.png");
	private static MeteoriteIceBerg iceBerg1 = new MeteoriteIceBerg((HAUTEUR_METEORITE + 5) * 2,
			(LARGEUR_METEORITE + 5) * 2, VITESSE_NORMAL, "/ressources/meteoriteIceBerg.png");
	private static MeteoriteIceBerg iceBerg2 = new MeteoriteIceBerg((HAUTEUR_METEORITE + 5) * 2,
			(LARGEUR_METEORITE + 5) * 2, VITESSE_NORMAL, "/ressources/meteoriteIceBerg.png");
	private static MeteoriteIceBerg iceBerg3 = new MeteoriteIceBerg((HAUTEUR_METEORITE + 5) * 2,
			(LARGEUR_METEORITE + 5) * 2, VITESSE_NORMAL, "/ressources/meteoriteIceBerg.png");

	private static MeteoriteZigZag zigzag = new MeteoriteZigZag(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10,
			VITESSE_LENTE, "/ressources/meteoriteZigzag.png");
	private static MeteoriteZigZag zigzag1 = new MeteoriteZigZag(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10,
			VITESSE_LENTE, "/ressources/meteoriteZigzag.png");
	private static MeteoriteZigZag zigzag2 = new MeteoriteZigZag(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10,
			VITESSE_LENTE, "/ressources/meteoriteZigzag.png");
	private static MeteoriteZigZag zigzag3 = new MeteoriteZigZag(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10,
			VITESSE_LENTE, "/ressources/meteoriteZigzag.png");
	private static Heineken heineken = new Heineken(HAUTEUR_METEORITE + 10, LARGEUR_METEORITE + 10, VITESSE_NORMAL,
			"/ressources/heineken.png");

	private static ArrayList<Meteorite> listMeteo = new ArrayList<>(
			Arrays.asList(zigzag, zigzag1, zigzag2, zigzag3, iceBerg, iceBerg1, iceBerg2, iceBerg3, glace, glace1,
					glace2, glace3, feu, feu1, feu2, feu3, simple, simple1, simple2, simple3, heineken));

	public static Meteorite choixAleatoireMeteorite() {

		for (int i = 0; i < NB_RANDOM; i++) {

			Collections.shuffle(listMeteo);
		}

		Meteorite value = listMeteo.get(0);
		listMeteo.remove(value);
		if (value instanceof Heineken) {
			try {

				InputStream urlExplosion = MonThread.class
						.getResourceAsStream("/ressources/tequila-heineken-pas-ltemps-dniaiser.wav");
				InputStream bufferedIn = new BufferedInputStream(urlExplosion);
				AudioInputStream monExplosion = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(monExplosion);
				clip.start();

			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
				throw new RuntimeException(e);

			}
		}
		return value;
	}

	public static void AddMeteoriteList(Meteorite pMeteo) {
		listMeteo.add(pMeteo);
	}

	public static void RafraichirListe() {
		listMeteo = new ArrayList<>(
				Arrays.asList(zigzag, zigzag1, zigzag2, zigzag3, iceBerg, iceBerg1, iceBerg2, iceBerg3, glace, glace1,
						glace2, glace3, feu, feu1, feu2, feu3, simple, simple1, simple2, simple3, heineken));
	}

	public static ArrayList<Meteorite> getListMeteo() {
		return listMeteo;
	}

	public static void setListMeteo(ArrayList<Meteorite> listMeteo) {
		MeteoriteAleatoire.listMeteo = listMeteo;
	}

}
