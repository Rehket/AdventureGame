import java.io.*;
//Need to import the java.NET.URL to find the music.

//FUCKING WORKS HAHAHAHAHAHAHAHA




import javax.sound.sampled.*;

import javax.swing.*;


@SuppressWarnings({ "serial" })
public class PlaySound extends JFrame {
	
	public PlaySound(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Play That Sound");
		this.setSize(600, 600);
		this.setVisible(true);
		
		try{
			//WE WILL NOW OPEN THE AUDIO STREAM. can use File or URL
			
			File soundFile = new File("sound.wav");
			
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			
			//Get the sound Clip.
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioIn);
			clip.start();
			
		}catch (UnsupportedAudioFileException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}catch (LineUnavailableException e){
			e.printStackTrace();
			
		}
	}


public static void sound(){
	new PlaySound();
}

}