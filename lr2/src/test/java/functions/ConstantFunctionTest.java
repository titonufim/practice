package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ConstantFunctionTest {
    @Test
    public void constantFunctionTest() {
        MathFunction constantFunction = new ConstantFunction(5);
        assertEquals(5, constantFunction.apply(2));
        assertEquals(5, constantFunction.apply(10));
    }
}