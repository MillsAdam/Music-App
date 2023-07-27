import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Avicii2ElectricBoogaloo {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public Avicii2ElectricBoogaloo(int instrument, int volume) {

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
        combineLeftHandRightHand();
    }

    public void rightHandOctave5() throws InterruptedException
    {
        // block 1
        playNote("E5", 952);
        playNote("E5", 952);
        playNote("D#5", 714);
        playNote("E5", 1190);
        // block 2
        playNote("B5", 952);
        playNote("G#5", 952);
        playNote("F#5", 476);
        // block 3
        playNote("G#5", 238);
        playNote("E5", 1190);
        playNote("E5", 952);
        playNote("E5", 952);
        // block 4
        playNote("D#5", 714);
        playNote("E5", 1190);
        playNote("B5", 952);
        // block 5
        playNote("G#5", 952);
        playNote("F#5", 476);
        playNote("G#5", 238);
        playNote("E5", 476);
        playNote("C#5", 3808);
        // block 6
        playNote("C#5", 238);
        // block 7
    }

    public void rightHandOctave4() throws InterruptedException
    {
        // block 1
        playNote("E4", 952);
        playNote("E4", 952);
        playNote("D#4", 714);
        playNote("E4", 1190);
        // block 2
        playNote("B4", 952);
        playNote("G#4", 952);
        playNote("F#4", 476);
        // block 3
        playNote("G#4", 238);
        playNote("E4", 1190);
        playNote("E4", 952);
        playNote("E4", 952);
        // block 4
        playNote("D#4", 714);
        playNote("E4", 1190);
        playNote("B4", 952);
        // block 5
        playNote("G#4", 952);
        playNote("F#4", 476);
        playNote("G#4", 238);
        playNote("E4", 714);
        playNote("B4", 238);
        playNote("G#4", 238);
        playNote("F#4", 238);
        // block 6
        playNote("E4", 238);
        playNote("E4", 476);
        playNote("E4", 238);
        playNote("E4", 238);
        playNote("E4", 238);
        playNote("E4", 238);
        playNote("D#4", 238);
        playNote("D#4", 238);
        playNote("E4", 238);
        playNote("E4", 3570);
        // block 7
    }

    public void leftHandOctave3() throws InterruptedException
    {
        // block 1
        playNote("C#3", 952);
        playNote("E3", 2856);
        // block 2
        playNote("C#3", 952);
        playNote("E3", 2856);
        // block 3
        playNote("C#3", 952);
        playNote("E3", 2856);
        // block 4
        playNote("C#3", 952);
        // block 5
        playNote("E3", 2856);
        playNote("C#3", 238);
        // block 6
        playNote("C#3", 238);
        playNote("C#3", 476);
        playNote("E3", 238);
        playNote("E3", 238);
        playNote("E3", 238);
        playNote("E3", 2142);
        // block 7
    }

    public void leftHandOctave2() throws InterruptedException
    {
        // block 1
        playNote("C#2", 952);
        playNote("E2", 952);
        playNote("B2", 714);
        playNote("A2", 1190);
        // block 2
        playNote("C#2", 952);
        playNote("E2", 952);
        playNote("B2", 714);
        // block 3
        playNote("A2", 1190);
        playNote("C#2", 952);
        playNote("E2", 952);
        // block 4
        playNote("B2", 714);
        playNote("A2", 1190);
        playNote("C#2", 952);
        // block 5
        playNote("E2", 952);
        playNote("B2", 714);
        playNote("A2", 1190);
        playNote("C#2", 238);
        // block 6
        playNote("C#2", 238);
        playNote("C#2", 476);
        playNote("E2", 238);
        playNote("E2", 238);
        playNote("E2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("B2", 238);
        playNote("B2", 238);
        playNote("A2", 476);
        playNote("A2", 238);
        // block 7
    }



    public void combineLeftHandRightHand() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                rightHandOctave5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                rightHandOctave4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                leftHandOctave3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
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

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
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
