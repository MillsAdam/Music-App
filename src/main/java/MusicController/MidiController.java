package MusicController;

import Songs.TestMusic;

public class MidiController {
    private NoteUtils noteUtils = new NoteUtils();
    private SynthController synthController = new SynthController();
    private TestMusic testMusic;


    public int getInstrument() {
        return instrument;
    }
    public int getVolume() {
        return volume;
    }
    private int instrument = 0;
    private int volume = 69; // DO I PUT testMusic.getVolume() here or should i completely remove instrument and volume from TestMusic
    // me thinks the latter



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

        synthController.getChannels()[this.instrument].noteOn(midiNote, this.volume);
        Thread.sleep( durationMs );
        synthController.getChannels()[this.instrument].noteOff(midiNote);
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
                synthController.getChannels()[this.instrument].noteOn(midiNote, this.volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synthController.getChannels()[this.instrument].noteOff(midiNote);
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
                synthController.getChannels()[this.instrument].noteOn(midiNote, this.volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synthController.getChannels()[this.instrument].noteOff(midiNote);
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
        int[] midiNotes = {noteUtils.getMidiNumber(note1), noteUtils.getMidiNumber(note2), noteUtils.getMidiNumber(note3), noteUtils.getMidiNumber(note4)};

        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synthController.getChannels()[this.instrument].noteOn(midiNote, this.volume);
            }
        }
        Thread.sleep(durationMs);
        for (int midiNote : midiNotes)
        {
            if (midiNote != -1)
            {
                synthController.getChannels()[this.instrument].noteOff(midiNote);
            }
        }
    }
}
