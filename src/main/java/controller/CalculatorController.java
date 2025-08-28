package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.CalculatorModel;

/**
 * The CalculatorController class handles the user interactions and updates the model and view accordingly.
 * It manages the calculator's operations, including number input, arithmetic operations, and result calculation.
 */
public class CalculatorController {

    private final CalculatorModel model = new CalculatorModel();
    private boolean newCalculation = true;

    @FXML
    private TextField resultField;

    @FXML
    private TextField calculationField;

    /**
     * Initializes the calculator by setting up the text fields and default values.
     */
    public void initialize() {
        resultField.setEditable(false);
        resultField.setAlignment(Pos.CENTER_RIGHT);
        calculationField.setEditable(false);
        calculationField.setAlignment(Pos.CENTER_RIGHT);
        resultField.setText("0");
    }

    /**
     * Handles the number button clicks and updates the result field accordingly.
     *
     * @param event The ActionEvent triggered by the button click.
     */
    public void Number(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();
        if (newCalculation || resultField.getText().equals("0") || resultField.getText().equals("Error")) {
            resultField.setText(number);
            newCalculation = false;
        } else {
            resultField.setText(resultField.getText() + number);
        }
    }

    /**
     * Operates the calculator based on the operator button clicked.
     *
     * @param event The ActionEvent triggered by the button click.
     */
    @FXML
    public void operation(ActionEvent event) {
        String op = ((Button) event.getSource()).getText();
        if (!resultField.getText().isEmpty() && !resultField.getText().equals("Error")) {
            try {
                double currentNumber = Double.parseDouble(resultField.getText());
                model.setFirstNumber(currentNumber);

                // Check if the result is an integer
                String displayNumber = (currentNumber == (int) currentNumber) ? String.valueOf((int) currentNumber) : String.valueOf(currentNumber);

                model.setOperator(op);
                calculationField.setText(displayNumber + " " + op);
                newCalculation = true;
            } catch (NumberFormatException e) {
                resultField.setText("Error");
                calculationField.setText("Error");
                newCalculation = true;
            }
        }
    }

    /**
     * Clears the calculator's fields and resets the model.
     */
    @FXML
    public void clear() {
        model.clear();
        resultField.setText("0");
        calculationField.clear();
        newCalculation = true;
        System.out.println("Clear button clicked");
    }

    /**
     * Handles the equal button click and performs the calculation.
     */
    @FXML
    public void calculate() {
        if (!model.getOperator().isEmpty()) {
            try {
                double secondNumber = Double.parseDouble(resultField.getText());
                double firstNumber = model.getFirstNumber();
                String operator = model.getOperator().toString();

                // Check if the second number is an integer
                if (operator.equals("÷")) {
                    model.setFirstNumber(firstNumber * 1.0); // Convert to double
                    model.setSecondNumber(secondNumber * 1.0); // Convert to double
                } else {
                    model.setSecondNumber(secondNumber);
                }

                double finalResult = model.calculate();
                String displaySecondNumber = (secondNumber == (int) secondNumber) ? String.valueOf((int) secondNumber) : String.valueOf(secondNumber);
                calculationField.setText(calculationField.getText() + " " + displaySecondNumber + " =");

                if (finalResult == (int) finalResult) {
                    resultField.setText(String.valueOf((int) finalResult));
                } else {
                    resultField.setText(String.valueOf(finalResult));
                }

                model.setFirstNumber(finalResult);
                model.setOperator("");
                newCalculation = true;
            } catch (NumberFormatException e) {
                resultField.setText("Error");
                calculationField.setText(calculationField.getText() + " Error");
                newCalculation = true;
            } catch (ArithmeticException e) {
                resultField.setText("Error: Division by zero");
                calculationField.setText(calculationField.getText() + " Error");
                newCalculation = true;
            }
        } else if (!resultField.getText().isEmpty() && !resultField.getText().equals("Error")) {
            // If no operator is set, just display the current number as the result
            calculationField.setText(resultField.getText() + " =");
            newCalculation = true;
        }
    }

}