package Time_and_Space_Complexity.MergeSort;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int[] result = mergeSort(a, 0, a.length - 1);
        System.out.print("Sorted Array -> ");
        display(result);
        scanner.close();
        return;
    }

    private static void display(int[] a){

        for(int val : a){
            System.out.print(val + " ");
        }
        System.out.println();
        return;
    }

    //time complexity - T(n) = 2*T(n/2) + O(n)
    //O(n*log(n))
    private static int[] mergeSort(int[] a, int start, int end) {
        if(start >= end){
            int[] b = new int[1];
            b[0] = a[start];
            return b;
        }
        int[] left = mergeSort(a, start, start + (end - start)/2);//recursive faith - left side array from mid is sorted 
        int[]right = mergeSort(a, start + (end - start)/2 + 1, end);//recursive faith - right side array from mid is sorted
        int[] result = mergeTwoSortedArrays(left, right);//after faith is completed, merge two sorted arrays
        return result;
    }

    //time complexity - O(n + m)
    private static int[] mergeTwoSortedArrays(int[] left, int[] right) {

        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        display(left);
        System.out.print("right array -> ");
        display(right);
        int i, j, k = 0;
        int[] result = new int[left.length + right.length];
        for(i = 0, j = 0; i < left.length && j < right.length;){
            if(left[i] < right[j]){
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }

        for(; i < left.length;){
            result[k++] = left[i++];
        }

        for(; j < right.length;){
            result[k++] = right[j++];
        }
        return result;
    }
}
