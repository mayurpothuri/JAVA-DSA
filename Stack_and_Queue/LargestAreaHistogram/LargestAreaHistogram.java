package Stack_and_Queue.LargestAreaHistogram;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        System.out.println(getLargestAreaHistogram(a));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    //same variation as for "next greater element to the right" for every element.
    //only variation is we need to find the smaller element because that point will be the boundary
    //since we want the rectangle to be able to spread further to the right.
    private static int[] getNextSmallerElementRight(int[] a) {

        int[] right = new int[a.length];
        Stack<Integer> st = new Stack<>();
        int index = a.length - 1;
        right[index] = a.length;
        st.push(index--);
        while(index >= 0){
            while(!st.empty() && a[index] <= a[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                right[index] = a.length;
            }
            else{
                right[index] = st.peek();
            }
            st.push(index--);
        }
        return right;
    }

    //time complexity - O(n)
    //same variation as for "next greater element to the left" for every element.
    //only variation is we need to find the smaller element because that point will be the boundary
    //since we want the rectangle to be able to spread further to the left.
    private static int[] getNextSmallerElementLeft(int[] a) {

        int[] left = new int[a.length];
        Stack<Integer> st = new Stack<>();
        int index = 0;
        left[index] = -1;
        st.push(index++);
        while(index < a.length){
            while(!st.empty() && a[index] <= a[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                left[index] = -1;
            }
            else{
                left[index] = st.peek();
            }
            st.push(index++);
        }
        return left;
    }

    //time complexity - O(n) + O(n) + O(n)
    //O(n)
    //after getting the left and right boundaries, need to calculate the area of rectangle and pick the max one.
    private static int getLargestAreaHistogram(int[] a) {

        int[] left = getNextSmallerElementLeft(a);
        int[] right = getNextSmallerElementRight(a);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            maxArea = maxArea < (right[i] - left[i] - 1)*a[i] ? (right[i] - left[i] - 1)*a[i] : maxArea;
        }
        return maxArea;
    }
}
