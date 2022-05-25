import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void add() {
        assertEquals(10, Calc.add(4, 6));
    }

    @Test
    void minus() {
        assertEquals(0, Calc.minus(10, 10));
    }

    @Test
    void multiply() {
        assertEquals(25, Calc.multiply(5, 5));
    }

    @Test
    void divide() {
        assertEquals(2, Calc.divide(10, 5));
    }

    @Test
    void integerDivide() {
        assertEquals(1, Calc.divide(9, 5));
    }

    @Test
    void divideThrow() {
        assertThrows(ArithmeticException.class, () -> Calc.divide(1, 0));
    }
}