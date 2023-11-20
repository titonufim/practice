package io;

import functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.PrintWriter;

public final class FunctionsIO {

    private FunctionsIO() {
        throw new UnsupportedOperationException("Cannot instantiate FunctionsIO");
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        try (PrintWriter printWriter = new PrintWriter(writer)) {
            int count = function.getCount();
            printWriter.println(count);
            for (int i = 0; i < count; i++) {
                double x = function.getX(i);
                double y = function.getY(i);
                printWriter.printf("%f %f\n", x, y);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}