package moreLessGame;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static moreLessGame.Utilities.StatesOfNumberChecking;

/**
 * The class provides check of input value, transfering it to model
 * and reception a result from model.
 */
public class Controller {
    private Model model;
    private View view;

    /**
     * Constructor of the class.
     * @param model an object of class Model.
     * @param view  an object of class View.
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method gets input number, transfer it to model, get a result from model
     * and continue, until the result will be that we found a hidden value.
     */
    void mainProcess() {
        InputStream source = System.in;
        Scanner scanner = new Scanner(source);

        view.printMessage(View.GREETING);

        int inputValue = inputValueUsingScanner(scanner);
        StatesOfNumberChecking resultOfCheckingFromModel = model.checkValue(inputValue);

        while (resultOfCheckingFromModel != StatesOfNumberChecking.INPUT_NUMBER_IS_GUESSED_NUMBER) {
            if (resultOfCheckingFromModel == StatesOfNumberChecking.INPUT_NUMBER_IS_OUT_OF_RANGE) {
                view.printMessageAndRange(View.INPUT_number_IS_OUT_OF_RANGE, model.getCurrentMinLimitOfRange(),
                        model.getCurrentMaxLimitOfRange());
            } else {
                view.printMessage(View.INPUT_NUMBER_IS_NOT_GUESSED_NUMBER);
                if (resultOfCheckingFromModel == StatesOfNumberChecking.GUESSED_NUMBER_IS_BIGGER) {
                    view.printMessage(View.GUESSED_NUMBER_IS_BIGGER);
                } else if (resultOfCheckingFromModel == StatesOfNumberChecking.GUESSED_NUMBER_IS_LESS) {
                    view.printMessage(View.GUESSED_NUMBER_IS_LESS);
                }
            }

            inputValue = inputValueUsingScanner(scanner);
            resultOfCheckingFromModel = model.checkValue(inputValue);
        }

        view.printMessageAndInt(View.CONGRATULATIONS, inputValue);
        ArrayList<Integer> allInputNumbers = model.getAllInputNumbers();
        view.printMessageAndInt(View.NUMBER_OF_ENTERED_NUMBERS, allInputNumbers.size());
        view.printMessageAndIntList(View.ENTERED_NUMBERS, allInputNumbers);
    }

    /**
     * Check input data from input stream and get an appropriate value.
     * @param scanner input stream.
     * @return an appropriate value.
     */
    private int inputValueUsingScanner(Scanner scanner) {
        view.printMessageAndRange(View.INPUT_INT_DATA_IN_RANGE, model.getCurrentMinLimitOfRange(),
                model.getCurrentMaxLimitOfRange());

        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA);
            view.printMessageAndRange(View.INPUT_INT_DATA_IN_RANGE, model.getCurrentMinLimitOfRange(),
                    model.getCurrentMaxLimitOfRange());
            scanner.next();
        }

        return scanner.nextInt();
    }
}
