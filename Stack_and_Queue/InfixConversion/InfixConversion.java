package Stack_and_Queue.InfixConversion;

import java.util.Scanner;
import java.util.Stack;

//  1. Expression is balanced
//  2. The only operators used are +, -, *, /
//  3. Opening and closing brackets - () - are used to impact precedence of operations
//  4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
//  5. In two operators of equal precedence give preference to the one on left.
//  6. All operands are single digit numbers.

public class InfixConversion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String postFix = getPostFix(str);
        System.out.println(postFix);
        String preFix = getPreFix(str);
        System.out.println(preFix);
        scanner.close();
        return;
    }

    // time complexity - O(n)
    private static String getPreFix(String str) {

        char ch, op;
        String val1, val2;
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            // if space then continue
            if (ch == ' ')
                continue;
            // if '(' then store in operator stack
            if (ch == '(') {
                operatorStack.push(ch);

            }
            // if ')' then till we see '(' in operator stack,
            // we pop the values from operand stack and perform the action[prefix] with
            // respect to operators stored in operator stack.
            else if (ch == ')') {
                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    op = operatorStack.pop();
                    val2 = operandStack.pop();
                    val1 = operandStack.pop();
                    // operator operand1 operand2
                    operandStack.push(op + val1 + val2);
                }
                operatorStack.pop();
            }
            // if any mathematical operator, then check whether the top of stack has more
            // precedence.[as higher precedence means that operations on stored operands in
            // operand stack is performed.]
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operatorStack.empty() && isPrecedence(operatorStack.peek()) >= isPrecedence(ch)) {
                    op = operatorStack.pop();
                    val2 = operandStack.pop();
                    val1 = operandStack.pop();
                    // operator operand1 operand2
                    operandStack.push(op + val1 + val2);
                }
                operatorStack.push(ch);

            }
            // store operands in operand stack.
            else {
                operandStack.push(ch + "");
            }
        }
        // at last, if some operators are stored in operator stack then append the
        // prefix expr till operator stack is empty and at last the final ans is stored
        // on top of operand stack.
        while (!operatorStack.empty()) {
            op = operatorStack.pop();
            val2 = operandStack.pop();
            val1 = operandStack.pop();
            // operator operand1 operand2
            operandStack.push(op + val1 + val2);
        }
        return operandStack.pop();
    }

    // time complexity - O(n)
    private static String getPostFix(String str) {
        char ch, op;
        String val1, val2;
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            // if space then continue
            if (ch == ' ')
                continue;
            // if '(' then store in operator stack
            if (ch == '(') {
                operatorStack.push(ch);
            }
            // if ')' then till we see '(' in operator stack,
            // we pop the values from operand stack and perform the action[postfix] with
            // respect to operators stored in operator stack.
            else if (ch == ')') {
                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    op = operatorStack.pop();
                    val2 = operandStack.pop();
                    val1 = operandStack.pop();
                    // operand1 operand2 operator
                    operandStack.push(val1 + val2 + op);
                }
                operatorStack.pop();
            }
            // if any mathematical operator, then check whether the top of stack has more
            // precedence.[as higher precedence means that operations on stored operands in
            // operand stack is performed.]
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operatorStack.empty() && isPrecedence(operatorStack.peek()) >= isPrecedence(ch)) {
                    op = operatorStack.pop();
                    val2 = operandStack.pop();
                    val1 = operandStack.pop();
                    // operand1 operand2 operator
                    operandStack.push(val1 + val2 + op);
                }
                operatorStack.push(ch);

            }
            // store operands in operand stack.
            else {
                operandStack.push(ch + "");
            }
        }
        // at last, if some operators are stored in operator stack then append the
        // postfix expr till operator stack is empty and at last the final ans is stored
        // on top of operand stack.
        while (!operatorStack.empty()) {
            op = operatorStack.pop();
            val2 = operandStack.pop();
            val1 = operandStack.pop();
            // operand1 operand2 operator
            operandStack.push(val1 + val2 + op);
        }
        return operandStack.pop();
    }

    private static int isPrecedence(Character ch) {

        switch (ch) {
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
        }
        return 0;
    }
}
