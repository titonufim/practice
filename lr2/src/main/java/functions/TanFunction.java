package functions;

public class TanFunction implements MathFunction {
    @Override
    public double apply(double x)
    {
        return 1 + Math.pow(Math.tan(x), 2);
    }
}