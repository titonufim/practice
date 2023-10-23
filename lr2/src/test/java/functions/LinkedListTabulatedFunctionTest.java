package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTabulatedFunctionTest {

    @Test
    public void testLinkedListTabulatedFunctionWithArrays() {
        double[] xValues = {0, 1, 2, 3};
        double[] yValues = {0, 1, 4, 9};
        LinkedListTabulatedFunction linkedListFunc = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(0.0, linkedListFunc.getY(0), 0.001);
        Assertions.assertEquals(1.0, linkedListFunc.getY(1), 0.001);
        Assertions.assertEquals(4.0, linkedListFunc.getY(2), 0.001);
        Assertions.assertEquals(9.0, linkedListFunc.getY(3), 0.001);
    }

    @Test
    public void testLinkedListTabulatedFunctionWithMathFunction() {
        MathFunction func = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * x;
            }
        };
        double xFrom = 0.0;
        double xTo = 3.0;
        int count = 4;
        LinkedListTabulatedFunction linkedListFunc = new LinkedListTabulatedFunction(func, xFrom, xTo, count);
        Assertions.assertEquals(0.0, linkedListFunc.getY(0), 0.001);
        Assertions.assertEquals(1.0, linkedListFunc.getY(1), 0.001);
        Assertions.assertEquals(4.0, linkedListFunc.getY(2), 0.001);
        Assertions.assertEquals(9.0, linkedListFunc.getY(3), 0.001);
    }
    @Test
    public void testGetCount() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(3, function.getCount());
    }

    @Test
    public void testLeftBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1.0, function.leftBound());
    }

    @Test
    public void testRightBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(3.0, function.rightBound());
    }

    @Test
    public void testGetX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(2.0, function.getX(1));
    }

    @Test
    public void testGetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(4.0, function.getY(1));
    }

    @Test
    public void testSetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        function.setY(1, 5.0);
        Assertions.assertEquals(5.0, function.getY(1));
    }

    @Test
    public void testIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1, function.indexOfX(2.0));
    }

    @Test
    public void testIndexOfY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(2, function.indexOfY(6.0));
    }

    @Test
    public void testFloorIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1, function.floorIndexOfX(2.5));
    }

    @Test
    public void testExtrapolateLeft() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(1.0, function.extrapolateLeft(0.5));
    }

    @Test
    public void testExtrapolateRight() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(8.0, function.extrapolateRight(4.0));
    }

    @Test
    public void testInterpolate() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        Assertions.assertEquals(5.0, function.interpolate(2.5, 1));
    }
}