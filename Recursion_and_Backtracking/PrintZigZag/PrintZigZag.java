package Recursion_and_Backtracking.PrintZigZag;

import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printZigZag(n);
        scanner.close();
        return;
    }

    //time complexity - O(2 power n)
    //T(n) = 2*T(n - 1); T(n - 1) = 2*T(n - 2); T(n - 2) = 2*T(n - 3)
    //T(n) = 2*[2*T(n - 2)]
    //T(n) = 2*[2*[2*T(n - 3)]]
    //.... => T(n) = 2 power n
    private static void printZigZag(int n) {
        if(n <= 0){
            return;
        }
        //pre area -  [before both recursion call]
        System.out.print(n + " ");
        printZigZag(n - 1);
        //in order area -  [after one recursion call and before following recursion call]
        System.out.print(n + " ");
        printZigZag(n - 1);
        //post area -  [after both recursion call]
        System.out.print(n + " ");
        return;
    }
}
