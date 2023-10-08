package functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ZeroFunctionTest {
    @Test
    public void zeroFunctionTest() {
        MathFunction zeroFunction = new ZeroFunction();
        assertEquals(0, zeroFunction.apply(10));
        assertEquals(0, zeroFunction.apply(0));
    }
}