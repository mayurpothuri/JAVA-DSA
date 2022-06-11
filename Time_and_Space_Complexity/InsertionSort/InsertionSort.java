package Time_and_Space_Complexity.InsertionSort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        insertionSort(a);
        display(a);
        scanner.close();
        return;
    }

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    //time complexity - O(n*n)
    private static void insertionSort(int[] a) {

        if(a.length == 1){
            return;
        }
        int k;
        for(int i = 1; i < a.length; i++){
            k = i;
            for(int j = i - 1; j >= 0 && isGreater(a, j, k); j--, k--){
                swap(a, j, k);
            }
        }
        return;
    }

    private static void display(int[] a) {

        for(int val : a){
            System.out.println(val);
        }
        return;
    }
}
