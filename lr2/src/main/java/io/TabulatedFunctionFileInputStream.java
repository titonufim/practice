package io;

import functions.*;
import functions.factory.*;
import operations.*;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream("input/binary function.bin"))) {
            TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
            TabulatedFunction function = FunctionsIO.readTabulatedFunction(fileInputStream, factory);
            System.out.println("Считанная функция:");
            System.out.println(function.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Введите размер и значения функции:");
            TabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction function = FunctionsIO.readTabulatedFunction(new BufferedInputStream(System.in), factory);
            System.out.println("Производная функции:");
            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(factory);
            TabulatedFunction derivative = differentialOperator.derive(function);
            System.out.println(derivative.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}