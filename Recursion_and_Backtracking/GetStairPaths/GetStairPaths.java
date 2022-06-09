package Recursion_and_Backtracking.GetStairPaths;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> result = getStairPaths(n);
        System.out.println(result);
        scanner.close();
        return;
    }

    //time complexity - O(3 power n)
    //as for each state[each n's within recursive call] there is 3 recursive call.
    private static ArrayList<String> getStairPaths(int n) {

        //pre area - [before any recursive call]
        if(n < 0){
            return null;
        }

        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> path1 = getStairPaths(n - 1);
        ArrayList<String> path2 = getStairPaths(n - 2);
        ArrayList<String> path3 = getStairPaths(n - 3);
        //post area - [after all recursive call]
        ArrayList<String> myResult = new ArrayList<>();
        if(path1 != null)
        for(String val : path1){
            myResult.add("1" + val);
        }
        if(path2 != null)
        for(String val : path2){
            myResult.add("2" + val);
        }
        if(path3 != null)
        for(String val : path3){
            myResult.add("3" + val);
        }
        return myResult;
    }
}
