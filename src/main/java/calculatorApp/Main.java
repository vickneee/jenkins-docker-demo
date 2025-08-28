package calculatorApp;

import view.CalculatorView;

public class Main {

    /**
     * The main method serves as the entry point for the JavaFX application.
     * It launches the CalculatorView class, which is responsible for the GUI.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        CalculatorView.launch(CalculatorView.class, args);
    }

}
