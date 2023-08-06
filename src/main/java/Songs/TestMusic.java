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
        synthController.openSynth();
    }

    public void run()
    {
        try {
            song();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        synthController.closeSynth();
    }

    public int getInstrument() {
        return instrument;
    }
    public int getVolume() {
        return volume;
    }


    public void song() throws InterruptedException
    {
        midiController.rest(1000);
        threadController.combineThread();
        System.out.println();
        midiController.rest(1000);
    }



}
