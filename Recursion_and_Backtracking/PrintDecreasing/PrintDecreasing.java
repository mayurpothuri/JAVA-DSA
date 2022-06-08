package Recursion_and_Backtracking.PrintDecreasing;

import java.util.Scanner;

public class PrintDecreasing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();

        printDecreasing(n);
        scanner.close();
        return;
    }

    //print n to 1 using recursion.
    //time complexity - O(n)
    private static void printDecreasing(int n) {
        if(n <= 0){
            return;
        }
        //pre area
        System.out.println(n);
        printDecreasing(n - 1);
        return;
    }
}
