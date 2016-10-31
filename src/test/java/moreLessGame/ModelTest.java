package moreLessGame;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static moreLessGame.Utilities.StatesOfNumberChecking;

public class ModelTest {
    @Test
    public void checkValueTestByOutOfRangeNumber() throws Exception {
        int minLimit = 0;
        int maxLimit = 100;
        Model model = new Model(minLimit, maxLimit);

        int appendixToMaxLimit = 10;
        StatesOfNumberChecking answerForNumberOutOfRange = model.checkValue(maxLimit + appendixToMaxLimit);
        assertEquals("Test failed: bad number is inside of range.", answerForNumberOutOfRange,
                StatesOfNumberChecking.INPUT_NUMBER_IS_OUT_OF_RANGE);
    }

    @Test
    public void checkValueTestByMinLimitInputNumber() throws Exception {
        int minLimit = 0;
        int maxLimit = 100;
        Model model = new Model(minLimit, maxLimit);

        StatesOfNumberChecking answerForMinLimit = model.checkValue(minLimit);
        assertTrue("Test failed with input number as minimum limit.",
                answerForMinLimit == StatesOfNumberChecking.INPUT_NUMBER_IS_GUESSED_NUMBER
                        || answerForMinLimit == StatesOfNumberChecking.GUESSED_NUMBER_IS_BIGGER);
    }

    @Test
    public void checkValueTestByMaxLimitInputNumber() throws Exception {
        int minLimit = 0;
        int maxLimit = 100;
        Model model = new Model(minLimit, maxLimit);

        StatesOfNumberChecking answerForMaxLimit = model.checkValue(maxLimit);

        assertTrue("Test failed with input number as maximum limit.",
                answerForMaxLimit == StatesOfNumberChecking.INPUT_NUMBER_IS_GUESSED_NUMBER
                        || answerForMaxLimit == StatesOfNumberChecking.GUESSED_NUMBER_IS_LESS);
    }

    @Test
    public void checkValueTestByGoodNumber() throws Exception {
        int minLimit = 0;
        int maxLimit = 100;
        Model model = new Model(minLimit, maxLimit);

        StatesOfNumberChecking answerForGoodNumber = model.checkValue(minLimit + 1);
        assertTrue("Test failed with good input number.",
                answerForGoodNumber == StatesOfNumberChecking.INPUT_NUMBER_IS_GUESSED_NUMBER
                        || answerForGoodNumber == StatesOfNumberChecking.GUESSED_NUMBER_IS_LESS
                        || answerForGoodNumber == StatesOfNumberChecking.GUESSED_NUMBER_IS_BIGGER);
    }
}