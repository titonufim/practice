package functions;

import org.junit.jupiter.api.Test;

class IdentityFunctionTest {
    @Test
    public void testApply() {
    MathFunction IdentityFunction = new IdentityFunction();

        double result = IdentityFunction.apply(5.0);
        System.out.println(result + "expected: 5.0");

        result = IdentityFunction.apply(-3.0);
        System.out.println(result + "expected: -3.0");

        result = IdentityFunction.apply(0.0);
        System.out.println(result + "expected: 0");
    }
}