package Functions_and_Array.SubArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        getSubArray(a);
        br.close();
        return;
    }

    //time complexity - O(n*n) roughly
    private static void getSubArray(int[] a) {
        int size = 0;
        for(int i = 0; i < a.length; i++){
            size = i;
            while(size < a.length){
                for(int j = i; j <= size; j++){
                    System.out.print(a[j] + "\t");
                }
                System.out.println();
                size++;
            }
        }
        return;
    }
}
