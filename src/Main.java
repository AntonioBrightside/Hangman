import data.Words;
import game.Game;
import game.Input;
import game.Text;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Greeting. The user agrees to start the game
        Text.welcomeChose();

        boolean play = true;
        while (play) {

            // Initializing the game
            Game game = new Game(Words.getWord());

            // The cycle of the main program
            while (game.getMistakes() < 5 && game.gameStatus()) {
                game.guessLetter(Input.letterChose());
            }

            // Do we play or go away?
            play = Text.playAgain();
        }
    }
}


