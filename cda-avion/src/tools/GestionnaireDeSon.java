package tools;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controllers.MonThread;

public class GestionnaireDeSon {
	private Clip clip;
	BufferedInputStream bufferedIn;
	AudioInputStream son;
	FloatControl gainControl;

	public GestionnaireDeSon(String pChemin) {

		try { // Tout dans le try permet de lire la musqiue du jeu en boucle.

			this.bufferedIn = (BufferedInputStream) MonThread.class.getResourceAsStream(pChemin);
			this.son = AudioSystem.getAudioInputStream(this.bufferedIn);
			this.clip = AudioSystem.getClip();
			this.clip.open(son);
			this.gainControl = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
			this.gainControl.setValue(-30.0f); // Reduce volume by 10 decibels.

		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void playContinuly() {
		play();
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void play() {
		this.clip.start();
	}

	public void stop() {
		this.clip.stop();
	}

}
