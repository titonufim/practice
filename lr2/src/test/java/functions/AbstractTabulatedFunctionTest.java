package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import functions.AbstractTabulatedFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractTabulatedFunctionTest {

    @Test
    public void testCheckLengthIsTheSame_LengthsDifferent() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0};

        assertThrows(DifferentLengthOfArraysException.class, () -> AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues));
    }

    @Test
    public void testCheckSorted_ArrayNotSorted() {
        double[] xValues = {3.0, 2.0, 1.0};

        assertThrows(ArrayIsNotSortedException.class, () -> AbstractTabulatedFunction.checkSorted(xValues));
    }
}
  