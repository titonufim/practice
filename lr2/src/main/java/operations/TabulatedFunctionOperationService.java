package operations;

import functions.Point;
import functions.TabulatedFunction;
public class TabulatedFunctionOperationService {

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {

        Point[] asPointsArray = new Point[tabulatedFunction.getCount()];
        int i = 0;
        for (Point point : tabulatedFunction) {
            asPointsArray[i] = point;
            ++i;
        }
        return asPointsArray;
    }
}
