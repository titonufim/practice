package io;

import functions.ArrayTabulatedFunction;
import operations.TabulatedDifferentialOperator;
import functions.TabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("lr2/output/serialized array functions.bin"))) {
            double[] xValues = {0.0, 0.5, 1.0};
            double[] yValues = {0.0, 0.25, 1.0};
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues);
            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
            TabulatedFunction firstDerivative = differentialOperator.derive(arrayFunction);
            TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);
            FunctionsIO.serialize(outputStream, arrayFunction);
            FunctionsIO.serialize(outputStream, firstDerivative);
            FunctionsIO.serialize(outputStream, secondDerivative);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("lr2/output/serialized array functions.bin"))) {
            TabulatedFunction deserializedArrayFunction = FunctionsIO.deserialize(inputStream);
            System.out.println("Original Array Function: " + deserializedArrayFunction.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("lr2/output/serialized array functions.bin"))) {
            TabulatedFunction deserializedFirstDerivative = FunctionsIO.deserialize(inputStream);
            System.out.println("First Derivative: " + deserializedFirstDerivative.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("lr2/output/serialized array functions.bin"))) {
            TabulatedFunction deserializedSecondDerivative = FunctionsIO.deserialize(inputStream);
            System.out.println("Second Derivative: " + deserializedSecondDerivative.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}