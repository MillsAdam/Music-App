import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

public class Avicii {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public Avicii (int instrument, int volume) {

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

    public void levels() throws InterruptedException {
        melody1();
        melody2();
        melody1();
        melody4();
        // repeat
        melody1();
        melody2();
        melody1();
        melody4();
        // chords
        chord1();
        chord2();
        chord3();
        chord4();
        // repeat
        chord1();
        chord2();
        chord3();
        chord4();
        // combo
        combineMelodyChord1();
        combineMelodyChord2();
        combineMelodyChord3();
        combineMelodyChord4();
        combineMelodyChord1();
        combineMelodyChord2();
        combineMelodyChord5();
        combineMelodyChord6();
        // repeat
        combineMelodyChord1();
        combineMelodyChord2();
        combineMelodyChord3();
        combineMelodyChord4();
        combineMelodyChord1();
        combineMelodyChord2();
        combineMelodyChord5();
        combineMelodyChord6();
    }

    public void melody1() throws InterruptedException {
        System.out.print("melody1:\t");
        playNote("F#4");
        playNote("E4");
        playNote("E4");
        rest(238);
        playNote("E4");
        playNote("E4");
        playNote("E4");
        playNote("E4");
        System.out.println();
    }

    public void melody2() throws InterruptedException {
        System.out.print("melody2:\t");
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

    public void melody4() throws InterruptedException {
        System.out.print("melody4:\t");
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

    public void chord1() throws InterruptedException {
        System.out.print("chord1:\t");
        playChord("C#3", "C#4", "E4", "G#4", 952); // 4/8 beat duration
        System.out.println();
    }

    public void chord2() throws InterruptedException {
        System.out.print("chord2:\t");
        playChord("E3", "B3", "E4", "G#4", 952); // 4/8 beat duration
        System.out.println();
    }

    public void chord3() throws InterruptedException {
        System.out.print("chord3:\t");
        playChord("B2", "B3", "D#3", "F#3", 714); // 3/8 beat duration
        System.out.println();
    }

    public void chord4() throws InterruptedException {
        System.out.print("chord4:\t");
        playChord("A2", "C#4", "E4", "A4", 1190); // 5/8 beat duration
        System.out.println();
    }



    public void combineMelodyChord1() throws InterruptedException {
        System.out.print("combo1:\t");
        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("F#4");
                playNote("E4");
                playNote("E4");
                rest(238);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("C#3", "C#4", "E4", "G#4", 952);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }

    public void combineMelodyChord2() throws InterruptedException {
        System.out.print("combo2:\t");
        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("E4");
                playNote("E4");
                playNote("E4");
                playNote("E4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("E3", "B3", "E4", "G#4", 952);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }

    public void combineMelodyChord3() throws InterruptedException {
        System.out.print("combo3:\t");

        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("D#4");
                playNote("D#4");
                playNote("E4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("B2", "B3", "D#3", "F#3", 714);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }

    public void combineMelodyChord4() throws InterruptedException {
        System.out.print("combo4:\t");

        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("E4");
                rest(238);
                playNote("C#5");
                playNote("B4");
                playNote("G#4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("A2", "C#4", "E4", "A4", 1190);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }

    public void combineMelodyChord5() throws InterruptedException {
        System.out.print("combo5:\t");

        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("C#4");
                playNote("C#4");
                playNote("B3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("B2", "B3", "D#3", "F#3", 714);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }

    public void combineMelodyChord6() throws InterruptedException {
        System.out.print("combo6:\t");

        // Create a thread for melody1 and chord1
        Thread thread1 = new Thread(() -> {
            try {
                playNote("B3");
                rest(238);
                playNote("C#5");
                playNote("B4");
                playNote("G#4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                playChord("A2", "C#4", "E4", "A4", 1190);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play melody1 and chord1 simultaneously
        thread2.start();
        thread1.start();

        // Wait for both threads to finish
        thread2.join();
        thread1.join();
        System.out.println();
    }



    // ********** playChord METHODS **********
    private void playChord(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException {
        System.out.print("\t\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t\t");
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
