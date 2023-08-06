package Display;

public class DisplayOptions {
    private static SongOptions songOptions = new SongOptions();

    public void displaySongs()
    {
        System.out.println("Please pick a song");
        System.out.println();

        for (int i = 0; i < songOptions.SONG_CHOICE_OPTIONS.length; i++)
        {
            int displayNumber = i + 1;
            System.out.println("(" + displayNumber + ") " + songOptions.SONG_CHOICE_OPTIONS[i]);
        }
    }
}
