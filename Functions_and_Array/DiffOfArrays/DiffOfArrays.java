package Functions_and_Array.DiffOfArrays;
import java.util.*;
//a2 >= a1

//3
//  2   3   6
//4
//  1   2   1   2
//  9   7   6

public class DiffOfArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a1 = new int[n];
        for(int i = 0; i < n; i++){
            a1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] a2 = new int[m];
        for(int i = 0; i < m; i++){
            a2[i] = scanner.nextInt();
        }

        getDiff(a1, a2);
        scanner.close();
        return;
    }
    
    //time complexity - O(log(max(n2, n1))) roughly
    private static void getDiff(int[] a1, int[] a2) {

        int i = a1.length - 1, j = a2.length - 1, x = 0, y = 0, borrow = 0;
        int[] diff = new int[a2.length];
        int k = diff.length - 1;
        while (i >=0 || j >= 0) {
            if(j >= 0)
            x = a2[j--]%10;
            else
            x = 0;
            if(i >= 0)
            y = a1[i--]%10;
            else
            y = 0;
            x += borrow;
            if(x >= y){
                borrow = 0;
            }
            else{
                borrow = -1;
                x += 10;
            }
            diff[k--] = (x - y)%10;

        }
        int index = 0;
        while ( diff[index] == 0 ) {
            index++;
        }
        for(int start = index; start < diff.length; start++){
            System.out.println(diff[start]);
        }
        return;
    }
}
