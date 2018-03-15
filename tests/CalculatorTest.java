import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @Test
    public void add() {
        int res = calc.Add(2, 5);

        assertEquals(res, 7);
    }

    @Test
    public void subtract() {
        int res = calc.Subtract(10, 5);

        assertEquals(res, 5);
    }

    @Test
    public void multiply() {
        int res = calc.Multiply(2, 5);

        assertEquals(res, 10);
    }

    @Test
    public void divide() {
        int res = calc.Divide(10, 2);

        assertEquals(res, 5);
    }
}