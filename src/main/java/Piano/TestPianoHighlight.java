package Piano;

import MusicController.SongController;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/*
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html
 */
public class TestPianoHighlight implements SongController {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;

    public int getInstrument() {
        return instrument;
    }

    public int getVolume() {
        return volume;
    }

    int instrument;
    int volume;

    private PianoKeyboard pianoKeyboard;

    public TestPianoHighlight(int instrument, int volume, PianoKeyboard pianoKeyboard) {
        this.instrument = instrument;
        this.volume = volume;
        this.pianoKeyboard = pianoKeyboard;
    }

    public void run()
    {
        openSynth();
        try {
            System.out.println();
            System.out.println("********** Test Piano Highlight **********");
            System.out.println();
            playTest();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        closeSynth();
    }



    public void playTest() throws InterruptedException
    {
        new Thread(() -> {
            try {
                rest(1000);
                playNote("D3", 476);
                playNote("D4", 476);
                playNote("D5", 476);
                rest(476);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

//    public void playTest() throws InterruptedException
//    {
//        playNote("D3", 476);
//        playNote("D4", 476);
//        playNote("D5", 476);
//        rest(476);
//    }







    // ********** rest METHOD **********
    public static void rest(int durationMs) throws InterruptedException
    {
        System.out.print("rest " );
        Thread.sleep(durationMs);
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

        // set the currently played note in the Piano.PianoKeyboard
        pianoKeyboard.setCurrentNote(midiNote);
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
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t");
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
        int noteIndex = -1;

        for (int i = 0; i < notes.length; i++)
        {
            if (notes[i].equals(noteName))
            {
                noteIndex = 12 + (12 * octave) + i;
                break;
            }
        }
        return noteIndex;
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
