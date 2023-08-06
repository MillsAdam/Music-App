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
public class MikuHatsuneSenbonzakura {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public MikuHatsuneSenbonzakura(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run()
    {
        try {
            song();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }

    public void pathOne() throws InterruptedException
    {
        int BarCounter = 0;

        // Page 1: 1 - 28
        // Page 2: 29 - 60
        // Page 3: 61 - 92
        // Page 4: 93 - 120
        // Page 5: 121 - 153
        String[] files = {"src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOnePage1",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOnePage2",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOnePage3",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOnePage4",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOnePage5",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathOne"};

        for (int i = 5; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfRightHandArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfRightHandArray.add(splitLineText);
                }
                for (String[] txt : listOfRightHandArray)
                {
                    if (txt.length == 1)
                    {
                        BarCounter++;
                        System.out.print("\nBar " + BarCounter + ": ");
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
                    else if (txt.length == 6)
                    {
                        playChord4(txt[2], txt[3], txt[4], txt[5], Integer.parseInt(txt[0]));
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
        // Page 1: 1 - 28
        // Page 2: 29 - 60
        // Page 3: 61 - 92
        // Page 4: 93 - 120
        // Page 5: 121 - 153
        String[] files = {"src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwoPage1",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwoPage2",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwoPage3",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwoPage4",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwoPage5",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathTwo"};

        for (int i = 5; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfLeftHandArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfLeftHandArray.add(splitLineText);
                }
                for (String[] txt : listOfLeftHandArray)
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
                    else if (txt.length == 6)
                    {
                        playChord4(txt[2], txt[3], txt[4], txt[5], Integer.parseInt(txt[0]));
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void pathThree() throws InterruptedException
    {
        // Page 1: 1 - 28
        // Page 2: 29 - 60
        // Page 3: 61 - 92
        // Page 4: 93 - 120
        // Page 5: 121 - 153
        String[] files = {"src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThreePage1",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThreePage2",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThreePage3",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThreePage4",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThreePage5",
                "src/main/java/SheetMusic/MikuHatsune/Senbonzakura/SenbonzakuraPathThree"};

        for (int i = 5; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfLeftHandArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfLeftHandArray.add(splitLineText);
                }
                for (String[] txt : listOfLeftHandArray)
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
                    else if (txt.length == 6)
                    {
                        playChord4(txt[2], txt[3], txt[4], txt[5], Integer.parseInt(txt[0]));
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

        Thread thread3 = new Thread(() -> {
            try {
                pathThree();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play simultaneously
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
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
