package String_DynamicString_DynamicArray.PrintPermutations;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        getPermutations1(str);
        System.out.println("==================================");
        getPermutations2(str);
        scanner.close();
        return;
    }

    //time complexity - O(n!*n) roughly, since we are 
    private static void getPermutations2(String str){

        int n = 0, alSize = 0;
        char ch = str.charAt(0);
        ArrayList<String> al = new ArrayList<>();
        al.add(ch + "");
        for(int i = 1; i < str.length(); i++){
            ch = str.charAt(i);
            alSize = al.size();
            for(int j = 0; j < alSize; j++){
                StringBuilder sb = new StringBuilder(al.get(0));
                n = sb.length();
                for(int offset = 0; offset <= n; offset++){
                    sb.insert(offset, ch);
                    al.add(sb.toString());
                    sb.deleteCharAt(offset);
                }
                al.remove(0);
            }
        }
        for(String st : al){
            System.out.println(st);
        }
        return;
    }

    //time complexity - O(n!*n*n), first calculate factorial ans then,
    // as for each permutations[total n! permutations], we are checking
    //for choices of characters
    private static void getPermutations1(String str) {
        int n = str.length(), q = 0, r = 0, temp = 0;
        int factorial = getFactorial(n);
        StringBuilder sb;
        for(int i = 0; i < factorial; i++){
            sb = new StringBuilder(str);
            temp = i;
            for(int div = n; div > 0; div--){
                q = temp/div;
                r = temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
        return;
    }

    //time complexity - O(n)
    private static int getFactorial(int n) {
        int val = 1;
        for(int i = 1; i <= n; i++){
            val *= i;
        }
        return val;
    }
}
