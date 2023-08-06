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
    protected static final String TEST_MUSIC = "Test Music";
    protected static final String MUSIC_PLAYER = "Music Player";



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
            TEST_MUSIC,
            MUSIC_PLAYER };





}
