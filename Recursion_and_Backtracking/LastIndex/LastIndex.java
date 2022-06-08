package Recursion_and_Backtracking.LastIndex;

import java.util.Scanner;

public class LastIndex {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        System.out.println(getLastIndex(a, 0, x));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static int getLastIndex(int[] a, int i, int x) {
        if(i == a.length){
            return -1;
        }
        int lastIndex = getLastIndex(a, i + 1, x);
        //post area - [after recursive call]
        if(lastIndex != -1){
            return lastIndex;
        }
        else if(a[i] == x){
            lastIndex = i;
        }
        return lastIndex;
    }
}
