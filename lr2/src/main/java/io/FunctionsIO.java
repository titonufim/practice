package io;

import functions.*;
import functions.factory.*;

import java.io.*;

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

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            int count = function.getCount();
            dataOutputStream.writeInt(count);
            for (int i = 0; i < count; i++) {
                dataOutputStream.writeDouble(function.getX(i));
                dataOutputStream.writeDouble(function.getY(i));
            }
            dataOutputStream.flush();
        }
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            int count = dataInputStream.readInt();
            double[] xValues = new double[count];
            double[] yValues = new double[count];
            for (int i = 0; i < count; i++) {
                xValues[i] = dataInputStream.readDouble();
                yValues[i] = dataInputStream.readDouble();
            }
            return factory.create(xValues, yValues);
        }
    }
}