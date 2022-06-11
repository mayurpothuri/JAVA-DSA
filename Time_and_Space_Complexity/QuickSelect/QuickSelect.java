package Time_and_Space_Complexity.QuickSelect;

import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(quickSelect(a, 0, a.length - 1, k - 1));
        scanner.close();
        return;
    }

    // used for swapping ith and jth elements of array
    private static void swap(int[] a, int j, int i) {
        System.out.println("Swapping " + a[j] + " and " + a[i]);
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
        return;
    }

    //time complexity - O(n)
    //as index [i] keeps is at head of elements less than or equal to pivot,
    //index [j] keeps track for elements ahead of index [i]
    //whenever we come across the element which is less than or equal to pivot with [j] index
    //swap it with index [i] which increases the elements at index [i] side
    private static int getPartition(int[] a, int lo, int hi, int pivot){

        System.out.println("pivot -> " + pivot);
        int i = lo - 1, j = lo;
        for(; j <= hi; j++){
            if(a[j] <= pivot){
                i++;
                swap(a, j, i);
            }
        }
        System.out.println("pivot index -> " + i);
        return i;
    }

    //time complexity - T(n) = 2*T(n/2) + O(n) ==> best and average case ==> O(n*log(n))
    //worst case - T(n) = T(n - 1) + O(n) ==> O(n*n)
    private static int quickSelect(int[] a, int lo, int hi, int k) {

        int pivot = getPartition(a, lo, hi, a[hi]);
        if(pivot == k){
            return a[pivot];
        }
        else if(k < pivot){
            return quickSelect(a, lo, pivot - 1, k);
        }
        else{
            return quickSelect(a, pivot + 1, hi, k);
        }
    }
}
