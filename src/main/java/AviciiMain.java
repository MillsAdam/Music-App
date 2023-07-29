import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AviciiMain {

    // Instance variables
    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    private List<String[]> rightHandOctave6Array = new ArrayList<>();

    public AviciiMain(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run(){

        try {
            levels();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        closeSynth();
    }

    public void levels() throws InterruptedException
    {
        combineAll();
    }


    // *****************SOMETHING IS OFF SOMEWHERE********************





    public void rightHandOctave6() throws InterruptedException
    {
        // block 1
        rest(3094);
        // block 2
        rest(3094);
        // block 3
        rest(3094);
        // block 4
        rest(3094);
        // block 5
        rest(3094);
        // block 6
        rest(3094);
        // block 7
        rest(3094);
        // block 8
        rest(3094);
        // block 9
        rest(3094);
        // block 10
        rest(3094);
        // block 11
        rest(3094);
        // block 12
        rest(3094);
        // block 13
        rest(3094);
        // block 14
        rest(3094);
        // block 15
        rest(3094);
        // block 16
        rest(3094);
    }

    public void rightHandOctave5() throws InterruptedException
    {
        // block 1
        playNote("E5");
        rest(714);
        playNote("E5");
        rest(714);
        playNote("D#5");
        rest(476);
        playNote("E5");
        rest(238);
        // block 2
        rest(714);
        playNote("B5");
        rest(714);
        playNote("D#5");
        rest(714);
        playNote("F#5");
        rest(238);
        // block 3
        playNote("G#5");
        playNote("E5");
        rest(952);
        playNote("E5");
        rest(714);
        playNote("E5");
        rest(476);
        // block 4
        rest(238);
        playNote("D#5");
        rest(476);
        playNote("E5");
        rest(952);
        playNote("B5");
        rest(714);
        // block 5
        playNote("G#5");
        rest(714);
        playNote("F#5");
        rest(238);
        playNote("G#5");
        playNote("E5");
        rest(238);
        playNote("C#5");
        rest(714);
        // block 6
        rest(2856);
        playNote("C#5");
        // block 7
        rest(3094);
        // block 8
        rest(476);
        playNote("C#5");
        rest(2380);
        // block 9
        rest(1190);
        playNote("C#5");
        rest(1666);
        // block 10
        rest(1904);
        playNote("C#5");
        rest(952);
        // block 11
        rest(2618);
        playNote("C#5");
        rest(238);
        // block 12
        rest(3094);
        // block 13
        rest(238);
        playNote("C#5");
        rest(2618);
        // block 14
        rest(952);
        playNote("C#5");
        rest(1904);
        // block 15
        rest(1666);
        playNote("C#5");
        playNote("C#5");
        playNote("C#5");
        playNote("C#5");
        rest(476);
        // block 16
        rest(3094);
    }

    public void rightHandOctave4() throws InterruptedException
    {
        // block 1
        playNote("E4");
        rest(714);
        playNote("E4");
        rest(714);
        playNote("D#4");
        rest(476);
        playNote("E4");
        rest(238);
        // block 2
        rest(714);
        playNote("B4");
        rest(714);
        playNote("G#4");
        rest(714);
        playNote("F#4");
        rest(238);
        // block 3
        playNote("G#4");
        playNote("E4");
        rest(952);
        playNote("E4");
        rest(714);
        playNote("E4");
        rest(476);
        // block 4
        rest(238);
        playNote("D#4");
        rest(476);
        playNote("E4");
        rest(952);
        playNote("B4");
        rest(714);
        // block 5
        playNote("G#4");
        rest(714);
        playNote("F#4");
        rest(238);
        playNote("G#4");
        playNote("E4");
        rest(476);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        // block 6
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("D#4");
        playNote("D#4");
        playNote("E4");
        playNote("E4");
        rest(476);
        // block 7
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("C#4");
        playNote("C#4");
        rest(238);
        // block 8
        rest(714);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        // block 9
        playNote("D#4");
        playNote("D#4");
        playNote("E4");
        playNote("E4");
        rest(476);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        // block 10
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("C#4");
        playNote("C#4");
        rest(952);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        // block 11
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("D#4");
        playNote("D#4");
        playNote("E4");
        playNote("E4");
        rest(476);
        playNote("B4");
        // block 12
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("C#4");
        playNote("C#4");
        rest(476);
        // block 13
        rest(476);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("D#4");
        // block 14
        playNote("D#4");
        playNote("E4");
        playNote("E4");
        rest(476);
        playNote("B4");
        playNote("G#4");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        // block 15
        playNote("E4");
        playNote("E4");
        playNote("C#4");
        playNote("C#4");
        rest(714);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        rest(476);
        // block 16
        playChord2("B4", "E4", 238);
        rest(714);
        playChord2("G#4", "E4", 238);
        playChord2("F#4", "E4", 238);
        rest(238);
        playChord2("G#4", "E4", 238);
        playNote("E4", 238);
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("C#4");
    }

    public void rightHandOctave3() throws InterruptedException
    {
        // block 1
        rest(3094);
        // block 2
        rest(3094);
        // block 3
        rest(3094);
        // block 4
        rest(3094);
        // block 5
        rest(3094);
        // block 6
        rest(3094);
        // block 7
        rest(3094);
        // block 8
        playNote("B3");
        rest(2856);
        // block 9
        rest(3094);
        // block 10
        rest(1190);
        playNote("B3");
        playNote("B3");
        rest(1428);
        // block 11
        rest(3094);
        // block 12
        rest(2618);
        playNote("B3");
        playNote("B3");
        // block 13
        rest(3094);
        // block 14
        rest(3094);
        // block 15
        rest(952);
        playNote("B3");
        playNote("B3");
        rest(1666);
        // block 16
        rest(3094);
    }

    public void leftHandOctave3() throws InterruptedException
    {
        // block 1
        playNote("C#3");
        rest(714);
        playNote("E3");
        rest(1904);
        // block 2
        rest(714);
        playNote("C#3");
        rest(714);
        playNote("E3");
        rest(1190);
        // block 3
        rest(1428);
        playNote("C#3");
        rest(714);
        playNote("E3");
        rest(476);
        // block 4
        rest(2142);
        playNote("C#3");
        rest(714);
        // block 5
        playNote("E3");
        rest(2618);
        playNote("C#3");
        // block 6
        playNote("C#3");
        playNote("C#3");
        rest(238);
        playNote("E3");
        playNote("E3");
        playNote("E3");
        playNote("E3");
        rest(1428);
        // block 7
        rest(476);
        playNote("C#3");
        playNote("C#3");
        playNote("C#3");
        rest(238);
        playNote("E3");
        playNote("E3");
        playNote("E3");
        playNote("E3");
        rest(714);
        // block 8
        rest(1190);
        playNote("C#3");
        playNote("C#3");
        playNote("C#3");
        rest(238);
        playNote("E3");
        playNote("E3");
        playNote("E3");
        playNote("E3");
        // block 9
        rest(1904);
        playNote("C#3");
        playNote("C#3");
        playNote("C#3");
        rest(238);
        playNote("E3");
        // block 10
        playNote("E3");
        playNote("E3");
        playNote("E3");
        rest(1904);
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3"); // extended
        // block 11
        rest(119); // short rest
        playNote("C#3");
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(1666);
        // block 12
        rest(238);
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(952);
        // block 13
        rest(952);
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(119); // short rest
        playNote("E3");
        rest(238);
        // block 14
        rest(1666);
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        rest(119); // short rest
        playNote("C#3");
        playNote("E3");
        rest(119); // short rest
        playNote("E3"); // extended
        // block 15
        rest(119); // short rest
        playNote("E3");
        rest(1904);
        playNote("C#3");
        rest(476);
        // block 16
        rest(238);
        playNote("E3");
        rest(2618);
    }

    public void leftHandOctave2() throws InterruptedException
    {
        // block 1
        playNote("C#2");
        rest(714);
        playNote("E2");
        rest(714);
        playNote("B2");
        rest(476);
        playNote("A2");
        rest(238);
        // block 2
        rest(714);
        playNote("C#2");
        rest(714);
        playNote("E2");
        rest(714);
        playNote("B2");
        rest(238);
        // block 3
        rest(238);
        playNote("A2");
        rest(952);
        playNote("C#2");
        rest(714);
        playNote("E2");
        rest(476);
        // block 4
        rest(238);
        playNote("B2");
        rest(476);
        playNote("A2");
        rest(952);
        playNote("C#2");
        rest(714);
        // block 5
        playNote("E2");
        rest(714);
        playNote("B2");
        rest(476);
        playNote("A2");
        rest(952);
        playNote("C#2");
        // block 6
        playNote("C#2");
        playNote("C#2");
        rest(238);
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        // block 7
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        playNote("C#2");
        playNote("C#2");
        rest(238);
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        // block 8
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        playNote("C#2");
        playNote("C#2");
        rest(238);
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("E2");
        // block 9
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        playNote("C#2");
        playNote("C#2");
        rest(238);
        playNote("E2");
        // block 10
        playNote("E2");
        playNote("E2");
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2"); // extended
        // block 11
        rest(119); // short rest
        playNote("C#2");
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        // block 12
        playNote("A2");
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        // block 13
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        rest(119); // short rest
        playNote("E2");
        playNote("B2");
        // block 14
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        rest(119); // short rest
        playNote("C#2");
        playNote("E2");
        rest(119); // short rest
        playNote("E2"); // extended
        // block 15
        rest(119); // short rest
        playNote("E2");
        playNote("B2");
        playNote("B2");
        playNote("B2");
        playNote("A2");
        rest(238);
        playNote("A2");
        playNote("A2");
        playNote("A2");
        playNote("C#2");
        rest(476);
        // block 16
        rest(238);
        playNote("E2");
        rest(714);
        playNote("B2");
        rest(476);
        playNote("A2");
        rest(952);
    }



    public void combineAll() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                rightHandOctave6();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                rightHandOctave5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                rightHandOctave4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                rightHandOctave3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                leftHandOctave3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                leftHandOctave2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play simultaneously
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
    }








    // ********** playChord METHODS **********
    private void playChord2(String note1, String note2, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t");
        playChord2(note1, note2, this.volume, durationMs);
    }


    private void playChord2(String note1, String note2, int volume, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t");
        playChord2(note1, note2, volume, durationMs);;

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


    private void playChord4(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t");
        playChord4(note1, note2, note3, note4, this.volume, durationMs);;
    }

    private void playChord4(String note1, String note2, String note3, String note4, int volume, int durationMs) throws InterruptedException {

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



    // ********** rest METHODS **********
    // Delay program
    private static void rest(int duration) throws InterruptedException {
        System.out.print("\trest");
        Thread.sleep(duration);
    }



    // ********** playNote METHODS **********
    // Play note in the form <octave><note>
    private void playNote(String note) throws InterruptedException {
        System.out.print("\t" + note + "\t");
        playNote(note, 238); // 1/8 beat duration
    }

    private void playNote(String note, int durationMs) throws InterruptedException {
        System.out.print("\t" + note + "\t");
        playNote(note, this.volume, durationMs);
    }

    private void playNote(String note, int volume, int durationMs) throws InterruptedException {
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



    // ********** synth METHODS **********
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
