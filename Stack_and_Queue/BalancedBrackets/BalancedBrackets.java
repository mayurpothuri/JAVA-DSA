package Stack_and_Queue.BalancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isBalancedBracketts(str));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    //if matching pair of opening and closing pairs are there at every step
    //then it is balanced else not balanced
    private static boolean isBalancedBracketts(String str) {
        Stack<Character> st = new Stack<>();
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if((ch == ')' && (st.empty() || st.peek() != '(')) ||
                    (ch == ']' && (st.empty() || st.peek() != '[')) ||
                    (ch == '}' && (st.empty() || st.peek() != '{'))){
                        return false;
            }
            else if((ch == ')' && (!st.empty() || st.peek() == '(')) ||
                    (ch == ']' && (!st.empty() || st.peek() == '[')) ||
                    (ch == '}' && (!st.empty() || st.peek() == '{'))){
                st.pop();
            }
        }
        if(!st.empty()){
            return false;
        }
        return true;
    }
}
