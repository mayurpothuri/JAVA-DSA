package Recursion_and_Backtracking.DisplayReverseArray;

import java.util.Scanner;

public class DisplayReverseArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        displayReverseArray(a, 0);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static void displayReverseArray(int[] a, int i) {

        if(i >= a.length){
            return;
        }
        displayReverseArray(a, i + 1);
        //post area - [after recursion call]
        System.out.println(a[i]);
        return;
    }
}
