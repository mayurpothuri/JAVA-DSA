package Time_and_Space_Complexity.RadixSort;

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        radixSort(a);
        display(a);
        scanner.close();
        return;
    }

    private static void display(int[] a) {

        for(int val : a){
            System.out.print(val + " ");
        }
        System.out.println();
        return;
    }

    //time complexity - O(n + k)
    public static void countSort(int[] a, int exp) {
        // write code here
        System.out.print("After sorting on " + exp + " place -> ");
        //since digits possible - [0 - 9]
        int[] prefixSum = new int[10];
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++){
            //indices are naturally in sorted order
            //since non-negative numbers are only possilbe
            //which could be used as index -> for a[i] -> index in prefixSum is = [a[i]]
            //take the frequency of each a[i] with the help of prefixSum
            //hence simply prefixSum stores the frequencies of each a[i]
            prefixSum[(a[i]/exp)%10]++;
        }

        //this is used because we need stable property -> if before sorting, e.g 3[1], 3[2] is there then after
        //after sorting also the previous order should be maintained -> 3[1], 3[2]
        //here we are calculating the cumulative sum of frequencies of a[i] stored in prefixSum
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] += prefixSum[i - 1];
        }
        //as the cumulative sum of freq stored in prefixSum is 1 - based(we want 0 - based index), 
        //so the actual index for a[i] in new result array would be [prefixSum[a[i]] - 1]
        //i.e, for a[i] - > index in prefix => [a[i]] -> index in new result array => [prefixSum[a[i]] - 1]
        //this works because indices are sorted naturally, and since we are using freq of each a[i]
        //index with [a[i]] in prefixSum and where cumulative freq sum is stored then 
        //[prefixSum[a[i]] - 1](1 - based but we want 0 - based index) is the index for a[i] for sorted order
        for(int i = a.length - 1; i >= 0; i--){
            result[prefixSum[(a[i]/exp)%10] - 1] = a[i];
            //decrease the freq as the prev item is stored in it's actual sorted order
            prefixSum[(a[i]/exp)%10]--;
        }
        //copy the sorted order in actual array
        for(int i = 0; i < result.length; i++){
            a[i] = result[i];
        }
        display(a);
    }

    //12, 23, 22, 21
    //as per one's position - >21, 22, 12, 23
    //after one's position, as per 10's position -> 12, 21, 22, 23
    //so as we can see, that as per one's position - > 21, 22
    //and after one's position, 10's position ordering should maintain the previous order [stable order]
    //so -> 21, 22 [10's position]
    //time complexity - O(n*b); n - > #elements in array, b -> #bits in max among array of given numbers
    public static void radixSort(int[] arr) {

        // write code here    
        int max = Integer.MIN_VALUE, exp = 1;
        for(int i = 0; i < arr.length; i++){
            max = max > arr[i] ? max : arr[i];
        }
        while(max > 0){
            countSort(arr, exp);
            exp *= 10;
            max/=10;
        }
        return;
    }
    
}
