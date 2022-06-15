package Stack_and_Queue.PrefixEvaluationConversion;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluationConversion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ans = getPrefixEvaluation(str);
        String infix = getInfixFromPrefix(str);
        String postfix = getPostfixFromPrefix(str);
        System.out.println(ans);
        System.out.println(infix);
        System.out.println(postfix);
        scanner.close();
        return;
    }

    // time complexity - O(n)
    private static String getPostfixFromPrefix(String str) {
        char ch;
        String val1 = "", val2 = "";
        Stack<String> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            // if any space then skip
            if (ch == ' ')
                continue;
            // if any operator then push on stack the [postfix] expr with respect to current
            // operator and push that expr on to stack again as it would be considered as
            // operand for upcoming operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val1 = st.pop();
                val2 = st.pop();
                // postfix => operand1 operand2 operator
                st.push(val1 + val2 + ch);
            }
            // if operand then push on stack
            else {
                st.push(ch + "");
            }
        }
        return st.pop();
    }

    // time complexity - O(n)
    private static String getInfixFromPrefix(String str) {

        char ch;
        String val1 = "", val2 = "";
        Stack<String> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            // if any space then skip
            if (ch == ' ')
                continue;
            // if any operator then push on stack the [infix] expr with respect to current
            // operator and push that expr on to stack again as it would be considered as
            // operand for upcoming operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val1 = st.pop();
                val2 = st.pop();
                // infix => (operand1 operator operand2)
                st.push('(' + val1 + ch + val2 + ')');
            }
            // if operand then push on stack
            else {
                st.push(ch + "");
            }
        }
        return st.pop();
    }

    // time complexity - O(n)
    private static int getPrefixEvaluation(String str) {

        char ch;
        int val1 = 0, val2 = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            // if any space then skip
            if (ch == ' ')
                continue;
            // if any operator then push on stack the computed value with respect to current
            // operator and push that computed value on to stack again as it would be
            // considered as operand for upcoming operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                val1 = st.pop();
                val2 = st.pop();
                st.push(performAction(ch, val1, val2));
            }
            // if operand then push on stack
            else {
                st.push(ch - '0');
            }
        }
        return st.pop();
    }

    private static int performAction(char ch, int val1, int val2) {

        switch (ch) {
            case '/':
                return val1 / val2;
            case '*':
                return val1 * val2;
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            default:
                break;
        }
        return -1;
    }
}
