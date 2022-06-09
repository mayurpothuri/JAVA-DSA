package Recursion_and_Backtracking.PrintStairPaths;

import java.util.Scanner;

public class PrintStairsPaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printStairPaths(n, "");
        scanner.close();
        return;
    }

    //time complexity - O(3 power n) roughly
    private static void printStairPaths(int n, String ans) {
        //invalid solution
        if(n < 0){
            return;
        }
        //valid solution
        if(n == 0){
            System.out.println(ans);
            return;
        }

        //take 1 jump and solve for n - 1
        printStairPaths(n - 1, ans + "1");
        //take 2 jump and solve for n - 2
        printStairPaths(n - 2, ans + "2");
        //take 3 jump and solve for n - 3
        printStairPaths(n - 3, ans + "3");
        return;
    }
}
