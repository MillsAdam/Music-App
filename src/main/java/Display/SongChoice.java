package Display;
import Piano.PianoKeyboard;
import Piano.TestPianoHighlight;
import Songs.*;

public class SongChoice {

    public static int INSTRUMENT_PIANO = 0;
    public static int INSTRUMENT_FLUTE = 1; // ???????? I made this up
    public static int INSTRUMENT_DRUM = 9;

    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 127;
    public static final int MY_VOLUME = 69;

    private static PianoKeyboard pianoKeyboard = new PianoKeyboard();
    private static ScannerInput scannerInput = new ScannerInput();
    private static SongOptions songOptions = new SongOptions();
    private static DisplaySong displaySong = new DisplaySong();

    public void chooseSong()
    {
        String input = scannerInput.userInput();

//        int integerInput = Integer.parseInt(input);
//
//        for (Map.Entry<Integer, String> entry : songOptions.getSlotAndSong().entrySet())
//        {
//            if (integerInput == entry.getKey())
//            {
//
//            }
//        }



        if (input.equals("1"))
        {
            displaySong.displaySong(input);
            AviciiLevels player = new AviciiLevels(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
        else if (input.equals("2"))
        {
            displaySong.displaySong(input);
            AviciiWaitingForLove player = new AviciiWaitingForLove(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
        else if (input.equals("3"))
        {
            displaySong.displaySong(input);
            MikuHatsuneSenbonzakura player = new MikuHatsuneSenbonzakura(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
        else if (input.equals("4"))
        {
            displaySong.displaySong(input);
            TaylorSwiftLoveStory player = new TaylorSwiftLoveStory(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
        else if (input.equals("5"))
        {
            displaySong.displaySong(input);
            DavidGuettaImGoodBlue player = new DavidGuettaImGoodBlue(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
        else if (input.equals("6"))
        {
            displaySong.displaySong(input);
            TestPianoHighlight player = new TestPianoHighlight(INSTRUMENT_PIANO, MY_VOLUME, pianoKeyboard);
            player.run();
        }
        else if (input.equals("7"))
        {
            displaySong.displaySong(input);
            TestMusic player = new TestMusic(INSTRUMENT_PIANO, MY_VOLUME);
            player.run();
        }
    }


}
