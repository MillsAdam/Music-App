package Display;

import java.util.Scanner;

public class ScannerInput {

    public static String userInput()
    {
        System.out.print(">>> ");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        return input;
    }
}
