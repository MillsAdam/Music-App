package Display;

public class DisplaySong {

    private static SongOptions songOptions = new SongOptions();

    public void displaySong(String input)
    {
        int integerInput = Integer.parseInt(input) -1;
        System.out.println();
        System.out.println("********* " + songOptions.SONG_CHOICE_OPTIONS[integerInput].toUpperCase() + " **********");
        System.out.println();
    }
}
