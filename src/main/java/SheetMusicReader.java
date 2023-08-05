import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SheetMusicReader {

    private MidiController midiController = new MidiController();

    public void rightHandTxt() throws InterruptedException
    {
        int rightBarCounter = 0;
        String[] files = {"src/main/java/SheetMusic/AviciiWaitingForLove/WaitingForLoveRight"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfRightHandArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfRightHandArray.add(splitLineText);
                }
                for (String[] txt : listOfRightHandArray)
                {
                    if (txt.length == 1)
                    {
                        rightBarCounter++;
                        System.out.print("\nBar " + rightBarCounter + ": ");
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
    }

    public void leftHandTxt() throws InterruptedException
    {
        String[] files = {"src/main/java/SheetMusic/AviciiWaitingForLove/WaitingForLoveLeft"};

        for (int i = 0; i < files.length; i++)
        {
            File filePath = new File (files[i]);
            List<String[]> listOfLeftHandArray = new ArrayList<>();

            try (Scanner fileScanner = new Scanner (filePath))
            {
                while (fileScanner.hasNextLine())
                {
                    String lineText = fileScanner.nextLine();
                    String[] splitLineText = lineText.split(" ");
                    listOfLeftHandArray.add(splitLineText);
                }
                for (String[] txt : listOfLeftHandArray)
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
    }

}
