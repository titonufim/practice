package functions;

 abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected double[] xValues;
    protected double[] yValues;
    protected int count;

    protected AbstractTabulatedFunction(double[] xValues, double[] yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
        this.count = xValues.length;
    }

    protected int AbstractIndexOfX(double x) {
        if (x < xValues[0]) {
            return 0;
        }
        if (x > xValues[count - 1]) {
            return count;
        }
        for (int i = 0; i < count - 1; i++) {
            if (x >= xValues[i] && x <= xValues[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            return 0;
        }
        if (x > xValues[count - 1]) {
            return count - 1;
        }
        for (int i = 0; i < count - 1; i++) {
            if (x >= xValues[i] && x <= xValues[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX);
    }

    protected double extrapolateLeft(double x) {
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }

    protected double extrapolateRight(double x) {
        return interpolate(x, xValues[count - 2], xValues[count - 1], yValues[count - 2], yValues[count - 1]);
    }

    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, xValues[floorIndex], xValues[floorIndex + 1], yValues[floorIndex], yValues[floorIndex + 1]);
    }

    @Override
    public double apply(double x) {
        if (x < xValues[0]) {
            return extrapolateLeft(x);
        }
        if (x > xValues[count - 1]) {
            return extrapolateRight(x);
        }
        int index = indexOfX(x);
        if (index != -1) {
            return yValues[index];
        }
        int floorIndex = floorIndexOfX(x);
        return interpolate(x, floorIndex);
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return yValues[index];
    }

    @Override
    public int getCount() {
        return count;
    }
}