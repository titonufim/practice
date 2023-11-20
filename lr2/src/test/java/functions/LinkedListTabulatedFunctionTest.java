package functions;

import exceptions.InterpolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTabulatedFunctionTest {

    @Test
    public void testNodeToString() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        String expected = "(1.0; 2.0)";
        String actual = node.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testNodeEquals() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(2.0, 3.0);

        assertEquals(node1, node2);
        Assertions.assertNotEquals(node1, node3);
    }

    @Test
    public void testNodeHashCode() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(2.0, 3.0);

        assertEquals(node1.hashCode(), node2.hashCode());
        Assertions.assertNotEquals(node1.hashCode(), node3.hashCode());
    }

    @Test
    public void testNodeClone() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.0, 2.0);
        LinkedListTabulatedFunction.Node cloneNode = (LinkedListTabulatedFunction.Node) node.clone();

        assertEquals(node.x, cloneNode.x);
        assertEquals(node.y, cloneNode.y);
        assertEquals(node.prev, cloneNode.prev);
        assertEquals(node.next, cloneNode.next);
    }
    @Test
    public void testLinkedListTabulatedFunctionWithArrays() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(4, function.getCount());
        assertEquals(0.0, function.getX(0), 0.0001);
        assertEquals(1.0, function.getY(1), 0.0001);
        assertEquals(9.0, function.getY(3), 0.0001);
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
        assertEquals(0.0, linkedListFunc.getY(0), 0.001);
        assertEquals(1.0, linkedListFunc.getY(1), 0.001);
        assertEquals(4.0, linkedListFunc.getY(2), 0.001);
        assertEquals(9.0, linkedListFunc.getY(3), 0.001);
    }
    @Test
    public void testGetCount() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(3, function.getCount());
    }

    @Test
    public void testLeftBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(1.0, function.leftBound());
    }

    @Test
    public void testRightBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(3.0, function.rightBound());
    }

    @Test
    public void testGetX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(2.0, function.getX(1));
    }

    @Test
    public void testGetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(4.0, function.getY(1));
    }

    @Test
    public void testSetY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        function.setY(1, 5.0);
        assertEquals(5.0, function.getY(1));
    }

    @Test
    public void testIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(1, function.indexOfX(2.0));
    }

    @Test
    public void testIndexOfY() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(2, function.indexOfY(6.0));
    }

    @Test
    public void testFloorIndexOfX() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(1, function.floorIndexOfX(2.5));
    }

    @Test
    public void testExtrapolateLeft() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(1.0, function.extrapolateLeft(0.5));
    }

    @Test
    public void testExtrapolateRight() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(8.0, function.extrapolateRight(4.0));
    }

    @Test
    public void testInterpolate() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(5.0, function.interpolate(2.5, 1));
    }

    @Test
    void testEquals() {
        double[] xValues1 = {1.0, 2.0, 3.0};
        double[] yValues1 = {4.0, 5.0, 6.0};
        LinkedListTabulatedFunction function1 = new LinkedListTabulatedFunction(xValues1, yValues1);

        double[] xValues2 = {1.0, 2.0, 3.0};
        double[] yValues2 = {4.0, 5.0, 6.0};
        LinkedListTabulatedFunction function2 = new LinkedListTabulatedFunction(xValues2, yValues2);

        assertEquals(function1, function2);
    }

    @Test
    void testHashCode() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {4.0, 5.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        int expectedHashCode = function.hashCode();
        assertEquals(expectedHashCode, function.hashCode());
    }

    @Test
    void testClone() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {4.0, 5.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        LinkedListTabulatedFunction clonedFunction = (LinkedListTabulatedFunction) function.clone();

        assertEquals(function, clonedFunction);
        Assertions.assertNotSame(function, clonedFunction);
    }

    @Test
    public void testConstructor_ArrayLengthLessThan2() {
        double[] xValues = {1.0};
        double[] yValues = {2.0};

        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(xValues, yValues));
    }

    @Test
    public void testConstructor_MathFunctionCountLessThan2() {
        MathFunction source = x -> x;
        double xFrom = 0.0;
        double xTo = 1.0;
        int count = 1;
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(source, xFrom, xTo, count));
    }

    @Test
    public void testFloorIndexOfX_XLessThanLeftBound() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertThrows(IllegalArgumentException.class, () -> function.floorIndexOfX(0.5));
    }

    @Test
    public void testInterpolate_UninterpolatedPeriod() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertThrows(InterpolationException.class, () -> function.interpolate(0.5, 0));
    }

    @Test
    public void testIterator_WhileLoop() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        Iterator<Point> iterator = function.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(xValues[count], point.x, 0.0001);
            assertEquals(yValues[count], point.y, 0.0001);
            count++;
        }
        assertEquals(xValues.length, count);
    }

    @Test
    public void testIterator_ForEachLoop() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        int count = 0;
        for (Point point : function) {
            assertEquals(xValues[count], point.x, 0.0001);
            assertEquals(yValues[count], point.y, 0.0001);
            count++;
        }
        assertEquals(xValues.length, count);
    }
}