package operations;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import exceptions.InconsistentFunctionsException;
import functions.factory.TabulatedFunctionFactory;
public class TabulatedFunctionOperationService {

    private TabulatedFunctionFactory factory;
    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {

        Point[] asPointsArray = new Point[tabulatedFunction.getCount()];
        int i = 0;
        for (Point point : tabulatedFunction) {
            asPointsArray[i] = point;
            ++i;
        }
        return asPointsArray;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation) {

        if (a.getCount() != b.getCount())
            throw new InconsistentFunctionsException();

        double[] xValue = new double[a.getCount()];
        double[] yValue = new double[a.getCount()];
        Point[] arrA = asPoints(a);
        Point[] arrB = asPoints(b);

        for (int i = 0; i < a.getCount(); i++) {
            if (arrA[i].x == arrB[i].x) xValue[i] = arrA[i].x;
            else throw new InconsistentFunctionsException();
            yValue[i] = operation.apply(arrA[i].y, arrB[i].y);
        }
        return factory.create(xValue, yValue);



    }
    private interface BiOperation {
        double apply(double u, double v);
    }
    public TabulatedFunction multiplication(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u * v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction division(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u / v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction add(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u + v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction subtract(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u - v;
        return doOperation(firstFunction, secondFunction, operation);
    }
}
