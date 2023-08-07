package Display;
import MusicController.SongController;
import Piano.PianoKeyboard;
import Piano.TestPianoHighlight;
import Songs.*;

public class SongChoice {

    public static int INSTRUMENT_PIANO = 0;
    public static final int MY_VOLUME = 69;

    private static ScannerInput scannerInput = new ScannerInput();
    private static DisplaySong displaySong = new DisplaySong();

    public void chooseSong()
    {
        String input = scannerInput.userInput();
        int integerInput = Integer.parseInt(input) -1;

        SongController[] songController = new SongController[] {
                new AviciiLevels(INSTRUMENT_PIANO, MY_VOLUME),
                new AviciiWaitingForLove(INSTRUMENT_PIANO, MY_VOLUME),
                new MikuHatsuneSenbonzakura(INSTRUMENT_PIANO, MY_VOLUME),
                new TaylorSwiftLoveStory(INSTRUMENT_PIANO, MY_VOLUME),
                new DavidGuettaImGoodBlue(INSTRUMENT_PIANO, MY_VOLUME),
                new TestMusic(INSTRUMENT_PIANO, MY_VOLUME) };

        for (int i = 0; i < songController.length; i++)
        {
            if (integerInput == i)
            {
                displaySong.displaySong(input);
                SongController player = songController[i];
                player.run();
            }
        }
    }

}
