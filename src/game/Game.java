package game;

import myArray.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game {

    public final String word;
    public MyArrayList myArrayWord = new MyArrayList();
    public MyArrayList guessedWord = new MyArrayList();
    private int mistakes = 0;
    private HashSet<String> usedLetters = new HashSet<>();
    private static final String ABC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public boolean game = true;

    /**
     * Game Initializer
     * @param word the word that will be made up
     */
    public Game(String word) {
        this.word = word;

        String[] arrayWord = word.split("");
        for (String s : arrayWord) {
            myArrayWord.add(s);
        }

        for (int i = 0; i < this.word.length(); i++) {
            guessedWord.add("*");
        }
    }

    /**
     * Displays the current result of guessing the word
     */
    public void showGuessedWord() {
        for (int i = 0; i < word.length(); i++) {
            System.out.print(guessedWord.getElement(i));
        }
    }

    /**
     * Returns the number of errors committed
     */
    public int getMistakes() {
        return mistakes;
    }

    /**
     * Returns the status of the game (true/false)
     */
    public boolean gameStatus() {return game;}

    //Выводит количество оставшихся попыток
    public void textMistakes() {
        int MAX_MISTAKES = 5;
        System.out.println("Осталось попыток: " + (MAX_MISTAKES - mistakes));
        System.out.print("СЛОВО: ");
        showGuessedWord();
        System.out.println("\n");
    }

    /**
     * Displays text messages that the letter is in the word
     * @param letter from the user
     */
    private void guessedLetter(String letter) {
        System.out.println("Такая буква есть в этом слове. Откройте же эту букву '" + letter.toUpperCase() + "'");
        System.out.print("СЛОВО: ");
        showGuessedWord();
        System.out.println("\n");
    }

    /**
     * Check the status of the game - whether user guessed the word or exceeded the number of errors
     */
    private void checkStatus() {
        if (mistakes == 5) {
            System.out.println("Количество попыток закончилось. Game Over, так сказать..." +
                    "Загаданное слово - " + word);
        }

        if (!guessedWord.contains("*")) {
            System.out.println("Надо же...ты угадал. В следующий раз я загадаю слово посложнее");
            game = false;
        }
    }

    /**
     * The user selects a letter and gets the result
     * @param letter from user
     */
    public void guessLetter(String letter) {
        if (Arrays.asList(ABC.split("")).contains(letter.toLowerCase())
                && !usedLetters.contains(letter)) {

            ArrayList<Integer> listIndex = myArrayWord.getIndex(letter);
            if (listIndex.isEmpty()) {
                System.out.printf("Буквы '%s' нет в этом слове\n", letter.toUpperCase());
                mistakes++;
                System.out.println(Text.HANGMAN[mistakes]);
                textMistakes();
            } else {
                for (int s : listIndex) {
                    guessedWord.replaceElement(s, letter);
                }
                guessedLetter(letter);
            }
            usedLetters.add(letter);
            checkStatus();

        } else {
            System.out.println("Такой буквы в русском языке не существует или такую букву уже ранее выбирали. Выбирай другую букву\n");
        }
    }

}
