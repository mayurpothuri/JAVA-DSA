package Functions_and_Array.SubsetArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetArray {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        getSubsets(a, 0, a.length, "");
        br.close();
        return;
    }

    //time complexity - O(2 power n) as for each element, there is 2 choices and in total 2 power n subsets are to be printed.
    //hashing can be used to avoid duplicates subsets.
    private static void getSubsets(int[] a, int i, int length, String subset) {
        if(i >= length){
            System.out.println(subset);
            return;
        }
        getSubsets(a, i + 1, length, subset + "-\t");
        getSubsets(a, i + 1, length, subset + a[i] + "\t");
        return;
    }
}
