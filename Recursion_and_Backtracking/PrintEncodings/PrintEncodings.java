package Recursion_and_Backtracking.PrintEncodings;

import java.util.Scanner;

//  1 -> a
//  2 -> b
//  3 -> c
//  ..
//  25 -> y
//  26 -> z

//  123 -> abc, aw, lc
//  993 -> iic
//  013 -> Invalid input. A string starting with 0 will not be passed.
//  103 -> jc
//  303 -> No output possible. But such a string maybe passed. In this case print nothing.
public class PrintEncodings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printEncodings(str, "");
        scanner.close();
        return;
    }

    //time complexity - exponential
    private static void printEncodings(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        int val;
        char ch;
        //for each substring, assume for the following characters[excluding the characters of substring]
        //the answer are obtained. So append the encoding of each substring to the already obtained answers.
        //recursion faith
        for(int i = 1; i <= str.length(); i++){
            val = Integer.parseInt(str.substring(0, i));
            if(val < 1 || val > 26){
                return;
            }
            ch  = (char)('a' + (val - 1));
            printEncodings(str.substring(i), ans + ch);
        }
        return;
    }
}
