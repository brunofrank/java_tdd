import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BetterCalculatorTest {
    BetterCalculator calculator;

    @Before
    public void setUp() throws Exception {
        this.calculator = new BetterCalculator();
    }

    @Test
    public void testPressEquals(){
        calculator.enter(2);
        calculator.PressPlus();
        calculator.enter(2);
        calculator.pressEquals();
        assertTrue(calculator.getDisplay() == 4);
    }
}