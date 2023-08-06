package MusicController;

public class ThreadController {

    private SheetMusicReader sheetMusicReader = new SheetMusicReader();

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
