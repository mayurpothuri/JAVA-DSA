package Recursion_and_Backtracking.PrintIncreasingDecreasing;

import java.util.Scanner;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printIncreasingDecreasing(n);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    //printing n to 1 and then 1 to n
    private static void printIncreasingDecreasing(int n) {

        if(n <= 0){
            return;
        }
        //pre area - [before recursion]
        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        //post area - [after recursion]
        System.out.println(n);
        return;
    }
}
