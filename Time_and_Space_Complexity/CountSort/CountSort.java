package Time_and_Space_Complexity.CountSort;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        countSort(a,min,max);
        display(a);
        scanner.close();
        return;
    }

    //O(n)
    private static void display(int[] a) {

        for(int val : a){
            System.out.println(val);
        }
        return;
    }

    //time complexity - O(n + k)
    private static void countSort(int[] a, int min, int max) {

        //min and max required to decide the length of prefixSum array
        int[] prefixSum = new int[max - min + 1];
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++){
            //since -ve numbers are also possible, a[i] - min would give us the range non-negative numbers
            //which could be used as index -> for a[i] -> index in prefixSum is = [a[i] - min]
            //now as a[i] is used as index in prefixSum ([a[i] - min]),
            //take the frequency of each a[i] with the help of prefixSum
            //hence simply prefixSum stores the frequencies of each a[i]
            prefixSum[a[i] - min]++;
        }

        //this is used because we need stable property -> if before sorting, e.g 3[1], 3[2] is there then after
        //after sorting also the previous order should be maintained -> 3[1], 3[2]
        //here we are calculating the cumulative sum of frequencies of a[i] stored in prefixSum
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] += prefixSum[i - 1];
        }
        //as the cumulative sum of freq stored in prefixSum is 1 - based(we want 0 - based index), 
        //a[i] -> index [a[i] - min] in prefixSum
        //so the actual index for a[i] in new result array would be [prefixSum[a[i] - min] - 1]
        //i.e, for a[i] - > index in prefix => [a[i] - min] -> index in new result array => [prefixSum[a[i] - min] - 1]
        //this works because indices are sorted naturally, and since we are using freq of each a[i]
        //index with [a[i] - min] in prefixSum and when cumulative freq sum is stored then 
        //[prefixSum[a[i] - min] - 1](1 - based but we want 0 - based index) is the index for a[i] for sorted order
        for(int i = a.length - 1; i >= 0; i--){
            result[prefixSum[a[i] - min] - 1] = a[i];
            //decrease the freq as the prev item is stored in it's actual sorted order
            prefixSum[a[i] - min]--;
        }
        //copy the sorted order in actual array
        for(int i = 0; i < result.length; i++){
            a[i] = result[i];
        }
        return;
    }
}
