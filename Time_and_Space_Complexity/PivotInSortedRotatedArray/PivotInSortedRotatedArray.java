package Time_and_Space_Complexity.PivotInSortedRotatedArray;

import java.util.Scanner;

public class PivotInSortedRotatedArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        System.out.println(getPivot(a));
        scanner.close();
        return;
    }

    //time complexity - O(log(n))
    //it's a variation for binary search
    //as the given array is sorted(non-decreasing) and rotated by some 'k' amount where k >= 0
    //the task boils down to find the minimum element within the array.[as the array elements are
    //non-deceeasing and rotated]
    //the trick is to compare the a[mid] with a[a.length - 1] every time.
    //if a[mid] <= a[a.length - 1] then we are in increasing order from mid to a.length - 1 
    //so we have to search the minimum at left part of mid [before mid]
    //if a[mid] > a[a.length - 1] then we need to search in the right part[decreasing part from mid to a.length - 1] 
    //as we need to find minimum.
    //we can't use first element for comparision as for -> 2, 3, 4, 6, 7 => first = 2 and mid = 4, and
    //-> 3, 4, 6 , 2, 7 => first = 3 and mid = 6. For both cases, first to mid it is in non-decreasing order
    //but the for both cases, the min is at left part of mid in Ist case and in right part of mid in IInd case
    private static int getPivot(int[] a) {
        int lo = 0, hi = a.length - 1, mid = 0, ans = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(a[mid] <= a[a.length - 1]){
                ans = mid;//potential and final answer
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return a[ans];
    }
}
