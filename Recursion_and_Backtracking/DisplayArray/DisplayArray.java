package Recursion_and_Backtracking.DisplayArray;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        displayArray(a, n - 1);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static void displayArray(int[] a, int n) {
        if(n < 0){
            return;
        }
        displayArray(a, n - 1);
        //post area - [after recursion call]
        System.out.println(a[n]);
        return;
    }
}
