package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayTabulatedFunctionTest {


    @Test
    public void testArrayTabulatedFunctionWithArrays() {
        double[] xValues = {0, 1, 2, 3};
        double[] yValues = {0, 1, 4, 9};
        ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(0.0, arrayFunc.getY(0), 0.001);
        Assertions.assertEquals(1.0, arrayFunc.getY(1), 0.001);
        Assertions.assertEquals(4.0, arrayFunc.getY(2), 0.001);
        Assertions.assertEquals(9.0, arrayFunc.getY(3), 0.001);
    }

    @Test
    public void testArrayTabulatedFunctionWithMathFunction() {
        MathFunction func = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * x;
            }
        };
        double xFrom = 0.0;
        double xTo = 3.0;
        int count = 4;
        ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(func, xFrom, xTo, count);
        Assertions.assertEquals(0.0, arrayFunc.getY(0), 0.001);
        Assertions.assertEquals(1.0, arrayFunc.getY(1), 0.001);
        Assertions.assertEquals(4.0, arrayFunc.getY(2), 0.001);
        Assertions.assertEquals(9.0, arrayFunc.getY(3), 0.001);
    }

    @Test
    public void testGetCount() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(3, function.getCount());
    }

    @Test
    public void testGetX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(2.0, function.getX(1));
    }

    @Test
    public void testGetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(4.0, function.getY(1));
    }

    @Test
    public void testSetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        function.setY(1, 5.0);
        Assertions.assertEquals(5.0, function.getY(1));
    }

    @Test
    public void testFloorIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1, function.floorIndexOfX(2.5));
    }

    @Test
    public void testExtrapolateLeft() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1.0, function.extrapolateLeft(0.5));
    }

    @Test
    public void testExtrapolateRight() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(8.0, function.extrapolateRight(4.0));
    }

    @Test
    public void testInterpolate() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(5.0, function.interpolate(2.5, 1));
    }

    @Test
    public void testLeftBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1.0, function.leftBound());
    }

    @Test
    public void testRightBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(3.0, function.rightBound());
    }

    @Test
    public void testIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1, function.indexOfX(2.0));
    }

    @Test
    public void testIndexOfY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(2, function.indexOfY(6.0));
    }
    @Test
    public void testToString() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        String expected = "[1.0, 2.0, 3.0]\n[2.0, 4.0, 6.0]";
        String actual = function.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        double[] xValues1 = {1.0, 2.0, 3.0};
        double[] yValues1 = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues1, yValues1);

        double[] xValues2 = {1.0, 2.0, 3.0};
        double[] yValues2 = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues2, yValues2);

        Assertions.assertEquals(function1.hashCode(), function2.hashCode());
    }

    @Test
    public void testEquals() {
        double[] xValues1 = {1.0, 2.0, 3.0};
        double[] yValues1 = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues1, yValues1);

        double[] xValues2 = {1.0, 2.0, 3.0};
        double[] yValues2 = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues2, yValues2);

        Assertions.assertTrue(function1.equals(function2));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        ArrayTabulatedFunction clone = (ArrayTabulatedFunction) function.clone();
        Assertions.assertNotSame(function, clone);
        for (int i = 0; i < xValues.length; ++i) {
            Assertions.assertEquals(xValues[i], clone.getX(i), 0.0);
            Assertions.assertEquals(yValues[i], clone.getY(i), 0.0);
        }
    }
}
