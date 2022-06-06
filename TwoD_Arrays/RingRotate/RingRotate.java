package TwoD_Arrays.RingRotate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RingRotate {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int s = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        getRingRotate(a, n, m, s, r);
        display(a, n, m);
        br.close();
        return;
    }

    private static void display(int[][] a, int n, int m) {

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    //time complexity - O(size of shell) since each shell is copied, 
    //rotated by some r amount[O(size of shell)] and then that shell being copied to 2D array.
    //size of shell ==> 2*n + 2*m roughly ==> n + m
    //Hence, O(n + m)
    private static void getRingRotate(int[][] a, int n, int m, int s, int r) {

        int row = s - 1, col = s - 1, size = 0;
        //size = n - 2*(s) <= 0 ? n - 2*(s - 1) : 2*(m - 2*(s - 1)) + 2*(n - 2*(s));
        size = n - 2*(s) <= 0 ? n - 2*(s - 1) : 2*n + 2*m - 8*s + 4;
        int[] temp = new int[size];
        fillArray(a, temp, row, col, 0);
        getRotateByR(temp, r);
        fillArray(a, temp, row, col, 1);
        return;
    }

    private static void getRotateByR(int[] temp, int r) {
        r = r%temp.length;
        if(r < 0){
            r = temp.length + r;
        }
        r = temp.length - r;
        getReverse(temp, 0, temp.length - r - 1);
        getReverse(temp, temp.length - r, temp.length - 1);
        getReverse(temp, 0, temp.length - 1);
        return;
    }

    private static void getReverse(int[] temp, int i, int j) {
        int x = 0;
        while(i < j){
            x = temp[i];
            temp[i] = temp[j];
            temp[j] = x;
            i++;j--;
        }
        return;
    }

    private static void fillArray(int[][] a, int[] temp, int row, int col, int switchCase) {

        int k = 0;
        for(int i = row, j = col; j <= a[0].length - 1 - col; j++){
            if(switchCase == 0){
                temp[k++] = a[i][j];
            }
            else{
                 a[i][j] = temp[k++];
            }
        }

        for(int i = row + 1, j = a[0].length - 1 - col; i <= a.length - 1 - row; i++){
            if(switchCase == 0){
                temp[k++] = a[i][j];
            }
            else{
                 a[i][j] = temp[k++];
            }
        }

        for(int i = a.length - 1 - row, j = a[0].length - 1 - col - 1; j >= col; j--){
            if(switchCase == 0){
                temp[k++] = a[i][j];
            }
            else{
                 a[i][j] = temp[k++];
            }
        }

        for(int i = a.length - 1 - row - 1, j = col; i > row; i--){
            if(switchCase == 0){
                temp[k++] = a[i][j];
            }
            else{
                 a[i][j] = temp[k++];
            }
        }
        return;
    }
}
