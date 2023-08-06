package Songs;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html
 */
public class AviciiLevels {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public AviciiLevels(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run(){

        try {
            System.out.println();
            System.out.println("********** AVICII - LEVELS **********");
            System.out.println();
            song();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }

    public void pathOne() throws InterruptedException
    {
        int barCounter = 0;

        // Page 1 = Bars 1- 16
        // Page 2 = Bars 17 - 40
        // Page 3 = Bars 41 - 60
        // Page 4 = Bars 61 - 77
        // Page 5 = Bars 78 - 100
        String[] files = {"src/main/java/SheetMusic/Avicii/Levels/LevelsPathOne"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfPathArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfPathArray.add(splitLineText);
                }
                for (String[] txt : listOfPathArray)
                {
                    if (txt.length == 1)
                    {
                        barCounter++;
                        System.out.print("\nBar " + barCounter + ": ");
                    }
                    else if (txt.length == 2)
                    {
                        rest(Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 3)
                    {
                        playNote(txt[2], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 4)
                    {
                        playChord2(txt[2], txt[3], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 5)
                    {
                        playChord3(txt[2], txt[3], txt[4], Integer.parseInt(txt[0]));
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void pathTwo() throws InterruptedException
    {

        // Page 1 = Bars 1- 16
        // Page 2 = Bars 17 - 40
        // Page 3 = Bars 41 - 60
        // Page 4 = Bars 61 - 77
        // Page 5 = Bars 78 - 100
        String[] files = {"src/main/java/SheetMusic/Avicii/Levels/LevelsPathTwo"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfPathArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfPathArray.add(splitLineText);
                }
                for (String[] txt : listOfPathArray)
                {
                    if (txt.length == 2)
                    {
                        rest(Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 3)
                    {
                        playNote(txt[2], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 4)
                    {
                        playChord2(txt[2], txt[3], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 5)
                    {
                        playChord3(txt[2], txt[3], txt[4], Integer.parseInt(txt[0]));
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }



    public void song() throws InterruptedException
    {
        rest(1000);
        combineThread();
        System.out.println();
        rest(1000);
    }


    public void combineThread() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                pathOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                pathTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play simultaneously
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }





    // ********** rest METHOD **********
    public static void rest(int duration) throws InterruptedException
    {
        System.out.print("rest " );
        Thread.sleep(duration);
    }


    // ********** playNote METHODS **********
    public void playNote(String note, int durationMs) throws InterruptedException
    {
        System.out.print(note + " " );
        playNote(note, this.volume, durationMs);
    }

    public void playNote(String note, int volume, int durationMs) throws InterruptedException
    {
        int midiNote = getMidiNumber(note);

        channels[this.instrument].noteOn(midiNote, volume );
        Thread.sleep( durationMs );
        channels[this.instrument].noteOff(midiNote);
    }


    // ********** playChord METHODS **********

    public void playChord2(String note1, String note2, int durationMs) throws InterruptedException
    {
        System.out.print(note1 + " " + note2 + " ");
        playChord2(note1, note2, this.volume, durationMs);;
    }
    public void playChord2(String note1, String note2, int volume, int durationMs) throws InterruptedException
    {
        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord3(String note1, String note2, String note3, int durationMs) throws InterruptedException
    {
        System.out.print(note1 + " " + note2 + " " + note3 + " ");
        playChord3(note1, note2, note3, this.volume, durationMs);;
    }
    public void playChord3(String note1, String note2, String note3, int volume, int durationMs) throws InterruptedException
    {
        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord4(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException
    {
        System.out.print(note1 + " " + note2 + " " + note3 + " " + note4 + " ");
        playChord4(note1, note2, note3, note4, this.volume, durationMs);;
    }

    public void playChord4(String note1, String note2, String note3, String note4, int volume, int durationMs) throws InterruptedException
    {
        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3), getMidiNumber(note4)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    private int getMidiNumber(String noteWithOctave)
    {
        int octave = Integer.parseInt(noteWithOctave.substring(noteWithOctave.length() - 1));
        String noteName = noteWithOctave.substring(0, noteWithOctave.length() - 1).toUpperCase();
        int midiNumber = -1;

        for (int i = 0; i < notes.length; i++)
        {
            if (notes[i].equals(noteName))
            {
                midiNumber = 12 + (12 * octave) + i;
                break;
            }
        }
        return midiNumber;
    }





    // ********** OPEN / CLOSE SYNTH **********
    private void openSynth()
    {
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void closeSynth()
    {
        if(synth != null && synth.isOpen())
        {
            synth.close();
        }
    }
}
