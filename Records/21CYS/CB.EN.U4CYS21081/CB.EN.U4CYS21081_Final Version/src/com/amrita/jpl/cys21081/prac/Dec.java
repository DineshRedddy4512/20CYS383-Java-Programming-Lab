package com.amrita.jpl.cys21081.prac;

import java.util.Scanner;

/**
 *  * @author Dinesh Reddy
 *  * @version 1.0
 * This class converts a decimal number to its binary and hexadecimal representations.
 */
public class Dec {

    /**
     * The main method reads a decimal number from the user and converts it to binary and hexadecimal representations.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalInput = scanner.nextInt();
        scanner.close();

        if (decimalInput < 0) {
            System.out.println("Error: Negative numbers are not supported.");
            return;
        }

        String binaryOutput = Integer.toBinaryString(decimalInput);
        String hexadecimalOutput = Integer.toHexString(decimalInput);

        System.out.println("Binary equivalent: " + binaryOutput);
        System.out.println("Hexadecimal equivalent: " + hexadecimalOutput.toUpperCase());
    }
}
