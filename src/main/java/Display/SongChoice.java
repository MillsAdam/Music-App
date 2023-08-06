package Display;
import Piano.PianoKeyboard;
import Piano.TestMusic;
import Songs.AviciiLevels;
import Songs.AviciiWaitingForLove;
import Songs.MikuHatsuneSenbonzakura;

public class SongChoice {

    public static int INSTRUMENT_PIANO = 0;
    public static int INSTRUMENT_FLUTE = 1; // ????????
    public static int INSTRUMENT_DRUM = 9;

    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 127;

    private static PianoKeyboard pianoKeyboard = new PianoKeyboard();
    private static ScannerInput scannerInput = new ScannerInput();

    public void chooseSong()
    {
        String input = scannerInput.userInput();

        if (input.equals("1"))
        {
            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
            AviciiLevels player = new AviciiLevels(INSTRUMENT_PIANO, volume);
            player.run();
        }
        else if (input.equals("2"))
        {
            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
            AviciiWaitingForLove player = new AviciiWaitingForLove(INSTRUMENT_PIANO, volume);
            player.run();
        }
        else if (input.equals("3"))
        {
            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
            MikuHatsuneSenbonzakura player = new MikuHatsuneSenbonzakura(INSTRUMENT_PIANO, volume);
            player.run();
        }
        else if (input.equals("4"))
        {
            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
            TestMusic player = new TestMusic(INSTRUMENT_PIANO, volume, pianoKeyboard);
            player.run();
        }
//        else if (input.equals("5"))
//        {
//            // Can't do shit because it's not in the main package
//            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
//            MusicPlayer player = new MusicPlayer(INSTRUMENT_PIANO, volume);
//            player.run();
//        }
    }


}
