package concurrent;

import functions.*;

public class ReadTask implements Runnable {
    private TabulatedFunction function;

    public ReadTask(TabulatedFunction function) {
        this.function = function;
    }
    @Override
    public void run() {
        synchronized (function) {
            for (int i = 0; i < function.getCount(); ++i) {
                System.out.printf("After read: i = %d, x = %f, y = %f%n", i, function.getX(i), function.getY(i));
            }
        }
    }
}
