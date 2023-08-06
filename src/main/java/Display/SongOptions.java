package Display;

import Songs.AviciiLevels;
import Songs.AviciiWaitingForLove;
import Songs.MikuHatsuneSenbonzakura;

import java.util.HashMap;
import java.util.Map;

public class SongOptions {
    protected static final String AVICII_LEVELS = "Avicii - Levels";
    protected static final String AVICII_WAITING_FOR_LOVE = "Avicii - Waiting For Love";
    protected static final String MIKU_HATSUNE_SENBONZAKURA = "Miku Hatsune - Senbonzakura";
    protected static final String TAYLOR_SWIFT_LOVE_STORY = "Taylor Swift - Love Story";
    protected static final String DAVID_GUETTA_IM_GOOD_BLUE = "David Guetta - I'm Good (Blue)";
    protected static final String TEST_PIANO_HIGHLIGHT = "Test Piano Highlight";
    protected static final String TEST_MUSIC = "Test Music";



    public Map<Integer, String> getSlotAndSong() {
        return slotAndSong;
    }

    protected Map<Integer, String> slotAndSong = new HashMap<>();

    private void populateSlotAndSong()
        {
        for (int i = 0; i < SONG_CHOICE_OPTIONS.length; i++)
        {
            slotAndSong.put(i + 1, SONG_CHOICE_OPTIONS[i]);
        }
    }


    protected static final String[] SONG_CHOICE_OPTIONS = {
            AVICII_LEVELS,
            AVICII_WAITING_FOR_LOVE,
            MIKU_HATSUNE_SENBONZAKURA,
            TAYLOR_SWIFT_LOVE_STORY,
            DAVID_GUETTA_IM_GOOD_BLUE,
            TEST_PIANO_HIGHLIGHT,
            TEST_MUSIC };





}
