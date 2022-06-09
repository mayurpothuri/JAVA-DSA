package Recursion_and_Backtracking.PrintPermutations;

import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        printPermutations(str, "");
        scanner.close();
        return;
    }

    //time complexity - T(n, 0) = n*T(n - 1, 1)
    //O(n!)
    private static void printPermutations(String str, String ans) {

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch;
        String ls, us;
        //have faith that we got the permutations that starts from each second letter choices included
        //[i.e, besides firs character choice, we got all permutations].
        //so we can then append all first letter choices to obtained permutations.
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            ls = str.substring(0, i);
            us = str.substring(i + 1);
            printPermutations(ls + us, ans + ch);
        }
        return;
    }
}
