package Stack_and_Queue.SlidingWindowMaximum;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        getSlidingWindowMax(a, k);
        scanner.close();
        return;
    }

    // time complexity - O(n) + O(n) ==> O(n)
    private static void getSlidingWindowMax(int[] a, int k) {

        // get next greater element to the right for every element
        int[] greaterRight = getNextGreaterElementRight(a);
        int index = 0;
        // i -> starting of window
        for (int i = 0; i + k <= a.length; i++) {
            // index helps to get the next greater element for the considered window
            // as all the elements from index till next greater element are smaller as per
            // defination for next greater
            // element to the right.
            // index if it is less than the start of the window then set index = start of
            // the window[i], else no change
            index = index < i ? i : index;
            // now loop till the next greater element is found outside the range of currenr
            // considered window
            // whose starting point is [i]
            while (greaterRight[index] < i + k) {
                index = greaterRight[index];
            }
            // print the answer for the current window[i]
            System.out.println(a[index]);
        }
        return;
    }

    // time complexity - O(n)
    // since we want the greater element to the right for each element in the array,
    // we keep track for greater element to the right by traversing from end to
    // start of array.
    // by default, the last element has no element greater to the right so the
    // greater value would be -1.
    // for array -> ?? ? 5 3 8 7 10 13 => the possible value for '?' is 5, 8, 10 &
    // 13.
    // suppose ? value is 4 then the next greater element is 5.
    // suppose ? value is 7 then the next greater element is 8.
    // suppose ? value is 9 then the next greater element is 10.
    // suppose ? value is 11 then the next greater element is 13.
    // after deciding the next greater element for ? when the value of ? is known
    // same technique is used to decide the next greater element of ?? based on ?,
    // 5, 8, 10 & 13.
    // if ? value knock out some other value then for previous elements too those
    // value won't be considered.
    // if ? value is greater then after elements then ?? is also, the next greater
    // element is the potential values for
    // ? after knock out as the new bar is set.
    private static int[] getNextGreaterElementRight(int[] a) {

        int[] result = new int[a.length];
        Stack<Integer> st = new Stack<>();
        int index = a.length - 1;
        result[index] = a.length - 1;
        st.push(index--);
        while (index >= 0) {
            while (!st.empty() && a[index] > a[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                result[index] = a.length;// so that it comes outside the window
            } else {
                result[index] = st.peek();
            }
            st.push(index--);
        }
        return result;
    }
}