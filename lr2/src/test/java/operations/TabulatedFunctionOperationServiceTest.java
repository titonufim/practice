package operations;

import static org.junit.Assert.*;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;
import operations.TabulatedFunctionOperationService;
import org.junit.Before;
import org.junit.Test;

public class TabulatedFunctionOperationServiceTest {
    private TabulatedFunctionOperationService operationService;

    @Before
    public void setUp() {
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        operationService = new TabulatedFunctionOperationService();
        operationService.setFactory(factory);
    }

    @Test
    public void testAsPoints() {
        TabulatedFunction function = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        Point[] expectedPoints = {new Point(1.0, 2.0), new Point(2.0, 4.0), new Point(3.0, 6.0)};
        Point[] actualPoints = operationService.asPoints(function);
        assertArrayEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testMultiplication() {
        TabulatedFunction function1 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0});
        TabulatedFunction expected = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{6.0, 8.0, 6.0});
        TabulatedFunction actual = operationService.multiplication(function1, function2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivision() {
        TabulatedFunction function1 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 2.0, 2.0});
        TabulatedFunction expected = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{1.0, 2.0, 3.0});
        TabulatedFunction actual = operationService.division(function1, function2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        TabulatedFunction function1 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0});
        TabulatedFunction expected = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{5.0, 6.0, 7.0});
        TabulatedFunction actual = operationService.add(function1, function2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        TabulatedFunction function1 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0});
        TabulatedFunction expected = operationService.getFactory().create(new double[]{1.0, 2.0, 3.0}, new double[]{-1.0, 2.0, 5.0});
        TabulatedFunction actual = operationService.subtract(function1, function2);
        assertEquals(expected, actual);
    }
    @Test
    public void testAddDifferentTypes() {
        TabulatedFunction function1 = new ArrayTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = new LinkedListTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0});
        TabulatedFunction expected = new ArrayTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{5.0, 6.0, 7.0});
        TabulatedFunction actual = operationService.add(function1, function2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractDifferentTypes() {
        TabulatedFunction function1 = new ArrayTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{2.0, 4.0, 6.0});
        TabulatedFunction function2 = new LinkedListTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0});
        TabulatedFunction expected = new ArrayTabulatedFunction(new double[]{1.0, 2.0, 3.0}, new double[]{-1.0, 2.0, 5.0});
        TabulatedFunction actual = operationService.subtract(function1, function2);
        assertEquals(expected, actual);
    }
}