package Time_and_Space_Complexity.SortZeroOne;

import java.util.Scanner;

public class SortZeroOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        sortZeroOne(a);
        display(a);
        scanner.close();
        return;
    }

    private static void display(int[] a) {

        for(int val : a){
            System.out.println(val);
        }
        return;
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //two pointer approach -> same for partition algo
    //Time complexity - O(n)
    private static void sortZeroOne(int[] a) {
        int lo = -1, hi = 0;
        while(hi < a.length){
            if(a[hi] == 0){
                lo++;
                swap(a, hi, lo);
            }
            hi++;
        }
        return;
    }
}
