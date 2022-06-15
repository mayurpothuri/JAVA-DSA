package Stack_and_Queue.PostFixEvaluationConversion;

import java.util.Scanner;
//  1. You are given a postfix expression.
//  2. You are required to evaluate it and print it's value.
//  3. You are required to convert it to infix and print it.
//  4. You are required to convert it to prefix and print it.
import java.util.Stack;

//  Note -> Use brackets in infix expression for indicating precedence.

//  1. Expression is a valid postfix expression
//  2. The only operators used are +, -, *, /
//  3. All operands are single digit numbers.

public class PostFixEvaluationConversion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ans = getPostFixEvaluation(str);
        String infix = getInFix(str);
        String prefix = getPrefixFromPostfix(str);
        System.out.println(ans);
        System.out.println(infix);
        System.out.println(prefix);
        scanner.close();
        return;
    }

    // time complexity - O(n)
    private static String getPrefixFromPostfix(String str) {
        char ch;
        String val1 = "", val2 = "";
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            // if space then continue
            if (ch == ' ')
                continue;
            // if any mathematical operator then pop the values out. evaluate[prefix] it and
            // then again push in th stack as the computed value will be used as operand for
            // upcoming operator and so on.
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val2 = st.pop();
                val1 = st.pop();
                st.push(ch + val1 + val2);
            }
            // if operand then push it on stack
            else {
                st.push(ch + "");
            }
        }
        // pop the answer
        return st.pop();
    }

    // time complexity - O(n)
    private static String getInFix(String str) {
        char ch;
        String val1 = "", val2 = "";
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            // if space then continue
            if (ch == ' ')
                continue;
            // if any mathematical operator then pop the values out. evaluate[infix] it and
            // then again push in th stack as the computed value will be used as operand for
            // upcoming operator and so on.
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val2 = st.pop();
                val1 = st.pop();
                st.push('(' + val1 + ch + val2 + ')');
            }
            // if operand then push it on stack
            else {
                st.push(ch + "");
            }
        }
        // pop the answer
        return st.pop();
    }

    // time complexity - O(n)
    private static int getPostFixEvaluation(String str) {

        char ch;
        int val1 = 0, val2 = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            // if space then continue
            if (ch == ' ')
                continue;
            // if any mathematical operator then pop the values out. evaluate it and then
            // again push in th stack as the computed value will be used as operand for
            // upcoming operator and so on.
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val2 = st.pop();
                val1 = st.pop();
                st.push(performAction(ch, val1, val2));
            }
            // if operand then push it on stack
            else {
                st.push(ch - '0');
            }
        }
        // pop the answer
        return st.pop();
    }

    private static int performAction(char ch, int val1, int val2) {

        switch (ch) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            default:
                break;
        }
        return 0;
    }
}
