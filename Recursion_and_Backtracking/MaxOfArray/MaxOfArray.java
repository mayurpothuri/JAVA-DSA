package Recursion_and_Backtracking.MaxOfArray;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        System.out.println(getMaxOfArray(a, n - 1));
        System.out.println(optimizedMaxOfArray(a, 0,  n - 1));
        scanner.close();
        return;
    }

    //time complexity - 
    //T(n) = 2T(n/2); T(n/2) = 2*T(n/4); T(n/4) = 2*T(n/8);...
    //T(n) = 2*[2*[2*T(n/(2 power of 3))]]...
    //O(n)
    //so time complexity - O(n)
    private static int optimizedMaxOfArray(int[] a, int start, int end){
        if(start >= end || end <= start){
            return a[start];
        }
        int max1 = optimizedMaxOfArray(a, start, start + (end - start)/2);
        int max2 = optimizedMaxOfArray(a, start + (end - start)/2 + 1, end);
        //post area - [after both recursive calls]
        return Math.max(max1, max2);
    }

    //time complexity - O(n)
    private static int getMaxOfArray(int[] a, int i) {
        if(i <= 0){
            return a[i];
        }
        int elem = getMaxOfArray(a, i - 1);

        return Math.max(a[i], elem);
    }
}
