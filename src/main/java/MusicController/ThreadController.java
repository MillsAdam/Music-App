package MusicController;

// CHANGED
import Songs.TestMusic;


public class ThreadController {

    private SheetMusicReader sheetMusicReader = new SheetMusicReader();

    // CHANGED
    public void combineThread(TestMusic testMusic, SynthController controller) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                sheetMusicReader.pathOne(testMusic, controller); // CHANGED
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                sheetMusicReader.pathTwo(testMusic, controller); // CHANGED
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
