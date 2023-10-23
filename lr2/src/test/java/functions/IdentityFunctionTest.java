package functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IdentityFunctionTest {

    @org.junit.jupiter.api.Test
    public void testApply() {
        MathFunction IdentityFunction = new IdentityFunction();

        double result = IdentityFunction.apply(5.0);
        Assertions.assertEquals(5.0, result);

        result = IdentityFunction.apply(-3.0);
        Assertions.assertEquals(-3.0, result);

        result = IdentityFunction.apply(0.0);
        Assertions.assertEquals(0.0, result);
    }

    @Test
    public void testToString() {
        IdentityFunction identityFunc = new IdentityFunction();
        String result = identityFunc.toString();
        Assertions.assertEquals("IdentityFunction", result);
    }

    @Test
    public void testEquals() {
        IdentityFunction identityFunc1 = new IdentityFunction();
        IdentityFunction identityFunc2 = new IdentityFunction();
        Assertions.assertTrue(identityFunc1.equals(identityFunc2));
    }

    @Test
    public void testHashCode() {
        IdentityFunction identityFunc = new IdentityFunction();
        int hashCode = identityFunc.hashCode();
        Assertions.assertEquals(identityFunc.getClass().hashCode(), hashCode);
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        IdentityFunction identityFunc1 = new IdentityFunction();
        IdentityFunction identityFunc2 = (IdentityFunction) identityFunc1.clone();
        Assertions.assertEquals(identityFunc1, identityFunc2);
        Assertions.assertNotSame(identityFunc1, identityFunc2);
    }
}