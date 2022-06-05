package Functions_and_Array.InverseArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int[] inverse = getInverseArray(a);
        display(inverse);
        br.close();
        return;
    }

    private static void display(int[] inverse) {
        for(int val : inverse){
            System.out.println(val);
        }
        return;
    }

    //time complexity - O(n)
    private static int[] getInverseArray(int[] a) {

        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++){
            result[a[i]] = i;
        }
        return result;
    }
}
