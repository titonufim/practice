package concurrent;

import functions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {
    private final double[] xValues = {0, 1, 2};
    private final double[] yValues = {0, 1, 4};
    LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

    SynchronizedTabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);
    @Test
    public void testGetCount() {
        assertEquals(3, synchronizedFunction.getCount());
    }

    @Test
    public void testGetX() {
        assertEquals(1.0, synchronizedFunction.getX(1));
    }

    @Test
    public void testGetY() {
        assertEquals(4.0, synchronizedFunction.getY(2));
    }

    @Test
    public void testSetY() {
        synchronizedFunction.setY(0, 2.0);
        assertEquals(2.0, synchronizedFunction.getY(0));
    }

    @Test
    public void testLeftBound() {
        assertEquals(0.0, synchronizedFunction.leftBound());
    }

    @Test
    public void testRightBound() {
        assertEquals(2.0, synchronizedFunction.rightBound());
    }

    @Test
    public void testIndexOfX() {
        assertEquals(1, synchronizedFunction.indexOfX(1.0));
    }

    @Test
    public void testIndexOfY() {
        assertEquals(2, synchronizedFunction.indexOfY(4.0));
    }

    @Test
    public void testApply() {
        assertEquals(1.0, synchronizedFunction.apply(1.0));
    }

    @Test
    public void testIterator() {
        Iterator<Point> iterator = synchronizedFunction.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(new Point(0.0, 0.0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Point(1.0, 1.0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Point(2.0, 4.0), iterator.next());
        assertFalse(iterator.hasNext());
    }

    private TabulatedFunction createTabulatedFunction(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}