import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


// The class to play the music.
public class Song {
	
	Sequencer player;
	Sequence song;
	
	
	public Song(String s){
		
		
		try{
			
			this.player = MidiSystem.getSequencer();
	
			this.song = MidiSystem.getSequence(new File(s));
			 
			player.open();
			player.setSequence(song);
			player.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
			//player.
			player.start();
		} catch (MidiUnavailableException error){
			error.printStackTrace();
		} catch (InvalidMidiDataException error){
			error.printStackTrace();
		} catch (IOException error){
			error.printStackTrace();
		}
		
		
	}
	
	
	public static void playSong(Song v){
		v.player.start();
		
	
	}
	
	
	public static void stopSong(Song v){
		v.player.stop();
		
	}



}
