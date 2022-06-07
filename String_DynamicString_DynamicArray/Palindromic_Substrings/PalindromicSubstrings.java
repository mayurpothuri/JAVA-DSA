package String_DynamicString_DynamicArray.Palindromic_Substrings;

import java.util.Scanner;

public class PalindromicSubstrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        solutions(str);
        scanner.close();
        return;
    }

    //time complexity - O(n*n*n) as the no. of substrings are in the order of n*n and for each substring, the 
    //palindrome checking [O(n) time] was used.
    private static void solutions(String str) {

        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j <= str.length(); j++){
                if(isPalindrome(str.substring(i, j))){
                    System.out.println(str.substring(i, j));
                }
            }
        }
        return;
    }

    private static boolean isPalindrome(String substring) {
        int i = 0, j = substring.length() - 1;
        boolean flag = true;
        while(i < j){
            if(substring.charAt(i) != substring.charAt(j)){
                flag = false;
                break;
            }
            i++;j--;
        }
        return flag;
    }
}
