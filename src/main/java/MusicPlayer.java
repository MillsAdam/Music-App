public class MusicPlayer {

    private int instrument;
    private int volume;
    private Synth synth = new Synth();
    private SheetMusicReader sheetMusicReader = new SheetMusicReader();
    private MidiController midiController = new MidiController();

    public MusicPlayer() {
        this.instrument = midiController.getInstrument();
        this.volume = midiController.getVolume();
        synth.openSynth();
    }

    public void run()
    {
        try {
            System.out.println();
            System.out.println("********** AVICII - WAITING FOR LOVE **********");
            System.out.println();
            musicPlayer();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        synth.closeSynth();
    }


    public void musicPlayer() throws InterruptedException
    {
        combineLeftHandRightHand();
    }


    public void combineLeftHandRightHand() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                sheetMusicReader.rightHandTxt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                sheetMusicReader.leftHandTxt();
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
