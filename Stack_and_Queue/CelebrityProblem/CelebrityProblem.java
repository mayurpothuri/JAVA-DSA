package Stack_and_Queue.CelebrityProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//  If there is a '1' in ith row, jth spot, then person i knows about person j.
//  A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
//  If there is a celebrity print it's index otherwise print "none".
import java.util.Stack;

//  Constraints
//  1 <= n <= 10^4
//  e1, e2, .. n * n elements belongs to the set (0, 1)
public class CelebrityProblem {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
        return;
    }

    // time complexity - O(n + n) ==> O(n)
    private static void findCelebrity(int[][] arr) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        int potential_i, potential_j;
        // till stack contains of 1 member, the knock outs happen.
        // knock outs happening among the members
        while (st.size() > 1) {
            potential_i = st.pop();
            potential_j = st.pop();
            // if 'i' knows about 'j' then 'i' can't be celebrity.
            if (arr[potential_i][potential_j] == 1) {
                st.push(potential_j);
            } else {
                st.push(potential_i);
            }
        }
        // after knock out, there is one potential member to be celebrity
        // to be sure, we need to check that this potential celebrity knows nobody else.
        // if yes then "none" celebrity.
        potential_i = st.pop();
        for (int index = 0; index < arr.length; index++) {
            // condition that 'i' knows some 'index' member or some 'index' member doesn't
            // know 'i'[potential celebrity] given that index != i
            if (index != potential_i && (arr[potential_i][index] == 1 || arr[index][potential_i] == 0)) {
                System.out.println("none");
                return;
            }
        }
        System.out.println(potential_i);
        return;
    }
}
