/**
 * Created by adama on 5/14/2017.
 * The SoundManager Class handles all audio for adventure game.
 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class SoundManager {
    private Sequencer player;
    private Sequence song;
    private Map sounds = new HashMap();
    private String soundDirectory;

    // TODO: Test this constructor. Add the other functions.
    public SoundManager(String _soundDirectory){
        try (Stream<String> lines = Files.lines(Paths.get(_soundDirectory), Charset.defaultCharset())) {
            lines.forEachOrdered(System.out::println);
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }




}
