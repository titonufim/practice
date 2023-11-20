package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;

import java.util.Iterator;
public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    public static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length)
            throw new DifferentLengthOfArraysException("Lengths of xValues and yValues are different");
    }

   public static void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i] > xValues[i + 1])
                throw new ArrayIsNotSortedException("xValues array is not sorted");
        }
    }
        protected double interpolate ( double x, double leftX, double rightX, double leftY, double rightY){
            return leftY + ((x - leftX) / (rightX - leftX)) * (rightY - leftY);
        }

        public double apply ( double x){
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append(" size = ");
        builder.append(this.getCount());
        builder.append("\n");
        for (Point point : this) {
            builder.append("[");
            builder.append(point.x);
            builder.append("; ");
            builder.append(point.y);
            builder.append("]\n");
        }

        return builder.toString();
    }
    }
