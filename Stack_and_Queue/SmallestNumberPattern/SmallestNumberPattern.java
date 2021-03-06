package Stack_and_Queue.SmallestNumberPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SmallestNumberPattern {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = getSmallestNumberPattern(str);
        System.out.println(ans);
        br.close();
        return;
    }

    // time complexity - O(n)
    // as long as we see [d]'s thenwe need to push the increamented values in stack
    // as we need in reverse.
    // as soon as we see [i]'s then we need to print the values with respect to
    // previous [d]'s and then store the increamented values with respect [i]'s in
    // stack. [When popped then we get in increasing value]
    // eg -iii -> [1], 2, []; ans = 1; [2], 3, []; ans = 12; [3], 4, []; ans =
    // 1234;(outside for loop)
    // eg - dddiiddd -> ans = every [i] is splitting value -> dddi =>
    // 4[d]3[d]2[d]1[i'], and for -> iiddd => 1[i']5[i]9[d]8[d]7[d]6
    // ans = 432159876.
    private static int getSmallestNumberPattern(String str) {
        // starting value
        int count = 1, temp = 0;
        String result = "";
        Stack<Integer> ans = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // if found [d]'s, then store in stack without printing, since we want smallest
            // number and for [d]'s we want decreasing pattern of number from left to right.
            if (str.charAt(i) == 'd') {
                ans.push(count);
                count++;
            }
            // if found [i]'s, then push the current count[since for every [d], we want i, j
            // such that i > j], then increament the count and then print the content of
            // stack[previous d's value and i's values].
            // this also takes care of series od [i]'s as we push the increamented value for
            // [i] ans then we are emptying the stack so the increamented values for [i]'s
            // is achieved instead of getting reverse order.
            else {
                ans.push(count);
                count++;
                while (!ans.empty()) {
                    temp = ans.pop();
                    result += temp;
                }
            }
        }
        // at last updated countin stack, then print out the remaining values in stack.
        ans.push(count);
        while (!ans.empty()) {
            temp = ans.pop();
            result += temp;
        }
        return Integer.parseInt(result);
    }
}
