package functions;
public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected abstract int floorIndexOfX(double x);
    protected abstract double extrapolateLeft(double x);
    protected abstract double extrapolateRight(double x);
    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + ((x - leftX) / (rightX - leftX)) * (rightY - leftY);
    }

    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else {
            int floorIndex = floorIndexOfX(x);
            if (floorIndex != -1) {
                return interpolate(x, floorIndex);
            } else {
                int index = indexOfX(x);
                if (index != -1) {
                    return getY(index);
                } else {
                    return interpolate(x, floorIndexOfX(x));
                }
            }
        }
    }
}
