package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controllers.MonThread;
import controllers.MyTimer;
import models.Player;
import vues.FenetreGameOver;
import vues.MaFenetre;

public class Game {
	private static GestionnaireDeSon son = new GestionnaireDeSon("/ressources/Cascade.wav");
	private static MonThread t1;
	private static MonThread t2;
	private static MonThread t3;
	private static MonThread t4;
	public static List<String> listScore = new ArrayList<>();
	public final static Player MY_PLAYER = new Player();

	public static void start(MaFenetre pMf) {

		t1 = new MonThread(pMf.getPnA(), pMf.getPnM1(), pMf, pMf.getPf());
		t2 = new MonThread(pMf.getPnA(), pMf.getPnM2(), pMf, pMf.getPf());
		t3 = new MonThread(pMf.getPnA(), pMf.getPnM3(), pMf, pMf.getPf());
		t4 = new MonThread(pMf.getPnA(), pMf.getPnM4(), pMf, pMf.getPf());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		son.playContinuly();

		new MyTimer(MaFenetre.TAUX_RAFRAICHESSEMENT, pMf.getPnA().getAvion(), pMf.getPf(), pMf.getPnM1(), pMf.getPnM2(),
				pMf.getPnM3(), pMf.getPnM4());

		MY_PLAYER.setScore(0);
		pMf.getPnA().getAvion().setPv(5);
		pMf.getPf().getLabelVie().setText("Vie : 5");
		pMf.getPf().getLabelScore().setText("Score : 0");

	}

	public static void end(MaFenetre pMf) {

		t1.setContinuer(false);
		t2.setContinuer(false);
		t3.setContinuer(false);
		t4.setContinuer(false);
		File file = new File("C://temp");

		file.mkdir();
		file = new File("C://temp/scoring");

		try {
			if (!file.createNewFile()) {
				try {
					file.createNewFile();
					verifScore(file, pMf);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else

			{
				verifScore(file, pMf);

				try {
					file.delete();
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

			listScore.forEach(x -> {
				try {
					bw.write(x);
					bw.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}

			});
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		son.stop();
		// this.setVisible(false);
		new FenetreGameOver(pMf);
	}

	private static void verifScore(File pFile, MaFenetre pMf) {
		System.out.println(listScore);
		listScore.clear();

		String text = "";
		try (BufferedReader br = new BufferedReader(new FileReader(pFile))) {

			while ((text = br.readLine()) != null) {
				listScore.add(text);
			}

		} catch (IOException ec) {
			ec.printStackTrace();
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
		text = pMf.getPf().getLabelNom().getText() + " " + dtf.format(LocalDateTime.now()) + " "
				+ pMf.getPf().getLabelScore().getText();
		String f = "";
		if (!listScore.isEmpty()) {
			for (int i = 0; i < listScore.size(); i++) {
				f = listScore.get(i);
				int g = (f.length() - 3);
				f = f.substring(g);
				f = f.trim();

				g = Integer.parseInt(f);

				if (i == 0 && g > MY_PLAYER.getScore()) {
					continue;
				} else if (g < MY_PLAYER.getScore()) {
					listScore.add(i, text);
					break;
				} else if (g > MY_PLAYER.getScore() && i == (listScore.size() - 1)) {
					listScore.add(listScore.size(), text);
					break;

				}

			}

			while (listScore.size() > 20) {
				listScore.remove(20);
			}
		} else {
			listScore.add(text);
		}
	}

}
