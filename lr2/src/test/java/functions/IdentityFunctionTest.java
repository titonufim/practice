package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdentityFunctionTest {

    @Test
    public void testApply() {
        MathFunction IdentityFunction = new IdentityFunction();

        double result = IdentityFunction.apply(5.0);
        Assertions.assertEquals(5.0, result);

        result = IdentityFunction.apply(-3.0);
        Assertions.assertEquals(-3.0, result);

        result = IdentityFunction.apply(0.0);
        Assertions.assertEquals(0.0, result);
    }
}