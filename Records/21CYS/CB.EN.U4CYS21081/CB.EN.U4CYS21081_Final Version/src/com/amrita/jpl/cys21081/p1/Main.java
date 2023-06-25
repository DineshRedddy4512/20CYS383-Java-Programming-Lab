package com.amrita.jpl.cys21081.p1;
/**
 * @author Dinesh Reddy
 * @version 1.0
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice (1. Factorial, 2. Fibonacci, 3. The sum of n numbers, 4. Prime Test): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the number to find factorial of a number: ");
                int n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Error: Cannot find factorial of a negative number");
                } else {
                    long factorial = fact(n);
                    System.out.println("Factorial of " + n + " is " + factorial);
                }
                break;
            case 2:
                System.out.print("Enter the number of terms for Fibonacci series: ");
                int terms = scanner.nextInt();
                if (terms < 1) {
                    System.out.println("Error: Invalid number of terms for Fibonacci series");
                } else {
                    fibo(terms);
                }
                break;
            case 3:
                System.out.print("Enter the number of terms to find the sum of: ");
                int sumTerms = scanner.nextInt();
                if (sumTerms < 1) {
                    System.out.println("Error: Invalid number of terms for sum of n numbers");
                } else {
                    int sum = sum_n_no(sumTerms);
                    System.out.println("Sum of first " + sumTerms + " natural numbers is " + sum);
                }
                break;
            case 4:
                System.out.print("Enter the number to test for prime: ");
                int number = scanner.nextInt();
                if (number < 2) {
                    System.out.println("Error: Invalid number to test for prime");
                } else if (prime_test(number)) {
                    System.out.println(number + " is a prime number");
                } else {
                    System.out.println(number + " is not a prime number");
                }
                break;
            default:
                System.out.println("Error: Invalid choice");
        }

        scanner.close();
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n the number to calculate the factorial for
     * @return the factorial of the given number
     */
    public static long fact(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Prints the Fibonacci series up to the specified number of terms.
     *
     * @param terms the number of terms in the Fibonacci series
     */
    public static void fibo(int terms) {
        int firstTerm = 0, secondTerm = 1;
        System.out.print("Fibonacci Series of " + terms + " terms: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println();
    }

    /**
     * Calculates the sum of the first 'n' natural numbers.
     *
     * @param n the number of terms to find the sum of
     * @return the sum of the first 'n' natural numbers
     */
    public static int sum_n_no(int n) {
        return (n * (n + 1)) / 2;
    }

    /**
     * Checks if a given number is prime.
     *
     * @param n the number to test for primality
     * @return true if the number is prime, false otherwise
     */
    public static boolean prime_test(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
