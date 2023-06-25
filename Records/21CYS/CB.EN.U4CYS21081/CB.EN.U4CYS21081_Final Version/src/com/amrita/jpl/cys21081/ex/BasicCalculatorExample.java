package com.amrita.jpl.cys21081.ex;

/**
 * @author Dinesh Reddy
 * @version 1.0
 */
import java.util.Scanner;

interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    double add(double a, double b);

    /**
     * Subtracts two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    double multiply(double a, double b);

    /**
     * Divides two numbers.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the division
     * @throws ArithmeticException if division by zero occurs
     */
    double divide(double a, double b) throws ArithmeticException;
}


class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return a / b;
    }
}


public class BasicCalculatorExample {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double addition = calculator.add(num1, num2);
        double subtraction = calculator.subtract(num1, num2);
        double multiplication = calculator.multiply(num1, num2);
        double division;

        try {
            division = calculator.divide(num1, num2);
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        }
    }
}
