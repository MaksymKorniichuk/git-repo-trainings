package moreLessGame;

/**
 * Main class, that initializes and run program.
 */
public class Main {
    /**
     * Main method, that initializes and run program.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        // Initialization
        int minLimitOfRangeForModel = 0;
        int maxLimitOfRangeForModel = 100;
        Model model = new Model(minLimitOfRangeForModel, maxLimitOfRangeForModel);
        View view = new View();
        Controller controller = new Controller(model, view);

        // Run
        controller.mainProcess();
    }
}
