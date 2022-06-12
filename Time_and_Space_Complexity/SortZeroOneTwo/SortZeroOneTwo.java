package Time_and_Space_Complexity.SortZeroOneTwo;

import java.util.Scanner;

public class SortZeroOneTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        sortZeroOneTwo(a);
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

    //time complexity - O(n)
    //variation of two pointer approach - use 3 pointers
    private static void sortZeroOneTwo(int[] a) {

        int zeroPoint = -1, onePoint = 0, twoPoint = a.length;
        while(onePoint < twoPoint){
            if(a[onePoint] == 0){
                zeroPoint++;
                swap(a, onePoint, zeroPoint);
                onePoint++;
            }
            else if(a[onePoint] == 1){
                onePoint++;
            }
            else if(a[onePoint] == 2){
                twoPoint--;
                swap(a, onePoint, twoPoint);
            }
        }
        return;
    }
}
