package Time_and_Space_Complexity.QuickSort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, a.length - 1);
        display(a);
        scanner.close();
        return;
    }

    //O(n)
    private static void display(int[] a){

        for(int val : a){
            System.out.print(val + " ");
        }
        System.out.println();
        return;
    }

    // used for swapping ith and jth elements of array
    private static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    //time complexity - O(n)
    //as index [i] keeps is at head of elements less than or equal to pivot,
    //index [j] keeps track for elements ahead of index [i]
    //whenever we come across the element which is less than or equal to pivot with [j] index
    //swap it with index [i] which increases the elements at index [i] side
    private static int getPartition(int[] a, int lo, int hi, int pivot) {

        System.out.println("pivot -> " + pivot);
        int i = lo - 1, j = lo;
        for(; j <= hi; j++){
            if(a[j] <= pivot){
                i++;
                swap(a, j, i);
            }
        }
        System.out.println("pivot index -> " + i);
        return i;
    }

    //time complexity - T(n) = 2*T(n/2) + O(n) ==> best abd average case ==> O(n*log(n))
    //worst case - T(n) = T(n - 1) + O(n) ==> O(n*n); as the pivot in every case, could be such that
    //there is one element at one side of partition and remaining (n - 1) elements are other end of partition
    private static void quickSort(int[] a, int lo, int hi) {
        
        if(lo > hi){
            return;
        }
        int pivot = getPartition(a, lo, hi, a[hi]);
        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);
        return;
    }
}