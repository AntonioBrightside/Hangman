package data;

import myArray.MyArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Words {

    private final static String path = "D:\\1. Other\\1. Work\\1. Programming\\1. Projects\\Hangman\\src\\data\\words.txt";
    private final static File file = new File(path);

    /**
     * Processes a list of words separated by a space and displays it in the console
     */
    public void showWords() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }

    /**
     * Returns the MyArrayList list of words.
     */
    public static MyArrayList getWords() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        MyArrayList array = new MyArrayList();
        while (scan.hasNext()) {
            array.add(scan.next());
        } return array;
    }

    /**
     * Returns a pseudo-random number in the range
     * @param min minimum allowed number (included)
     * @param max maximum allowed number (not included)
     */
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }

    /**
     * Returns the word that will need to be guessed
     */
    public static String getWord() throws FileNotFoundException {
        MyArrayList array = getWords();
        return array.getElement(getRandomNumber(0, array.getSize() - 1));
    }


}
