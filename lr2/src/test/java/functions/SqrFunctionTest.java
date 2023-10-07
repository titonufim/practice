package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        MathFunction sqrFunction = new SqrFunction();

        double result = sqrFunction.apply(5.0);
        Assertions.assertEquals(25.0, result);

        result = sqrFunction.apply(-3.0);
        Assertions.assertEquals(9.0, result);

        result = sqrFunction.apply(0.0);
        Assertions.assertEquals(0.0, result);
    }
}