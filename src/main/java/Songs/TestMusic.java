package Songs;

import MusicController.MidiController;
import MusicController.SongController;
import MusicController.ThreadController;
import MusicController.SynthController;

public class TestMusic implements SongController {

    private int instrument;
    private int volume;
    private SynthController synthController = new SynthController();
    private ThreadController threadController = new ThreadController();
    private MidiController midiController = new MidiController();


    public TestMusic(int instrument, int volume) {
        this.instrument = instrument;
        this.volume = volume;
    }

    public void run()
    {
        synthController.openSynth();
        try {
            song();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        synthController.closeSynth();
    }

    public void song() throws InterruptedException
    {
        threadController.combineThread();
        System.out.println();
    }


    public int getInstrument() {
        return instrument;
    }
    public int getVolume() {
        return volume;
    }

    public void setInstrument(int instrument)
    {
        this.instrument = instrument;
    }
    public void setVolume(int volume)
    {
        this.volume = volume;
    }





}
