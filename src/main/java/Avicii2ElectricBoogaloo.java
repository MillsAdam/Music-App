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
        introMelodyOne();
        introMelodyTwo();
        introChordOne();
        introChordOne();
        combineIntroMelodyChordOne();
        verseMelodyOne();
        verseMelodyTwo();
        verseMelodyThree();
        verseMelodyFour();
        verseChordOne();
        verseChordTwo();
        combineVerseMelodyChordOne();
    }

    public void introMelodyOne() throws InterruptedException
    {
        // bar 1
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        // bar 2
        playNote("D#4");
        playNote("D#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("C#5");
        playNote("B4");
        playNote("G#4");
        System.out.println();
    }

    public void introMelodyTwo() throws InterruptedException
    {
        // bar 1
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        // bar 2
        playNote("C#4");
        playNote("C#4");
        playNote("B3");
        playNote("B3");
        rest(238);
        playNote("C#5");
        playNote("B4");
        playNote("G#4");
        System.out.println();
    }

    public void introChordOne() throws InterruptedException
    {
        // bar 1
        playChord("C#3", "C#4", "E4", "G#4", 952);
        // bar 2
        playChord("E3", "B3", "E4", "G#4", 952);
        // bar 3
        playChord("B2", "B3", "D#3", "F#3", 714);
        // bar 4
        playChord("A2", "C#4", "E4", "A4", 1190);
        System.out.println();
    }

    public void combineIntroMelodyChordOne() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                introChordOne();
                introChordOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                introMelodyOne();
                introMelodyTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        System.out.println();
    }

    public void verseMelodyOne() throws InterruptedException
    {
        playNote("G#5", 714);
        playNote("F#5", 952);
        playNote("E5", 238);
        playNote("C#5",1190);
        playNote("B4", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        System.out.println();
    }

    public void verseMelodyTwo() throws InterruptedException
    {
        playNote("C#5", 238);
        playNote("C#5", 476);
        rest(952);
        playNote("E4", 238);
        playNote("C#4", 476);
        rest(1428);
        System.out.println();
    }

    public void verseMelodyThree() throws InterruptedException
    {
        rest(476);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("B5", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("G#5", 238);
        playNote("C#6", 238);
        playNote("C#6", 119);
        playNote("B5", 238);
        playNote("B5", 119);
        playNote("G5", 119);
        playNote("F#5", 238);
        rest(119);
        playNote("F#5", 119);
        playNote("E5", 119);
        playNote("F#5", 238);
        playNote("C#5", 119);
        playNote("B4", 119);
        System.out.println();
    }

    public void verseMelodyFour() throws InterruptedException
    {
        playNote("C#4", 476);
        playNote("E4", 238);
        playNote("C4", 476);
        playNote("B4", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        playNote("C#5", 238);
        playNote("C#5", 476);
        playNote("E4", 238);
        playNote("C#4", 476);
        rest(476);
        System.out.println();
    }

    public void verseChordOne() throws InterruptedException
    {
        playChord("C#3", "C#4", "F#4", "G#4", 952);
        playChord("F3", "B3", "F4", "G#4", 952);
        playChord("B2", "B3", "D#4", "F#4", 714);
        playChord("A2", "C#4", "E4", "A4", 1190);
        System.out.println();
    }

    public void verseChordTwo() throws InterruptedException
    {
        playChord("C#3", "C#4", "F#4", "G#4", 952);
        playChord("F3", "B3", "F4", "G#4", 952);
        playChord("B2", "B3", "D#4", "F#4", 714);
        playChord("A2", "B3", "C#4", "E4", 1190);
        System.out.println();
    }

    public void combineVerseMelodyChordOne() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                verseChordOne();
                verseChordTwo();
                verseChordOne();
                verseChordTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                verseMelodyOne();
                verseMelodyTwo();
                verseMelodyThree();
                verseMelodyFour();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        System.out.println();
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
