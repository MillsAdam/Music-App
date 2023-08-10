package MusicController;

import MusicController.MidiController;
// CHANGED
import Songs.TestMusic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SheetMusicReader {

    private MidiController midiController; // CHANGED = new MidiController();

    // CHANGED
    public void pathOne(TestMusic testMusic, SynthController controller) throws InterruptedException
    {
        // CHANGED
        this.midiController = new MidiController(testMusic, controller);
        midiController.rest(1000);
        int barCounter = 0;
        String[] files = {"src/main/java/SheetMusic/Avicii/WaitingForLove/WaitingForLovePathOne"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfPathArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfPathArray.add(splitLineText);
                }
                for (String[] txt : listOfPathArray)
                {
                    if (txt.length == 1)
                    {
                        barCounter++;
                        System.out.print("\nBar " + barCounter + ": ");
                    }
                    else if (txt.length == 2)
                    {
                        midiController.rest(Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 3)
                    {
                        midiController.playNote(txt[2], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 4)
                    {
                        midiController.playChord2(txt[2], txt[3], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 5)
                    {
                        midiController.playChord3(txt[2], txt[3], txt[4], Integer.parseInt(txt[0]));
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
        midiController.rest(1000);
    }

    // CHANGED
    public void pathTwo(TestMusic testMusic, SynthController controller) throws InterruptedException
    {
        // CHANGED
        this.midiController = new MidiController(testMusic, controller);
        midiController.rest(1000);
        String[] files = {"src/main/java/SheetMusic/Avicii/WaitingForLove/WaitingForLovePathTwo"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfPathArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfPathArray.add(splitLineText);
                }
                for (String[] txt : listOfPathArray)
                {
                    if (txt.length == 2)
                    {
                        midiController.rest(Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 3)
                    {
                        midiController.playNote(txt[2], Integer.parseInt(txt[0]));
                    }
                    else if (txt.length == 4)
                    {
                        midiController.playChord2(txt[2], txt[3], Integer.parseInt(txt[0])); // NullPointerException
                    }
                    else if (txt.length == 5)
                    {
                        midiController.playChord3(txt[2], txt[3], txt[4], Integer.parseInt(txt[0]));
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
        midiController.rest(1000);
    }

}
