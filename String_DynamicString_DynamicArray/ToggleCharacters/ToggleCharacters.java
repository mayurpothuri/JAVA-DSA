package String_DynamicString_DynamicArray.ToggleCharacters;

import java.util.Scanner;

public class ToggleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        getToggleCharacters(str);
        scanner.close();
    }

    //time complexity - O(n)
    private static void getToggleCharacters(String str) {

        StringBuilder sb = new StringBuilder();
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)('a' + ch - 'A'));
            }
            else{
                sb.append((char)('A' + ch - 'a'));
            }
        }
        System.out.println(sb.toString());
        return;
    }
}
