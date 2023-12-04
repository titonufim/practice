package concurrent;

import functions.*;
import java.util.*;
import operations.*;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction function;

    public SynchronizedTabulatedFunction(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public int getCount() {
        synchronized (function) {
            return function.getCount();
        }
    }

    @Override
    public double getX(int index) {
        synchronized (function) {
            return function.getX(index);
        }
    }

    @Override
    public double getY(int index) {
        synchronized (function) {
            return function.getY(index);
        }
    }

    @Override
    public void setY(int index, double value) {
        synchronized (function) {
            function.setY(index, value);
        }
    }

    @Override
    public double leftBound() {
        synchronized (function) {
            return function.leftBound();
        }
    }

    @Override
    public double rightBound() {
        synchronized (function) {
            return function.rightBound();
        }
    }
    @Override
    public int indexOfX(double x) {
        synchronized (function) {
            return function.indexOfX(x);
        }
    }

    @Override
    public int indexOfY(double y) {
        synchronized (function) {
            return function.indexOfY(y);
        }
    }
    @Override
    public double apply(double x) {
        synchronized (function) {
            return function.apply(x);
        }
    }
    @Override
    public Iterator<Point> iterator() {
        synchronized (function) {
            Point[] points = TabulatedFunctionOperationService.asPoints(function);
            return new Iterator<Point>() {
                private int curIndex = 0;

                @Override
                public boolean hasNext() {
                    return curIndex < points.length;
                }

                @Override
                public Point next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return points[curIndex++];
                }
            };
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction synchronizedFunction);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (function) {
            return operation.apply(this);
        }
    }


}
