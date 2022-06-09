package Recursion_and_Backtracking.GetMazePaths;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<String> result = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(result);
        scanner.close();
        return;
    }

    //time complexity - T(n, m) = T(n, m - 1) + T(n - 1, m) + O(n, m)
    //O(2 power n) roughly as this is exponential approach, visiting every cell of n*m grid
    private static ArrayList<String> getMazePaths(int row, int col, int n, int m) {
        //pre area - [before both recursion call]
        if(row < 0 || col < 0 || row > n || col > m){
            return null;
        }
        else if(row == n && col == m){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> horizon = getMazePaths(row, col + 1, n, m);
        ArrayList<String> vert = getMazePaths(row + 1, col, n, m);
        //post area - [after both recursive call]
        ArrayList<String> myResult = new ArrayList<>();
        if(horizon != null){
            for(String val : horizon){
                myResult.add("h" + val);
            }
        }
        if(vert != null){
            for(String val : vert){
                myResult.add("v" + val);
            }
        }
        return myResult;
    }
}
