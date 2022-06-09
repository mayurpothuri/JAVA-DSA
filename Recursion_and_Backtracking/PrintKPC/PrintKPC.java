package Recursion_and_Backtracking.PrintKPC;

import java.util.Scanner;

public class PrintKPC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printKPC(str, "");
        scanner.close();
        return;
    }

    //time complexity - O(3 power n) (or) O(4 power n)
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    private static void printKPC(String str, String ans) {

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        String code = codes[str.charAt(0) - '0'];
        for(int i = 0; i < code.length(); i++){
            //append character options for each code in 'str'
            //recursion faith - starting with choice1 are obtained so append choice 1 charcater
            //starting with choice2 are obtained so append choice 2 charcater
            //so on....
            printKPC(str.substring(1), ans + code.charAt(i));
        }
        return;
    }
}
