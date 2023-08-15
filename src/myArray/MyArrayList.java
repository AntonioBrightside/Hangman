package myArray;

import java.util.ArrayList;
import java.util.Objects;

public class MyArrayList {

    private String[] array = new String[10];
    private int size = 0;

    /**
     * Adds an item to the list
     * @param element added element of type <b>String</b>
     */
    public void add(String element) {
        array[size] = element;
        size++;

        if (array.length == size) {
            String[] newArray = new String[array.length * 2];

            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    /**
     * The method removes an item from the list
     * @param element deleted element of type <b>String</b>
     */
    public void remove(String element) {
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(array[i], element)) {
                array[i] = null;
                size--;
            } else {
                System.out.println("Такого элемента нет в списке");
            }
        }
    }

    /**
     * The method removes an item from the list
     * @param index deleted element of type <b>String</b>
     */
    public void remove(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null;
            size--;
        } else {
            System.out.println("Индекс за пределами списка");
        }
    }

    /**
     * Replace the element from the array
     * @param index under what index is the element being replaced
     * @param newElement what element are we replacing with
     */
    public void replaceElement(int index, String newElement) {
        if (index < size) {
            array[index] = newElement;
        }
    }

    /**
     * return the size of the array
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns an item from the list by index
     * @param index of the called element
     */
    public String getElement(int index) {
        if (index < size) {
            return array[index];
        } else {
            System.out.println("Индекс за рамками списка");
            return null;
        }
    }

    /**
     * Returns an array of indexes of found elements
     * @param element the desired element
     */
    public ArrayList<Integer> getIndex(String element) {
        ArrayList<Integer> newArray = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                newArray.add(i);
            }
        }
        return newArray;
    }

    /**
     * Does array content the element
     * @param element which we are looking for
     * @return true or false
     */
    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Outputs the entire array to the console
     */
    public void showList() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Clear the array
     */
    public void clearArray() {
        String[] array = new String[10];
        size = 0;
    }

}

