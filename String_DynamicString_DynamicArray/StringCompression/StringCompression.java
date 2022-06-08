package String_DynamicString_DynamicArray.StringCompression;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        getCompressString(str);
        scanner.close();
        return;
    }

    private static void getCompressString(String str) {
        compressString1(str);
        compressString2(str);
        return;
    }

    //time complexity - O(n)
    private static void compressString1(String str) {
        StringBuilder sb = new StringBuilder();
        char ch;
        int j = 0;
        for(int i = 0; i < str.length();){
            ch =str.charAt(i);
            sb.append(ch);
            for(j = i + 1; j < str.length() && str.charAt(j) == ch; j++){}
            i = j;
        }
        System.out.println(sb.toString());
        return;
    }

    //time complexity - O(n)
    private static void compressString2(String str) {

        StringBuilder sb = new StringBuilder();
        char ch;
        int j = 0;
        for(int i = 0; i < str.length();){
            ch =str.charAt(i);
            sb.append(ch);
            for(j = i + 1; j < str.length() && str.charAt(j) == ch; j++){}
            sb.append(j - i == 1 ? "" : j - i);
            i = j;
        }
        System.out.println(sb.toString());
        return;
    }
}
