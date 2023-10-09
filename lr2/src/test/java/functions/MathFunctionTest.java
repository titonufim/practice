package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionTest {

    @Test
    void testAndThen() {
        MathFunction addOne = x -> x + 1;
        MathFunction square = x -> x * x;

        MathFunction addOneAndSquare = addOne.andThen(square);

        double result = addOneAndSquare.apply(2);
        assertEquals(9, result);

        result = addOneAndSquare.apply(-3);
        assertEquals(4, result);

        MathFunction multiplyByTwo = x -> x * 2;
        MathFunction addFive = x -> x + 5;
        MathFunction subtractThree = x -> x - 3;

        MathFunction combinedFunction = multiplyByTwo.andThen(addFive).andThen(subtractThree);

        result = combinedFunction.apply(4);
        assertEquals(10, result);


        result = combinedFunction.apply(-2);
        assertEquals(-2, result);
    }
}