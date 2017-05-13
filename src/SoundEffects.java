import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;


@SuppressWarnings("unused")
public enum SoundEffects{
	
	DEATH("death.wav"),
	PLOOP("ploop.wav"),
	DEATH2("death2.wav"),
	MINE("mine.wav"),
	TREASURE("treasure.wav"),
	TREASURE2("treasure2.wav"),
	PREVENT("prevent.wav"),
	TELE("tele.wav"),
	GTFO("GTFO.wav"),
	PEW("pew.wav"),
	LOLASER("LOLaser.wav"),
	EDEATH("edeath.wav"),
	REDALERT("redalert.wav"),
	ALIENS("tribble.wav");

private Clip clip;


SoundEffects(String soundEffect){
	try{
		File soundFile = new File(soundEffect);
		
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		
		clip = AudioSystem.getClip();
		
		clip.open(audioInputStream);
	}catch (UnsupportedAudioFileException error){
		error.printStackTrace();
	}catch (IOException error){
		error.printStackTrace();
	}catch (LineUnavailableException error){
		error.printStackTrace();
		}
}



	public void play(){
		if(clip.isRunning()){
		clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}
	
	static void init(){
		values();
	}

}