package Recursion_and_Backtracking.PrintIncreasing;

import java.util.Scanner;

public class PrintIncreasing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printIncreasing(n);
        scanner.close();
        return;
    }

    //print 1 to n using recursion.
    //time complexity - O(n)
    private static void printIncreasing(int n) {
        if(n <= 0){
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
        return;
    }
}
