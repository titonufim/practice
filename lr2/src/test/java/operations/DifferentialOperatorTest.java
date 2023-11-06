package operations;

import functions.MathFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DifferentialOperatorTest {
    @Test
    public void testLeftDerive_SqrFunction() {
        double step = 0.01;
        SteppingDifferentialOperator operator = new LeftSteppingDifferentialOperator(step);
        MathFunction function = new SqrFunction(); // f(x) = x^2

        MathFunction derivative = operator.derive(function);

        assertEquals(1.99, derivative.apply(1), 0.01);
        assertEquals(3.99, derivative.apply(2), 0.01);
        assertEquals(5.99, derivative.apply(3), 0.01);
    }

    @Test
    public void testRigjtDerive_SqrFunction() {
        double step = 0.01;
        SteppingDifferentialOperator operator = new RightSteppingDifferentialOperator(step);
        MathFunction function = new SqrFunction(); // f(x) = x^2

        MathFunction derivative = operator.derive(function);

        assertEquals(2.01, derivative.apply(1), 0.01);
        assertEquals(4.01, derivative.apply(2), 0.01);
        assertEquals(6.01, derivative.apply(3), 0.01);
    }
    @Test
    public void testMiddleDerive_SqrFunction() {
        double step = 0.01;
        SteppingDifferentialOperator operator = new MiddleSteppingDifferentialOperator(step);
        MathFunction function = new SqrFunction(); // f(x) = x^2

        MathFunction derivative = operator.derive(function);

        assertEquals(1.99, derivative.apply(1), 0.01);
        assertEquals(3.99, derivative.apply(2), 0.01);
        assertEquals(5.99, derivative.apply(3), 0.01);
    }
}