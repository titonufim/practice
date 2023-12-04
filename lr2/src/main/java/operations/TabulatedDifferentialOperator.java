package operations;

import concurrent.SynchronizedTabulatedFunction;
import functions.TabulatedFunction;
import functions.factory.TabulatedFunctionFactory;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.Point;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    private TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = TabulatedFunctionOperationService.asPoints(function); // Получаем все точки входной функции
        double[] xValue = new double[function.getCount()];
        double[] yValue = new double[function.getCount()];
        int i = 0;
        Point[] arrayofpoints = TabulatedFunctionOperationService.asPoints(function);
        while (i < (xValue.length-1)) {
            xValue[i] = arrayofpoints[i].x;
            yValue[i] = (arrayofpoints[i + 1].y - arrayofpoints[i].y) / (arrayofpoints[i + 1].x - arrayofpoints[i].x);
            i++;
        }
        xValue[i] = arrayofpoints[i].x;
        yValue[i] = yValue[i - 1];
        return factory.create(xValue, yValue);
    }
    public TabulatedFunction deriveSynchronously(TabulatedFunction function) {
        if (function instanceof SynchronizedTabulatedFunction) {
            return derive(function);
        } else {
            SynchronizedTabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);
            return synchronizedFunction.doSynchronously(this::derive);
        }
    }
}
