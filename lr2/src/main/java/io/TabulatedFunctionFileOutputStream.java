package io;

import functions.*;

import java.io.*;
public class TabulatedFunctionFileOutputStream {

    public static void main(String[] args) {
        try (BufferedOutputStream arrayOutputStream = new BufferedOutputStream(new FileOutputStream("output/array function.bin"));
             BufferedOutputStream linkedListOutputStream = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"))) {

            double[] xValues = {0.0, 0.5, 1.0};
            double[] yValues = {0.0, 0.25, 1.0};

            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues);
            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(xValues, yValues);

            FunctionsIO.writeTabulatedFunction(arrayOutputStream, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedListOutputStream, linkedListFunction);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
