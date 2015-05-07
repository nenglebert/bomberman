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
	int duration;
	boolean loop;
	public Sound(File audiofile, boolean loop){
		 this.loop = loop;
		 AudioInputStream audioStream;
		 this.audioFile = audiofile;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			 AudioFormat format = audioStream.getFormat();
			 DataLine.Info info = new DataLine.Info(Clip.class, format); 
			 this.audioClip = (Clip) AudioSystem.getLine(info); 
			 audioClip.open(audioStream);
			 this.duration = ((int)audioClip.getMicrosecondLength()/1000);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void run() {
		try {
			if (loop)
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			else{
				audioClip.start();
				Thread.sleep(duration);
				stopClip();
			}
		}
			catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
public void stopClip(){
	audioClip.stop();;
	audioClip.close();
}
public void pause(){
	audioClip.stop();
}
public void restart(){
	if(loop)
		audioClip.loop(Clip.LOOP_CONTINUOUSLY);
	else
		audioClip.start();
}

 public int getDuration(){
	 System.out.println(duration);
	return duration;
}
}
