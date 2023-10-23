package functions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondFunctionTest {

    @Test
    public void testApply() {
        MathFunction secondFunction = new TanFunction();

        double result = secondFunction.apply(0);
        Assertions.assertEquals(1, result);

        result = secondFunction.apply(Math.PI / 4);
        Assertions.assertEquals(2, result, 0.0001);

        result = secondFunction.apply(Math.PI / 6);
        Assertions.assertEquals(1.3333, result, 0.0001);

        result = secondFunction.apply(-Math.PI / 3);
        Assertions.assertEquals(4, result, 0.0001);
    }
}