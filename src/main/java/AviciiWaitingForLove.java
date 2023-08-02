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
public class AviciiWaitingForLove {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public AviciiWaitingForLove(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run(){

        try {
            System.out.println("********** AVICII - WAITING FOR LOVE **********");
            System.out.println();
            levels();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }

    public void rightHandTxt() throws InterruptedException
    {
        int rightBarCounter = 0;

        // Page 1 = Bars 1- 24
        // Page 2 = Bars 25 - 50
        // Page 3 = Bars 51 - 75
        // Page 4 = Bars 76 - 101
        // Page 5 = Bars 102 - 121
        String[] files = {"WFLSheet/WaitingForLoveRHPage1", "WFLSheet/WaitingForLoveRHPage2",
                "WFLSheet/WaitingForLoveRHPage3", "WFLSheet/WaitingForLoveRHPage4", "WFLSheet/WaitingForLoveRHPage5"};

        for (int i = 0; i < files.length; i++)
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
                        rightBarCounter++;
                        System.out.print("\nBar " + rightBarCounter + ": ");
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

    public void leftHandTxt() throws InterruptedException
    {

        // Page 1 = Bars 1- 24
        // Page 2 = Bars 25 - 50
        // Page 3 = Bars 51 - 75
        // Page 4 = Bars 76 - 101
        // Page 5 = Bars 102 - 121
        String[] files = {"WFLSheet/WaitingForLoveLHPage1", "WFLSheet/WaitingForLoveLHPage2",
                "WFLSheet/WaitingForLoveLHPage3", "WFLSheet/WaitingForLoveLHPage4", "WFLSheet/WaitingForLoveLHPage5"};

        for (int i = 0; i < files.length; i++)
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
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }



    public void levels() throws InterruptedException
    {
        combineLeftHandRightHand();
        rest(476);
    }


    public void combineLeftHandRightHand() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                rightHandTxt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                leftHandTxt();
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





    /*
     * Delay program, i.e. rest
     */
    public static void rest(int duration) throws InterruptedException {
        System.out.print("rest " );
        Thread.sleep(duration);
    }

    /*
     * Play a note in the form <octave><note>, e.g. "C4" for middle C
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html#noteOn(int,int)
     */
    public void playNote(String note) throws InterruptedException {
        System.out.print(note + " " );
        playNote(note, 238); // 238 milliseconds = 1/8 beat for 126 bpm
    }

    public void playNote(String note, int durationMs) throws InterruptedException {
        System.out.print(note + " " );
        playNote(note, this.volume, durationMs);
    }

    public void playNote(String note, int volume, int durationMs) throws InterruptedException {
        int octave = Integer.parseInt(note.substring(note.length() - 1));
        int tone = note.length() > 2 ? getToneIndex(note.substring(0, 2)) : getToneIndex(note.substring(0, 1));
        int midi_note = 12 + (12 * octave) + tone;

        /*
         * Play note for duration using Thread.sleep, then turn off note
         */
        channels[this.instrument].noteOn(midi_note, volume );
        Thread.sleep( durationMs );
        channels[this.instrument].noteOff(midi_note);
    }

    private Integer getToneIndex(String note){
        Integer toneIndex = null;

        for(int i = 0; i < notes.length; i++){
            if( notes[i].equals(note) ){
                toneIndex = i;
                break;
            }
        }

        return toneIndex;
    }


    // ********** playChord METHODS **********

    public void playChord2(String note1, String note2, int durationMs) throws InterruptedException {
        System.out.print(note1 + " " + note2 + " ");
        playChord2(note1, note2, this.volume, durationMs);;
    }
    public void playChord2(String note1, String note2, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord3(String note1, String note2, String note3, int durationMs) throws InterruptedException {
        System.out.print(note1 + " " + note2 + " " + note3 + " ");
        playChord3(note1, note2, note3, this.volume, durationMs);;
    }
    public void playChord3(String note1, String note2, String note3, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord4(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t");
        playChord4(note1, note2, note3, note4, this.volume, durationMs);;
    }

    public void playChord4(String note1, String note2, String note3, String note4, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3), getMidiNumber(note4)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    private int getMidiNumber(String noteWithOctave) {
        int octave = Integer.parseInt(noteWithOctave.substring(noteWithOctave.length() - 1));
        String noteName = noteWithOctave.substring(0, noteWithOctave.length() - 1).toUpperCase();
        int noteIndex = -1;

        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(noteName)) {
                noteIndex = 12 + (12 * octave) + i;
                break;
            }
        }
        return noteIndex;
    }





    // ********** OPEN / CLOSE SYNTH **********
    private void openSynth(){
        try {

            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void closeSynth(){
        if(synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}
