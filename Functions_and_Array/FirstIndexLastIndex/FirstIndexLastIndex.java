package Functions_and_Array.FirstIndexLastIndex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstIndexLastIndex {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int d = Integer.parseInt(br.readLine());
        getFirstIndexAndLastIndex(a, d);
        br.close();
        return;
    }

    //time complexity - O(2*log(n)) ====> O(log(n))
    private static void getFirstIndexAndLastIndex(int[] a, int d) {
        getFirstIndex(a, d);
        getLastIndex(a, d);
        return;
    }

    private static void getFirstIndex(int[] a, int d) {
        int mid = 0, start = 0, end = a.length - 1, fi = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(a[mid] == d){
                fi = mid;
                end = mid - 1;
            }
            else if(d < a[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(fi);
        return;
    }

    private static void getLastIndex(int[] a, int d) {
        int mid = 0, start = 0, end = a.length - 1, li = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(a[mid] == d){
                li = mid;
                start = mid + 1;
            }
            else if(d < a[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(li);
        return;
    }
}
