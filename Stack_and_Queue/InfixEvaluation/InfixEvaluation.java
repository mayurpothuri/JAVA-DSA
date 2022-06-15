package Stack_and_Queue.InfixEvaluation;

import java.util.Scanner;
import java.util.Stack;

//  Constraints
//  1. Expression is balanced
//  2. The only operators used are +, -, *, /
//  3. Opening and closing brackets - () - are used to impact precedence of operations
//  4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
//  5. In two operators of equal precedence give preference to the one on left.
//  6. All operands are single digit numbers.

public class InfixEvaluation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ans = getInfixEvaluation(str);
        System.out.println(ans);
        scanner.close();
        return;
    }

    // time complexity - O(n)
    private static int getInfixEvaluation(String str) {

        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        char ch;
        int operands1 = 0, operands2 = 0;
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
            // we pop the values from operand stack and perform the action with respect to
            // operators stored in operator stack.
            else if (ch == ')') {

                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    operands2 = operandStack.pop();
                    operands1 = operandStack.pop();
                    int val = performAction(operands1, operands2, operatorStack.pop());
                    operandStack.push(val);
                }
                operatorStack.pop();

            }
            // if any mathematical operator, then check whether the top of stack has more
            // precedence.[as higher precedence means that operations on stored operands in
            // operand stack is performed.]

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (!operatorStack.empty() && isPrecedence(ch) <= isPrecedence(operatorStack.peek())) {
                    operands2 = operandStack.pop();
                    operands1 = operandStack.pop();
                    int val = performAction(operands1, operands2, operatorStack.pop());
                    operandStack.push(val);
                }
                operatorStack.push(ch);

            }
            // store operands in operand stack.
            else {

                operandStack.push(ch - '0');

            }
        }
        // at last, if some operators are stored in operator stack then perform actions
        // till operator stack is empty and at last the final ans is stored on top of
        // operand stack.
        while (!operatorStack.empty()) {
            operands2 = operandStack.pop();
            operands1 = operandStack.pop();
            int val = performAction(operands1, operands2, operatorStack.pop());
            operandStack.push(val);
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

    private static int performAction(int operands1, int operands2, Character pop) {

        switch (pop) {
            case '+':
                return (operands1 + operands2);
            case '-':
                return (operands1 - operands2);
            case '*':
                return (operands1 * operands2);
            case '/':
                return (operands1 / operands2);
        }
        return 0;
    }
}
