package Time_and_Space_Complexity.PatitionArray;

import java.util.Scanner;

public class PartitionArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int pivot = scanner.nextInt();
        getPartition(a, pivot);
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

    // used for swapping ith and jth elements of array
    private static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //time complexity - O(n)
    private static void getPartition(int[] a, int pivot) {
        
        for(int i = -1, j = 0; j < a.length; j++){
            if(a[j] <= pivot){
                i++;
                swap(a, j, i);
            }
        }
        return;
    }
}
