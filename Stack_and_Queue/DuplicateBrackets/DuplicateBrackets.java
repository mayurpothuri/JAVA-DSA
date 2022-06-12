package Stack_and_Queue.DuplicateBrackets;

import java.util.Scanner;
import java.util.Stack;

//(a + b) + ((c + d)) -> true
//(a + b) + (c + d) - > false
public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isDuplicateBrackets(str));
        scanner.close();
        return;
    }
    //time complexity - O(n)
    //if spaces in input then ignore[continue]
    //if any character other than ')', push on stack
    //if ')' encountered, and if top of stack is '('
    //thus means that previous (expr) was computed so the original
    //expr was of form -> ((expr)) hence true
    private static boolean isDuplicateBrackets(String str) {

        Stack<Character> st = new Stack<>();
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch == ')'){
                if(st.peek() == '('){
                    return true;
                }
                while(st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        return false;
    }
}
