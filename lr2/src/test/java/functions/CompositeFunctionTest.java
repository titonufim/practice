package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompositeFunctionTest {

    @Test
    public void testApply() {

        MathFunction firstFunction = new firstFunction();

        MathFunction secondFunction = new secondFunction();

        CompositeFunction compositeFunction = new CompositeFunction(firstFunction, secondFunction);

        double result = compositeFunction.apply(0.5);
        Assertions.assertEquals(1.2679, result, 0.0001);

        result = compositeFunction.apply(1);
        Assertions.assertEquals(2.2520, result, 0.0001);

        result = compositeFunction.apply(Math.PI);
        Assertions.assertEquals(1, result, 0.0001);

    }

}