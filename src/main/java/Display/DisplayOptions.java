package Display;

public class DisplayOptions {
    private static SongOptions songOptions = new SongOptions();

    private static final String[] SONG_CHOICE_OPTIONS = {
            songOptions.AVICII_LEVELS,
            songOptions.AVICII_WAITING_FOR_LOVE,
            songOptions.MIKU_HATSUNE_SENBONZAKURA,
            songOptions.TEST_MUSIC,
            songOptions.MUSIC_PLAYER };

    public void displaySongs()
    {
        for (int i = 0; i < SONG_CHOICE_OPTIONS.length; i++)
        {
            int displayNumber = i + 1;
            System.out.println("(" + displayNumber + ") " + SONG_CHOICE_OPTIONS[i]);
        }
    }
}
