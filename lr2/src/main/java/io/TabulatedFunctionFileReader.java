package io;


import functions.TabulatedFunction;
import functions.factory.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input/function.txt"))) {
            TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(reader, arrayFactory);
            System.out.println(arrayFunction.toString());
            reader.readLine(); // Skip empty line
            TabulatedFunctionFactory linkedListFactory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction linkedListFunction = FunctionsIO.readTabulatedFunction(reader, linkedListFactory);
            System.out.println(linkedListFunction.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}