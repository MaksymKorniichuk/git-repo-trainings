package moreLessGame;

import java.util.List;

/**
 * The class contains a texts constants and methods to communicate with user.
 */
public class View {
    // Text's constants
    static final String GREETING = "Welcome to our game \"More-Less\". We choose some number. " +
            "Now, try to guess it. Good luck.";
    static final String INPUT_INT_DATA_IN_RANGE = "Please, input integer number in range";
    static final String INPUT_NUMBER_IS_NOT_GUESSED_NUMBER = "Sorry, but we guessed another number.";
    static final String GUESSED_NUMBER_IS_BIGGER = "Our number is bigger.";
    static final String GUESSED_NUMBER_IS_LESS = "Our number is less.";
    static final String INPUT_number_IS_OUT_OF_RANGE = "Sorry, but your number is out of range [";
    static final String WRONG_INPUT_DATA = "You entered not an integer number.";
    static final String CONGRATULATIONS = "Congratulations !!! You guessed the number: ";
    static final String NUMBER_OF_ENTERED_NUMBERS = "The number of numbers you entered: ";
    static final String ENTERED_NUMBERS = "You entered next numbers:";

    /**
     * Printing a message in console.
     * @param message message, that printings.
     */
    void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Printing a message and value in console.
     * @param message message that printings.
     * @param value integer number that printings.
     */
    void printMessageAndInt(String message, int value) {
        System.out.println(message + value);
    }

    /**
     * Printing of message and integer`s range.
     * @param message message that printings.
     * @param minLimit minimum limit of printings range.
     * @param maxLimit maximum limit of printings range.
     */
    void printMessageAndRange(String message, int minLimit, int maxLimit) {
        System.out.println(message + " [" + minLimit + ", " + maxLimit + "]");
    }

    /**
     * Printing of message and list of integers.
     * @param message message that printings.
     * @param intsList list of integers that printings.
     */
    void printMessageAndIntList(String message, List<Integer> intsList){
        System.out.print(message + " ");
        for (Integer number: intsList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
