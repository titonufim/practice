package io;


import functions.*;
import functions.factory.*;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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
    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        try {
            int count = Integer.parseInt(reader.readLine());
            double[] xValues = new double[count];
            double[] yValues = new double[count];
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));

            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] values = line.split(" ");
                if (values.length >= 2) {
                    double x = numberFormat.parse(values[0]).doubleValue();
                    double y = numberFormat.parse(values[1]).doubleValue();
                    xValues[i] = x;
                    yValues[i] = y;
                }
            }

            return factory.create(xValues, yValues);
        } catch (ParseException e) {
            throw new IOException("Error parsing input", e);
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

        DataInputStream input = new DataInputStream(inputStream);
        int size = input.readInt();
        double[] xValue = new double[size];
        double[] yValue = new double[size];
        for (int i = 0; i < size; i++) {
            xValue[i] = input.readDouble();
            yValue[i] = input.readDouble();
        }
        return factory.create(xValue, yValue);
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(function);
        objectOutputStream.flush();
    }
    public static  TabulatedFunction deserialize(BufferedInputStream stream) throws IOException,ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        return (TabulatedFunction)objectInputStream.readObject();
    }

}