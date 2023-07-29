import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class Test {
//
//    private List<String[]> rightHandOctave6Array = new ArrayList<>();
//    private List<String[]> rightHandOctave5Array = new ArrayList<>();
//
//    public void setRightHandOctave6Array(List<String[]> rightHandOctave6Array) {
//        this.rightHandOctave6Array = rightHandOctave6Array;
//    }
//
//    public void setRightHandOctave5Array(List<String[]> rightHandOctave5Array) {
//        this.rightHandOctave5Array = rightHandOctave5Array;
//    }
//
//    public Test() {
//        getRightHandOctave5Array();
//        getRightHandOctave6Array();
//    }
//
//
//    public void getRightHandOctave6Array()
//    {
//        File filePath = new File ("RightHand6.txt");
//        try (Scanner fileScanner = new Scanner (filePath))
//        {
//            while (fileScanner.hasNextLine())
//            {
//                String lineText = fileScanner.nextLine();
//                String[] splitLineText = lineText.split(" ");
//                rightHandOctave6Array.add(splitLineText);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        for (String[] noteDuration : rightHandOctave6Array)
//        {
//            System.out.println(noteDuration[0] + " " + noteDuration[1]);
//        }
//    }
//
//    public void getRightHandOctave5Array()
//    {
//        File filePath = new File ("RightHand5.txt");
//        try (Scanner fileScanner = new Scanner (filePath))
//        {
//            while (fileScanner.hasNextLine())
//            {
//                String lineText = fileScanner.nextLine();
//                String[] splitLineText = lineText.split(" ");
//                rightHandOctave5Array.add(splitLineText);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        for (String[] noteDuration : rightHandOctave5Array)
//        {
//            System.out.println(noteDuration[0] + " " + noteDuration[1]);
//        }
//    }
//
//    public static void main (String[] args) {
//        new Test();
//    }
//}
