package game;

import java.util.Scanner;

public class Input {

    /**
     * Returns input the user's answer to the question "Choose a letter"
     */
    public static String letterChose() {
        Scanner textIn = new Scanner(System.in);
        System.out.print("Напиши букву из русского алфавита: ");

        return textIn.next();
    }

}
