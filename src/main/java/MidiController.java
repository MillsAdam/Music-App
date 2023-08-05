import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiController {

    private NoteUtils noteUtils = new NoteUtils();
    private Synth synth = new Synth();


    public int getInstrument() {
        return instrument;
    }

    public int getVolume() {
        return volume;
    }

    private int instrument = 63;
    private int volume = 0;
    // musicPlayer.getVolume()
    // musicPlayer.getInstrument()


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
        int midiNote = noteUtils.getMidiNumber(note);

        synth.getChannels()[this.instrument].noteOn(midiNote, volume );
        Thread.sleep( durationMs );
        synth.getChannels()[this.instrument].noteOff(midiNote);
    }



    // ********** playChord METHODS **********
    public void playChord2(String note1, String note2, int durationMs) throws InterruptedException
    {
        System.out.print(note1 + " " + note2 + " ");
        playChord2(note1, note2, this.volume, durationMs);;
    }
    public void playChord2(String note1, String note2, int volume, int durationMs) throws InterruptedException
    {
        int[] midiNotes = {noteUtils.getMidiNumber(note1), noteUtils.getMidiNumber(note2)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOff(midiNote);
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
        int[] midiNotes = {noteUtils.getMidiNumber(note1), noteUtils.getMidiNumber(note2), noteUtils.getMidiNumber(note3)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOff(midiNote);
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
        int[] midiNotes = {noteUtils.getMidiNumber(note1), noteUtils.getMidiNumber(note2), noteUtils.getMidiNumber(note3), noteUtils.getMidiNumber(note4)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOn(midiNote, volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synth.getChannels()[this.instrument].noteOff(midiNote);
            }
        }
    }
}
