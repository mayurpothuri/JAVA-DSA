package Recursion_and_Backtracking.GetMazePathsJumps;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsJumps {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<String> result = getMazePathsJumps(0, 0, n - 1, m - 1);
        System.out.println(result);
        scanner.close();
        return;
    }

    //time complexity - T(n, m) = T(n, m - i) + T(n - i, m) + T(n - i, m - i)
    //T(n, m) <= 3*T(n - i, m)
    //so it is O(3 power(n + m)) roughly
    private static ArrayList<String> getMazePathsJumps(int row, int col, int destRow, int destCol) {
        if(row < 0 || col < 0 || row > destRow || col > destCol){
            return new ArrayList<>();
        }
        if(row == destRow && col == destCol){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        //get paths for horizontal jumps for cell [row, col]
        ArrayList<String> myResult = new ArrayList<>();
        for(int i = 1; i <= destCol; i++){
            //got all horizontal jumps paths for cell [row, col + i] in hpaths
            //recursion faith
            ArrayList<String> hpaths = getMazePathsJumps(row, col + i, destRow, destCol);
            //post area - [for above recursion call only]
            //to get paths from [row, col] to [row, col + i] use below loop
            for(String val : hpaths){
                myResult.add("h" + i + val);
            }
        }
        //get paths for vertical jumps for cell [row, col]
        for(int i = 1; i <= destRow; i++){
            //got all vertical jumps paths for cell [row + i, col] in hpaths
            //recursion faith
            ArrayList<String> vpaths = getMazePathsJumps(row + i, col, destRow, destCol);
            //post area - [for above recursion call only]
            //to get paths from [row, col] to [row + i, col] use below loop
            for(String val : vpaths){
                myResult.add("v" + i + val);
            }
        }
        //get paths for diagonal jumps for cell [row, col]
        for(int i = 1; i <= destRow && i <= destCol; i++){
            //got all diagonal jumps paths for cell [row + i, col + i] in hpaths
            //recursion faith
            ArrayList<String> dpaths = getMazePathsJumps(row + i, col + i, destRow, destCol);
            //post area - [for above recursion call only]
            //to get paths from [row, col] to [row + i, col + i] use below loop
            for(String val : dpaths){
                myResult.add("d" + i + val);
            }
        }
        return myResult;
    }
}
