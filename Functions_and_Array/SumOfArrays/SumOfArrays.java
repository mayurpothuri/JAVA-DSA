package Functions_and_Array.SumOfArrays;
import java.util.*;
//5
//  1   2   1   2   5
//6
//  4   4   5   7   9   8
//  4   5   7   9   2   3

public class SumOfArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }
        getSum(a, b);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static void getSum(int[] a, int[] b) {
        int carry = 0, x = 0, y = 0, i = a.length - 1, j = b.length - 1, k = Math.max(a.length, b.length);
        int[] sum = new int[k--];
        while(i >= 0 && j >= 0){
            x = a[i]%10;
            y = b[j]%10;
            sum[k--] = ((x + y + carry)%10);
            carry = (x + y + carry)/10;
            i--;j--;
        }

        while(i >= 0){
            x = a[i]%10;
            sum[k--] = ((x + carry)%10);
            carry = (x + carry)/10;
            i--;
        }

        while(j >= 0){
            y = b[j]%10;
            sum[k--] =  ((y + carry)%10);
            carry = (y + carry)/10;
            j--;
        }
        if(carry > 0){
            System.out.println(carry);
        }
        for(int val : sum){
            System.out.println(val);
        }
        return;
    }
}
