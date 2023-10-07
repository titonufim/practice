package functions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondFunctionTest {

    @Test
    public void testApply() {
        MathFunction secondFunction = new SecondFunction();

        double result1 = secondFunction.apply(0);
        Assertions.assertEquals(1, result1);

        double result2 = secondFunction.apply(Math.PI / 4);
        Assertions.assertEquals(2, result2, 0.0001);

        double result3 = secondFunction.apply(Math.PI / 2);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result3);

        double result4 = secondFunction.apply(-Math.PI / 3);
        Assertions.assertEquals(4, result4, 0.0001);
    }
}