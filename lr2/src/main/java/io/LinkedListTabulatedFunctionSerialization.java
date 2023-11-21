package io;

import functions.*;
import operations.*;
import java.io.*;
public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized array functions.bin"))) {

            double[] xValue = {0.0, 0.5, 1.0};
            double[] yValue = {0.0, 0.25, 1.0};

            TabulatedFunction function = new LinkedListTabulatedFunction(xValue, yValue);

            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
            TabulatedFunction firstDerivative = differentialOperator.derive(function);
            TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);

            FunctionsIO.serialize(outputStream, function);
            FunctionsIO.serialize(outputStream, firstDerivative);
            FunctionsIO.serialize(outputStream, secondDerivative);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("output/serialized array functions.bin"))) {

            TabulatedFunction deserializedListFunction = FunctionsIO.deserialize(inputStream);
            TabulatedFunction deserializedFirstDerivative = FunctionsIO.deserialize(inputStream);
            TabulatedFunction deserializedSecondDerivative = FunctionsIO.deserialize(inputStream);

            System.out.println("Original Array Function: " + deserializedListFunction.toString());
            System.out.println("First Derivative: " + deserializedFirstDerivative.toString());
            System.out.println("Second Derivative: " + deserializedSecondDerivative.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
