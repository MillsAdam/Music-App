import Utilities.SynthController;

public class MusicPlayer {

    private int instrument;
    private int volume;
    private SynthController synthController = new SynthController();
    private Threads threads = new Threads();
    private MidiController midiController = new MidiController();

    public MusicPlayer(int instrument, int volume) {
        this.instrument = instrument;
        this.volume = volume;
        synthController.openSynth();
    }

    public void run()
    {
        try {
            System.out.println();
            System.out.println("********** AVICII - WAITING FOR LOVE **********");
            System.out.println();
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
        threads.combineThread();
        System.out.println();
        midiController.rest(1000);
    }



}
