package Recursion_and_Backtracking.PrintMazePathsJumps;

import java.util.Scanner;

public class PrintMazePathsJumps {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        printMazePathsJumps(0, 0, n - 1, m - 1, "");
        scanner.close();
        return;
    }

    //time complexity - O(3 power n*m) roughly
    private static void printMazePathsJumps(int row, int col, int destRow, int destCol, String ans) {
        if(row < 0 || col < 0 || row > destRow || col > destCol){
            return;
        }
        if(row == destRow && col == destCol){
            System.out.println(ans);
            return;
        }
        //from [row, col] to [row, col + i] using recursion faith that
        //[row, col + i] is obtained so append h + i to get from [row, col]
        for(int i = 1; i <= destCol; i++){
            printMazePathsJumps(row, col + i, destRow, destCol, ans + "h" + i);
        }
        //from [row, col] to [row + i, col] using recursion faith that
        //[row + i, col] is obtained so append v + i to get from [row, col]
        for(int i = 1; i <= destRow; i++){
            printMazePathsJumps(row + i, col, destRow, destCol, ans + "v" + i);
        }
        //from [row, col] to [row + i, col + i] using recursion faith that
        //[row + i, col + i] is obtained so append d + i to get from [row, col]
        for(int i = 1; i <= destRow && i <= destCol; i++){
            printMazePathsJumps(row + i, col + i, destRow, destCol, ans + "d" + i);
        }
        return;
    }
}
