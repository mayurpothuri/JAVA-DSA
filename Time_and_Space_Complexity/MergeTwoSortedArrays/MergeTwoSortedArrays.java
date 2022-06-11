package Time_and_Space_Complexity.MergeTwoSortedArrays;

import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }

        int[] result = mergeTwoSortedArrays(a, b);
        display(result);
        scanner.close();
        return;
    }

    private static void display(int[] result) {

        for(int val : result){
            System.out.println(val);
        }
        return;
    }

    //time complexity - O(n + m)
    private static int[] mergeTwoSortedArrays(int[] a, int[] b) {

        int i, j, k = 0;
        int[] result = new int[a.length + b.length];
        for(i = 0, j = 0; i < a.length && j < b.length;){
            if(a[i] < b[j]){
                result[k++] = a[i++];
            }
            else{
                result[k++] = b[j++];
            }
        }

        for(; i < a.length;){
            result[k++] = a[i++];
        }

        for(; j < b.length;){
            result[k++] = b[j++];
        }
        return result;
    }
}
