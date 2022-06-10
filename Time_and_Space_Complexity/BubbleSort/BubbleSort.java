package Time_and_Space_Complexity.BubbleSort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        bubbleSort(a);
        display(a);
        scanner.close();
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
    private static void bubbleSort(int[] a) {

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j + 1 < a.length - i; j++){
                if(isSmaller(a, j + 1, j)){
                    swap(a, j + 1, j);
                }
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
