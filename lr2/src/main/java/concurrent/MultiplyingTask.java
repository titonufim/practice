package concurrent;

import functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {
    private TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public void run() {
        synchronized (function) {
            for (int i = 0; i < function.getCount(); ++i) {
                double newY = function.getY(i) * 2;
                function.setY(i, newY);
            }
        }

        System.out.println("the current thread (" + Thread.currentThread().getName() + ") has finished executing the task");
    }
}