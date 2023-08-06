import Display.DisplayOptions;
import Display.SongChoice;


public class App {

    private static DisplayOptions displayOptions = new DisplayOptions();
    private static SongChoice songChoice = new SongChoice();

    public static void main(String[] args)
    {
        displayOptions.displaySongs();
        songChoice.chooseSong();
    }
}
