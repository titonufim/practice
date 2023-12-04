package operations;
import concurrent.SynchronizedTabulatedFunction;
import functions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TabulatedDifferentialOperatorTest {
    private final double[] xValues = {0, 1, 2};
    private final double[] yValues = {0, 1, 4};
    LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
    SynchronizedTabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);
    @Test
    public void testDeriveSynchronously() {
        TabulatedFunction derivedFunction = new TabulatedDifferentialOperator().deriveSynchronously(function);
        assertEquals(new ArrayTabulatedFunction(new double[]{0, 1, 2}, new double[]{1, 3, 3}), derivedFunction);
    }
}