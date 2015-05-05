import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound extends Thread{
	Clip audioClip;
	File audioFile;
	boolean loop;
	public Sound(String audiofile, boolean loop){
		 this.audioFile= new File(audiofile);
		 this.loop = loop;
	}
	public void run() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format); 
			this.audioClip = (Clip) AudioSystem.getLine(info); 
			audioClip.open(audioStream);
			if (loop)
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			else{
				audioClip.start();
				Thread.sleep(((int)audioClip.getMicrosecondLength()/1000));
				audioClip.stop();
				audioClip.close();
			}
		}
			catch (InterruptedException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}

}
