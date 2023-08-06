public class MusicPlayer {

    private int instrument;
    private int volume;
    private SynthController synthController = new SynthController();
    private SheetMusicReader sheetMusicReader = new SheetMusicReader();
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
        combineThread();
        System.out.println();
        midiController.rest(1000);
    }


    public void combineThread() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                sheetMusicReader.pathOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                sheetMusicReader.pathTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play simultaneously
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }


}
