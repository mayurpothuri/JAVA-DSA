package Time_and_Space_Complexity.TargetSumPair;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSumPair {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        getTargetSumPair(a, target);
        scanner.close();
        return;
    }

    //time complexity - O(n*log(n))
    //nlog(n) - for sorting
    //O(n) -> for two pinter approach to get the pair such that sum of pair is equal to target
    private static void getTargetSumPair(int[] a, int target) {

        Arrays.sort(a);
        int lo = 0, hi = a.length - 1;
        while(lo < hi){
            if(a[lo] + a[hi] == target){
                System.out.println(a[lo] + ", " + a[hi]);
                lo++;
                hi--;
            }
            else if(a[lo] + a[hi] > target){
                hi--;
            }
            else{
                lo++;
            }
        }
        return;
    }
}
