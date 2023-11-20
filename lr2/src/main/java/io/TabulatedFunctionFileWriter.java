package io;

import functions.*;

import java.io.*;

public class TabulatedFunctionFileWriter {

    public static void main(String[] args) {
        try (BufferedWriter arrayWriter = new BufferedWriter(new FileWriter("output/array function.txt"));
             BufferedWriter linkedListWriter = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {

            double[] xValues = {0.0, 0.5, 1.0};
            double[] yValues = {0.0, 0.25, 1.0};
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues);
            FunctionsIO.writeTabulatedFunction(arrayWriter, arrayFunction);

            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(xValues, yValues);
            FunctionsIO.writeTabulatedFunction(linkedListWriter, linkedListFunction);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}