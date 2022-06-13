package Stack_and_Queue.NextGreaterElementRight;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementRight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int[] result = getNextGreaterElementRight(a);
        display(result);
        scanner.close();
        return;
    }

    private static void display(int[] result) {

        for(int val : result){
            System.out.println(val);
        }
        return;
    }

    //time complexity - O(n)
    //since we want the greater element to the right for each element in the array,
    //we keep track for greater element to the right by traversing from end to start of array.
    //by default, the last element has no element greater to the right so the greater value would be -1.
    //for array -> ?? ? 5 3 8 7 10 13 => the possible value for '?' is 5, 8, 10 & 13.
    //suppose ? value is 4 then the next greater element is 5.
    //suppose ? value is 7 then the next greater element is 8.
    //suppose ? value is 9 then the next greater element is 10.
    //suppose ? value is 11 then the next greater element is 13.
    //after deciding the next greater element for ? when the value of ? is known
    //same technique is used to decide the next greater element of ?? based on ?, 5, 8, 10 & 13.
    //if ? value knock out some other value then for previous elements too those value won't be considered.
    //if ? value is greater then after elements then ?? is also, the next greater element is the potential values for
    //? after knock out as the new bar is set.  
    private static int[] getNextGreaterElementRight(int[] a) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[a.length];
        int index = a.length - 1;
        result[index] = -1;
        st.push(a[index--]);
        while(!st.empty() && index >= 0){
            while(!st.empty() && a[index] > st.peek()){
                st.pop();
            }
            if(st.empty()){
                result[index] = -1;
            }
            else{
                result[index] = st.peek();
            }
            st.push(a[index--]);
        }
        return result;
    }
}
