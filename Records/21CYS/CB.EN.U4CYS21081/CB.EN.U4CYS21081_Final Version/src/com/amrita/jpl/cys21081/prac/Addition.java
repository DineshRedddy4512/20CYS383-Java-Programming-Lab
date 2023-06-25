package com.amrita.jpl.cys21081.prac;

/**
 * @author Dinesh Reddy
 * @version 1.0
 */

import java.util.Scanner;

/**
 * This class calculates the sum of two numbers entered by the user.
 */
public class Addition{

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        int num1, num2, sum;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        num1 = sc.nextInt();

        System.out.println("Enter Second Number: ");
        num2 = sc.nextInt();

        sc.close();

        sum = num1 + num2;
        System.out.println("Sum of two numbers: " + sum);
    }
}
