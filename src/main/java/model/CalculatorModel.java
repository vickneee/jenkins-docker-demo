package model;

    /**
     * The CalculatorModel class represents the model of a simple calculator.
     * It handles the arithmetic operations and stores the numbers and operator.
     */
    public class CalculatorModel {

        private double firstNumber = 0;
        private double secondNumber = 0;
        private String operator = "";
        private double result = 0;

        /**
         * Sets the first number for the calculation.
         *
         * @param firstNumber The first number to set.
         */
        public void setFirstNumber(double firstNumber) {
            this.firstNumber = firstNumber;
        }

        /**
         * Sets the second number for the calculation.
         *
         * @param secondNumber The second number to set.
         */
        public void setSecondNumber(double secondNumber) {
            this.secondNumber = secondNumber;
        }

        /**
         * Gets the first number for the calculation.
         *
         * @return The first number.
         */
        public double getFirstNumber() {
            return firstNumber;
        }

        /**
         * Gets the second number for the calculation.
         *
         * @return The second number.
         */
        public double getSecondNumber() {
            return secondNumber;
        }

        /**
         * Sets the operator for the calculation.
         *
         * @param operator The operator to set.
         */
        public void setOperator(String operator) {
            this.operator = operator;
        }

        /**
         * Performs the calculation based on the operator and the two numbers.
         *
         * @return The result of the calculation.
         */
        public double calculate() {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "÷":
                    if (secondNumber == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result = firstNumber / secondNumber; // Floating-point division
                    break;
                default:
                    result = secondNumber; // If no operator is set, return the second number
            }
            return result;
        }

        /**
         * Returns the result of the last calculation.
         *
         * @return The result of the last calculation.
         */
        public double getResult() {
            return result;
        }

        /**
         * Clears the calculator model by resetting all fields to their default values.
         */
        public void clear() {
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
            result = 0;
        }

        /**
         * Returns the operator as a String.
         *
         * @return The operator as a String.
         */
        public String getOperator() {
            return operator;
        }

    }