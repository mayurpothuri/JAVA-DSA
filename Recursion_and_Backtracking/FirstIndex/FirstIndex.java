package Recursion_and_Backtracking.FirstIndex;

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        System.out.println(getFirstIndex(a, 0, x));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static int getFirstIndex(int[] a, int i, int x) {
        if(i >= a.length - 1){
            return a[i] == x ? i : -1;
        }
        //pre area - [before recursive call]
        if(a[i] == x){
            return i;
        }
        return getFirstIndex(a, i + 1, x);
    }
}
