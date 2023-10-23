package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstFunctionTest {
    @Test
    public void testApply() {
        MathFunction firstFunction = new SinFunction();

        double result = firstFunction.apply(0);
        Assertions.assertEquals(0, result);

        result = firstFunction.apply(Math.PI / 2);
        Assertions.assertEquals(1, result, 0.0001);

        result = firstFunction.apply(Math.PI);
        Assertions.assertEquals(0, result, 0.0001);

        result = firstFunction.apply(-Math.PI / 2);
        Assertions.assertEquals(-1, result, 0.0001);
    }
}