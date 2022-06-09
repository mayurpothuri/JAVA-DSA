package Recursion_and_Backtracking.PrintMazePaths;

import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        printMazePaths(0, 0, n - 1, m - 1, "");
        scanner.close();
        return;
    }

    //time complexity - O(2 power n*m) roughly
    private static void printMazePaths(int row, int col, int destRow, int destCol, String ans) {
        if(row < 0 || col < 0 || row > destRow || col > destCol){
            return;
        }
        if(row == destRow && col == destCol){
            System.out.println(ans);
            return;
        }
        //choice for horizontal from [row, col] using [row, col + 1]
        printMazePaths(row, col + 1, destRow, destCol, ans + "h");
        //choice for vertical from [row, col] using [row + 1, col]
        printMazePaths(row + 1, col, destRow, destCol, ans + "v");
        return;
    }
}
