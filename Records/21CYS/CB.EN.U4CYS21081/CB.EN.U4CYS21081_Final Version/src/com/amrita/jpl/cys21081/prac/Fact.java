package com.amrita.jpl.cys21081.prac;

/**
 * @author Dinesh Reddy
 * @version 1.0
 */
/**
 * This class calculates the factorial of a given number.
 */
class Fact{
    /**
     * The main method calculates the factorial of a number and prints the result.
     *
     * @param args the command-line arguments
     */
    public static void main(String args[]){
        int i,fact=1;
        int number=5;//It is the number to calculate factorial
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
    }
}
