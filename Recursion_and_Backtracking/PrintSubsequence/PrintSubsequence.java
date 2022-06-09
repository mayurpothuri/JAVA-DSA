package Recursion_and_Backtracking.PrintSubsequence;

import java.util.Scanner;

public class PrintSubsequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printSubsequence(str, "");
        scanner.close();
        return;
    }

    //time complexity - T(n) = T(n - 1) + T(n - 1); => T(n) = 2*T(n - 1)
    //T(n) = 2*T(n - 1); T(n - 1) = 2*T(n - 2); T(n - 2) = 2*T(n - 3);.....
    //T(n) = 2*[2*[2*T(n - 3)]]...
    //T(n) = (2 power i)*T(n - i)
    //T(n) = O(2 power n)
    private static void printSubsequence(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        printSubsequence(str.substring(1), ans + str.charAt(0));
        printSubsequence(str.substring(1), ans);
        return;
    }
}
