package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class UnitFunctionTest {
    @Test
    public void unitFunctionTest() {
        MathFunction unitFunction = new UnitFunction();
        assertEquals(1, unitFunction.apply(20));
        assertEquals(1, unitFunction.apply(0));
    }
}