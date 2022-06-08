package Recursion_and_Backtracking.AllIndicesOfArray;

import java.util.Scanner;

public class AllIndicesOfArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        int[] result = getAllIndices(a, x, 0, 0);
        if(result.length == 0){
            System.out.println("NO OUTPUT");
            scanner.close();
            return;
        }
        for(int val : result){
            System.out.println(val);
        }
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static int[] getAllIndices(int[] a, int x, int i, int fsf) {
        //pre area - [before recursive call]
        if(i == a.length){
            return new int[fsf];
        }
        if(a[i] == x){
            fsf++;
        }
        int[] result = getAllIndices(a, x, i + 1, fsf);
        //post area - [after recursive call]
        if(a[i] == x){
            result[fsf - 1] = i;
        }
        return result;
    }
}
