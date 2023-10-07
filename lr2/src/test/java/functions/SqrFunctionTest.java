package functions;

import org.junit.jupiter.api.Test;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        MathFunction sqrFunction = new SqrFunction();

        double result = sqrFunction.apply(5.0);
        System.out.println(result + "expected: 25");

        result = sqrFunction.apply(-3.0);
        System.out.println(result + "expected: 9");

        result = sqrFunction.apply(0.0);
        System.out.println(result + "expected: 0");
    }
}