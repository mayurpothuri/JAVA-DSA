package Stack_and_Queue.StockSpan;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int[] result = getStockSpan(a);
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
    //same technique as used for "next greater element to the right" but instead of traversing
    //from end to start, we need to traverse the array from start to end.
    //This is needed as we need to keep track of next greater element to the left for every elements in array.
    //Also instead of storing the greater elements in stack, we need to keep track of indices
    //as we need to calculate the "span -> number of days passed between the current day and the first day before 
    //current day"
    private static int[] getStockSpan(int[] a) {

        int[] result = new int[a.length];
        int index = 0;
        Stack<Integer> st = new Stack<>();
        result[index] = 1;
        st.push(index++);
        while(index < a.length){
            while(!st.empty() && a[index] > a[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                result[index] = index + 1;
            }
            else{
                result[index] = index - st.peek();
            }
            st.push(index++);
        }
        return result;
    }

}
