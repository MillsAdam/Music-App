import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class AviciiMain {

    // Instance variables
    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

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

    public void rightHandOctave6() throws InterruptedException
    {

    }

    public void rightHandOctave5() throws InterruptedException
    {

    }

    public void rightHandOctave4() throws InterruptedException
    {

    }

    public void rightHandOctave3() throws InterruptedException
    {

    }

    public void leftHandOctave3() throws InterruptedException
    {

    }

    public void leftHandOctave2() throws InterruptedException
    {

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
    private void playChord(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t");
        playChord(note1, note2, note3, note4, this.volume, durationMs);;
    }

    public void playChord(String note1, String note2, String note3, String note4, int volume, int durationMs) throws InterruptedException {

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
