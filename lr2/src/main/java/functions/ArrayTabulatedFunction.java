package functions;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Cloneable {
    private final double[] xValues;
    private final double[] yValues;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        this.xValues = Arrays.copyOf(xValues, xValues.length);
        this.yValues = Arrays.copyOf(yValues, yValues.length);
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        this.xValues = new double[count];
        this.yValues = new double[count];
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            double x = xFrom + i * step;
            this.xValues[i] = x;
            this.yValues[i] = source.apply(x);
        }
    }

    @Override
    public int getCount() {
        return xValues.length;
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
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    public void setX(int index, double value) {
        xValues[index] = value;
    }
    @Override
    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            return -1;
        }
        for (int i = 0; i < xValues.length - 1; i++) {
            if (x >= xValues[i] && x <= xValues[i + 1]) {
                return i;
            }
        }
        return xValues.length - 1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        double x0 = xValues[0];
        double x1 = xValues[1];
        double y0 = yValues[0];
        double y1 = yValues[1];
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double extrapolateRight(double x) {
        double x0 = xValues[xValues.length - 2];
        double x1 = xValues[xValues.length - 1];
        double y0 = yValues[yValues.length - 2];
        double y1 = yValues[yValues.length - 1];
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        double x0 = xValues[floorIndex];
        double x1 = xValues[floorIndex + 1];
        double y0 = yValues[floorIndex];
        double y1 = yValues[floorIndex + 1];
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[xValues.length - 1];
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < xValues.length; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return Arrays.toString(xValues) + "\n" + Arrays.toString(yValues);
    }
    @Override
    public int hashCode() {
        int result = Arrays.hashCode(xValues);
        result = 31 * result + Arrays.hashCode(yValues);
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTabulatedFunction that = (ArrayTabulatedFunction) o;
        return Arrays.equals(xValues, that.xValues) &&
                Arrays.equals(yValues, that.yValues);
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        ArrayTabulatedFunction clone = (ArrayTabulatedFunction) super.clone();
        double[] clonedXValues = new double[xValues.length];
        double[] clonedYValues = new double[yValues.length];
        System.arraycopy(xValues, 0, clonedXValues, 0, xValues.length);
        System.arraycopy(yValues, 0, clonedYValues, 0, yValues.length);
        for(int i = 0; i< xValues.length; ++i) {
            clone.setX(i, clonedXValues[i]);
            clone.setY(i, clonedYValues[i]);
        }
            return clone;
    }
}
