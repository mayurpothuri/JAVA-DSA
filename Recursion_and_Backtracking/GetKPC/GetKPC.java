package Recursion_and_Backtracking.GetKPC;

import java.util.ArrayList;
import java.util.Scanner;

//  0 -> .;
//  1 -> abc
//  2 -> def
//  3 -> ghi
//  4 -> jkl
//  5 -> mno
//  6 -> pqrs
//  7 -> tu
//  8 -> vwx
//  9 -> yz

public class GetKPC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<String> result = getKPC(str);
        System.out.println(result);
        scanner.close();
        return;
    }

    //time complexity - O(n*(4 power n)) or O(n*(3 power n))
    //as for each key number, there are 4(or) 3 choices and there are 'n' key pad numbers.
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    private static ArrayList<String> getKPC(String str) {

        //pre area - [before recusive call]
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        ArrayList<String> subPart = getKPC(str.substring(1));
        //post area - [after recursive call]
        ArrayList<String> myResult = new ArrayList<>();
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++){
            for(String val : subPart){
                myResult.add(code.charAt(i) + val);
            }
        }
        return myResult;
    }
}
