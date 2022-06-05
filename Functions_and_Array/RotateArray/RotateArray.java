package Functions_and_Array.RotateArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int r = Integer.parseInt(br.readLine());

        getRotatedArray(a, r);
        display(a);
        br.close();
        return;
    }

    private static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for(int val : a){
            sb.append(val + " ");
        }
        System.out.println(sb.toString());
        return;
    }

    //time complexity - O(n)
    private static void getRotatedArray(int[] a, int r) {
        r = r%a.length;
        if(r < 0){
            r += a.length;
        }
        getReverseArray(a, 0, a.length - r - 1);
        getReverseArray(a, a.length - r, a.length - 1);
        getReverseArray(a, 0, a.length - 1);
        return;
    }

    private static void getReverseArray(int[] a, int i, int j) {
        int start = i, end = j, temp = 0;
        while(start <= end){
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;end--;
        }
        return;
    }
}
