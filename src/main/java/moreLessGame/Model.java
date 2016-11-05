package moreLessGame;

import java.util.ArrayList;
import java.util.Random;
import static moreLessGame.Utilities.StatesOfNumberChecking;

/**
 * The class calculate a random value in inputted range, get another value,
 * check its and return the result of its checking.
 * @author Maksym
 */
public class Model {
    private int currentMinLimitOfRange;
    private int currentMaxLimitOfRange;
    private ArrayList<Integer> allInputNumbers;

    private Integer hiddenIntNumber;

    /**
     * Constructor of the class.
     * @param basedMinLimitOfRange an integer representation of minimum limit of range
     *                             for hidden number.
     * @param basedMaxLimitOfRange an integer representation of maximum limit of range
     *                             for hidden number.
     */
    public Model(int basedMinLimitOfRange, int basedMaxLimitOfRange) {
        currentMaxLimitOfRange = basedMaxLimitOfRange;
        currentMinLimitOfRange = basedMinLimitOfRange;
        hiddenIntNumber = getNewRandomIntIncludingLimitValues(basedMinLimitOfRange, basedMaxLimitOfRange);
        allInputNumbers = new ArrayList<>();
    }

    /**
     * Comparison input value and hidden number.
     * @param inputValue an input integer value for checking.
     * @return an StatesOfNumberChecking object, that represent a state of current comparison.
     */
    public StatesOfNumberChecking checkValue(int inputValue) {
        allInputNumbers.add(inputValue);
        boolean inputValueIsInCurrentRange = inputValue >= currentMinLimitOfRange
                && inputValue <= currentMaxLimitOfRange;

        if (!inputValueIsInCurrentRange) {
            return StatesOfNumberChecking.INPUT_NUMBER_IS_OUT_OF_RANGE;
        }

        if (hiddenIntNumber > inputValue) {
            currentMinLimitOfRange = inputValue;
            return StatesOfNumberChecking.GUESSED_NUMBER_IS_BIGGER;
        }

        if (hiddenIntNumber < inputValue) {
            currentMaxLimitOfRange = inputValue;
            return StatesOfNumberChecking.GUESSED_NUMBER_IS_LESS;
        }

        // last variant: hiddenIntNumber.equals(inputValue)
        return StatesOfNumberChecking.INPUT_NUMBER_IS_GUESSED_NUMBER;
    }

    /**
     * Get minimum and maximum limits of range and calculate a randon integer number in
     * this range inclusive.
     * @param minLimitOfRange an integer minimum limit of range.
     * @param maxLimitOfRange an integer maximum limit of range.
     * @return an integer number in current range.
     */
    private int getNewRandomIntIncludingLimitValues(int minLimitOfRange, int maxLimitOfRange) {
        Random rand = new Random();
        return rand.nextInt(maxLimitOfRange - minLimitOfRange + 1) + minLimitOfRange;
    }

    /**
     * Return the current minimum limit of range.
     * @return current minimum limit of range.
     */
    public int getCurrentMinLimitOfRange() {
        return currentMinLimitOfRange;
    }

    /**
     * Return the current maximum limit of range.
     * @return current maximum limit of range.
     */
    public int getCurrentMaxLimitOfRange() {
        return currentMaxLimitOfRange;
    }

    /**
     * Return list of all input numbers.
     * @return list of all input numbers.
     */
    public ArrayList<Integer> getAllInputNumbers() {
        return allInputNumbers;
    }
}
