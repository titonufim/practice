package io;

import functions.ArrayTabulatedFunction;
import operations.TabulatedDifferentialOperator;
import functions.TabulatedFunction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized array functions.bin"))) {
            // Создание табулированной функции
            double[] xValues = {0.0, 0.5, 1.0};
            double[] yValues = {0.0, 0.25, 1.0};
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues);

            // Нахождение первой и второй производной
            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
            TabulatedFunction firstDerivative = differentialOperator.derive(arrayFunction);
            TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);

            // Сериализация функций
            FunctionsIO.serialize(outputStream, arrayFunction);
            FunctionsIO.serialize(outputStream, firstDerivative);
            FunctionsIO.serialize(outputStream, secondDerivative);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("output/serialized array functions.bin"))) {
            // Десериализация функций
            TabulatedFunction deserializedArrayFunction = FunctionsIO.deserialize(inputStream);
            TabulatedFunction deserializedFirstDerivative = FunctionsIO.deserialize(inputStream);
            TabulatedFunction deserializedSecondDerivative = FunctionsIO.deserialize(inputStream);

            // Вывод значений функций в консоль
            System.out.println("Original Array Function: " + deserializedArrayFunction.toString());
            System.out.println("First Derivative: " + deserializedFirstDerivative.toString());
            System.out.println("Second Derivative: " + deserializedSecondDerivative.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}