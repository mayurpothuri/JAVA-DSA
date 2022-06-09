package Recursion_and_Backtracking.TargetSumSubset;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();
        getTargetSumSubset(a, 0, "", 0, sum);
        scanner.close();
        return;
    }

    //time complexity - T(n) = 2*T(n - 1);
    //T(n) = O(2 power n)
    private static void getTargetSumSubset(int[] arr, int idx, String set, int sos, int tar) {

        if(idx >= arr.length){
            //after getting till end of array through some euler path
            //check if sum found so far is equal to tar
            //if equal then print
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }
        //if sum found so far is greater than given tar then whatever we add would not be able to get tar.
        //only if all elements in array are greater than 0 and this constraint was given.
        if(sos > tar){
            return;
        }
        //for every element, there is choice - absent / present
        getTargetSumSubset(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        getTargetSumSubset(arr, idx + 1, set, sos, tar);
        return;
    }
}
