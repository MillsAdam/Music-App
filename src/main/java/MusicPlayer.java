public class MusicPlayer {

    private int instrument;
    private int volume;
    private MidiController midiController = new MidiController();
    private SheetMusicReader sheetMusicReader = new SheetMusicReader();

    public MusicPlayer(int instrument, int volume) {
        this.instrument = instrument;
        this.volume = volume;
        midiController.openSynth();
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

        midiController.closeSynth();
    }

    public int getVolume()
    {
        return this.volume;
    }

    public int getInstrument()
    {
        return this.instrument;
    }

    public void musicPlayer() throws InterruptedException
    {
        combineLeftHandRightHand();
        midiController.rest(476);
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
