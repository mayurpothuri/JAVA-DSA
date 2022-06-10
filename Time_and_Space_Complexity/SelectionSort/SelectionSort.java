package Time_and_Space_Complexity.SelectionSort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        selectionSort(a);
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

    private static boolean isSmaller(int[] a, int i, int j){
        System.out.println("Comparing " + a[i] + " and " + a[j]);
        if(a[i] < a[j]){
            return true;
        }
        return false;
    }

    private static void swap(int[] a, int i, int j){
        System.out.println("Swapping " + a[i] + " and " + a[j]);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return;
    }

    //time complexity - O(n*n)
    private static void selectionSort(int[] a) {

        int minIndex;
        for(int i = 0; i + 1 < a.length; i++){
            minIndex = i;
            for(int j = i + 1; j < a.length; j++){
                if(isSmaller(a, j, minIndex)){
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
        return;
    }
}
