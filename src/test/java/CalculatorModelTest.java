import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.CalculatorModel;

class CalculatorModelTest {

    @Test
    void testAddition() {
        CalculatorModel calc = new CalculatorModel();
        calc.setFirstNumber(2);
        calc.setSecondNumber(3);
        calc.setOperator("+");
        assertEquals(5, calc.calculate());
    }

    @Test
    void testSubtraction() {
        CalculatorModel calc = new CalculatorModel();
        calc.setFirstNumber(5);
        calc.setSecondNumber(2);
        calc.setOperator("-");
        assertEquals(3, calc.calculate());
    }

    @Test
    void testMultiplication() {
        CalculatorModel calc = new CalculatorModel();
        calc.setFirstNumber(2);
        calc.setSecondNumber(3);
        calc.setOperator("×");
        assertEquals(6, calc.calculate());
    }

    @Test
    void testDivision() {
        CalculatorModel calc = new CalculatorModel();
        calc.setFirstNumber(6);
        calc.setSecondNumber(3);
        calc.setOperator("÷");
        assertEquals(2, calc.calculate());
    }

    @Test
    void testDivisionByZero() {
        CalculatorModel calc = new CalculatorModel();
        calc.setFirstNumber(6);
        calc.setSecondNumber(0);
        calc.setOperator("÷");
        assertThrows(ArithmeticException.class, calc::calculate);
    }
}