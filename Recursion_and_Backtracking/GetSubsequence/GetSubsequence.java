package Recursion_and_Backtracking.GetSubsequence;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<String> result = getSubsequence(str);
        System.out.println(result);
        scanner.close();
        return;
    }

    //time complexity - T(n) = T(n - 1) + O(2 power (n));
    //T(n) = T(n - 1) + O(2 power (n)); T(n - 1) = T(n - 2) + O(2 power (n - 1)); 
    //T(n - 2) = T(n - 3) + O(2 power (n - 2)) ......
    //T(n) = [T(n - 2) + O(2 power (n - 1))] + O(2 power (n));
    //T(n) = [[T(n - 3) + O(2 power (n - 2))] + O(2 power (n - 1))] + O(2 power (n))
    //T(n) = O(1) + O(2) + O(2*2) + ........ + O(2 power(n - 2)) + O(2 power (n - 1)) + O(2 power (n))
    //T(n) = O(2 power n)
    private static ArrayList<String> getSubsequence(String str) {

        //pre area - [before recursive call]
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String sub = str.substring(1);
        ArrayList<String> subPart = getSubsequence(sub);
        //post area - [after recursive call]
        ArrayList<String> myResult = new ArrayList<>();
        for(String val : subPart){
            myResult.add(val);
        }
        for(String val : subPart){
            myResult.add(ch + val);
        }
        return myResult;
    }
}
