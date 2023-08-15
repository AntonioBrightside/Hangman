package game;

import java.util.Scanner;

public class Text {

    public static final String[] HANGMAN = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public static String welcome = """
                    Добро пожаловать в игру 'Виселица'.
                    Я загадаю тебе случайное слово и предложу тебе 5 попыток, чтобы отгадать это слово.\s
                    У тебя есть возможность открывать слово по буквам. Если буква отсутствует в слове, то попытка считается неудачной.\s
                    Готов начать игру? ( да / нет)""";

    public static String wannaPlay = "Хотите сыграть еще раз? (да / нет)";

    /**
     * The method greets the user, tells him about the rules of the game and invites him to start (there is an option to close the application)
     */
    public static void welcomeChose() {
        Scanner textIn = new Scanner(System.in);
        System.out.print(welcome);
        String answer = textIn.next();

        if (answer.equalsIgnoreCase("да")) {
            System.out.println("И он решился начать игруууу");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        } else {
            System.out.println("Тогда увидимся в следующий раз");
            System.exit(0);
        }
    }

    /**
     * Returns a Boolean value and displays text on the screen depending on the answer to the question: "Will we play again?"
     */
    public static boolean playAgain() {
        Scanner textIn = new Scanner(System.in);
        System.out.print(wannaPlay);
        String answer = textIn.next();

        if (answer.equalsIgnoreCase("да")) {
            for (int i =0 ; i < 10; i++) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            return true;
        } else {
            System.out.println("Тогда увидимся в следующий раз");
            System.exit(0);
        }
        return false;
    }
}
