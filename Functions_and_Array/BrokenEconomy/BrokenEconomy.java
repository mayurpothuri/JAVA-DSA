package Functions_and_Array.BrokenEconomy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BrokenEconomy {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int d = Integer.parseInt(br.readLine());
        getCeilAndFloor(a, d);
        br.close();
        return;
    }

    //time complexity - O(log(n))
    //when start and end crosses in opposite ends then get the ceil and floor of given d is obtained.
    private static void getCeilAndFloor(int[] a, int d) {
        int start = 0, end = a.length - 1, mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(a[mid] == d){
                start++;
                end--;
                break;
            }
            else if(d < a[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(a[start]);
        System.out.println(a[end]);
        return;
    }
}
