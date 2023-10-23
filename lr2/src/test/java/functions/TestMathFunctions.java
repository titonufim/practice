package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMathFunctions {

    @Test
    public void testCombiningTabulatedFunctions() {
        double[] xValues1 = {1.0, 2.0, 3.0};
        double[] yValues1 = {2.0, 4.0, 6.0};
        double[] xValues2 = {3.0, 4.0, 5.0};
        double[] yValues2 = {6.0, 8.0, 10.0};

        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues1, yValues1);
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues2, yValues2);

        int count = function1.getCount() + function2.getCount();
        double[] combinedXValues = new double[count];
        double[] combinedYValues = new double[count];

        int index = 0;
        for (int i = 0; i < function1.getCount(); i++) {
            combinedXValues[index] = function1.getX(i);
            combinedYValues[index] = function1.getY(i);
            index++;
        }
        for (int i = 0; i < function2.getCount(); i++) {
            combinedXValues[index] = function2.getX(i);
            combinedYValues[index] = function2.getY(i);
            index++;
        }

        ArrayTabulatedFunction combinedFunction = new ArrayTabulatedFunction(combinedXValues, combinedYValues);

        Assertions.assertEquals(8.0, combinedFunction.getY(4));
    }

    @Test
    public void testCombiningWithFunctions() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction tabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);

        MathFunction mathFunction = new SinFunction();

        int count = tabulatedFunction.getCount();
        double[] combinedXValues = new double[count];
        double[] combinedYValues = new double[count];

        for (int i = 0; i < count; i++) {
            combinedXValues[i] = tabulatedFunction.getX(i);
            combinedYValues[i] = mathFunction.apply(tabulatedFunction.getX(i));
        }

        ArrayTabulatedFunction combinedFunction = new ArrayTabulatedFunction(combinedXValues, combinedYValues);

        Assertions.assertEquals(Math.sin(2.0), combinedFunction.getY(1));
    }
}