package functions;

public class secondFunction implements MathFunction {
    @Override
    public double apply(double x)
    {
        return 1 + Math.pow(Math.tan(x), 2);
    }
}