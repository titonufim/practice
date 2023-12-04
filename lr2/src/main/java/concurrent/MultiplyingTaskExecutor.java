package concurrent;
import functions.*;

import java.util.ArrayList;
import java.util.List;

public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction baseFunction = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000, 1000);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MultiplyingTask task = new MultiplyingTask(baseFunction);
            Thread thread = new Thread(() -> {
                synchronized (baseFunction) {
                    task.run();
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(2000);

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < baseFunction.getCount(); i++) {
            System.out.printf("x = %f, y = %f%n", baseFunction.getX(i), baseFunction.getY(i));
        }
    }
}