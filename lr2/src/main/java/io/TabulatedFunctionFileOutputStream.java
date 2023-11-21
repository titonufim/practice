package io;

import functions.*;

import java.io.*;
public class TabulatedFunctionFileOutputStream {

    public static void main(String[] args) {
        try (BufferedOutputStream arrayFileOutput = new BufferedOutputStream(new FileOutputStream("lr2/output/array function.bin"));
             BufferedOutputStream linkedListFileOutput = new BufferedOutputStream(new FileOutputStream("lr2/output/linked list function.bin"))) {
            double[] xValue = {0.0, 2.0, 5.0};
            double[] yValue = {1.0, 2.5, 6.0};
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValue, yValue);
            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(xValue, yValue);

            FunctionsIO.writeTabulatedFunction(arrayFileOutput, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedListFileOutput, linkedListFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
