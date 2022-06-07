package TwoD_Arrays.SaddlePrice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SaddlePrice {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }

        getSaddlePrice(a, n);
        br.close();
        return;
    }

    //time complexity - O(n*n) as we are getting row-wise min and col-wise after each iteration.
    private static void getSaddlePrice(int[][] a, int n) {

        int j = -1;
        for(int i = 0; i < a.length; i++){
            j = getMinimum(a, i);
            if(getMaximum(a, j) == i){
                System.out.println(a[i][j]);
                return;
            }
        }
        System.out.println("Invalid input");
        return;
    }

    //get min row index for jth col.
    private static int getMaximum(int[][] a, int j) {
        int max = Integer.MIN_VALUE, index = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i][j] > max){
                max = a[i][j];
                index = i;
            }
        }
        return index;
    }

    //get min col index for ith row.
    private static int getMinimum(int[][] a, int i) {
        int min = Integer.MAX_VALUE, index =  -1;
        for(int j = 0; j < a[i].length; j++){
            if(a[i][j] < min){
                min = a[i][j];
                index = j;
            }
        }
        return index;
    }
}
