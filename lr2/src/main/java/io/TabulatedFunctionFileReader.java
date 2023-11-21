package io;


import functions.TabulatedFunction;
import functions.factory.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try {
            try (BufferedReader readerArray = new BufferedReader(new FileReader("lr2/input/function.txt"));
                 BufferedReader readerLinked = new BufferedReader(new FileReader("lr2/input/function.txt"))) {

                TabulatedFunction arrayTabulatedFunction = FunctionsIO.readTabulatedFunction(readerArray, new ArrayTabulatedFunctionFactory());
                TabulatedFunction linkedListTabulatedFunction = FunctionsIO.readTabulatedFunction(readerLinked, new functions.factory.LinkedListTabulatedFunctionFactory());

                System.out.println("Array:");
                System.out.println(arrayTabulatedFunction);
                System.out.println("Linked List:");
                System.out.println(linkedListTabulatedFunction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}