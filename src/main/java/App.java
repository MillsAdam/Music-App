import Piano.PianoKeyboard;
import Piano.TestMusic;
import Songs.AviciiLevels;
import Songs.AviciiWaitingForLove;
import Songs.MikuHatsuneSenbonzakura;

import java.util.Scanner;

public class App {

    public static int INSTRUMENT_PIANO = 0;
    public static int INSTRUMENT_FLUTE = 1; // ????????
    public static int INSTRUMENT_DRUM = 9;

    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 127;

    public static void main(String[] args) {

        PianoKeyboard pianoKeyboard = new PianoKeyboard();

        System.out.println("Please pick a song:");
        System.out.println("(1) Avicii - Levels");
        System.out.println("(2) Avicii - Waiting For Love");
        System.out.println("(3) Miku Hatsune - Senbonzakura");
        System.out.println("(4) Test Music");
        System.out.println("(5) Music Player");
        System.out.print(">>> ");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
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
        else if (input.equals("5"))
        {
            int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
            MusicPlayer player = new MusicPlayer(INSTRUMENT_PIANO, volume);
            player.run();
        }





    }
}
