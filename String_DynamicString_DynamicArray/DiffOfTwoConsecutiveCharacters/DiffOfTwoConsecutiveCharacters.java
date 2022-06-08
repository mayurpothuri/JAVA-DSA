package String_DynamicString_DynamicArray.DiffOfTwoConsecutiveCharacters;

import java.util.Scanner;

public class DiffOfTwoConsecutiveCharacters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        getDiffOfTwoConsecutiveCharacters(str);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static void getDiffOfTwoConsecutiveCharacters(String str) {

        StringBuilder sb = new StringBuilder();
        char ch1, ch2;

        for(int i = 0; i + 1 < str.length(); i += 2){
            ch1 = str.charAt(i);
			ch2 = str.charAt(i + 1);
			if(i == 0){
				sb.append(ch1);
				sb.append(ch2 - ch1);
				sb.append(ch2);
			}
			else{
				sb.append(ch2 - ch1);
				sb.append(ch2);
			}
        }
        System.out.println(sb.toString());
        return;
    }
}
