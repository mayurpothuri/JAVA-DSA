package TwoD_Arrays.SpiralTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiralTraversal {

    static int count = 0;
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
        getSpiralTraversal(a);
        br.close();
        return;
    }

    //time complexity - O(n*m) as every cell of n*m grid has to be printed.
    private static void getSpiralTraversal(int[][] a) {

        int top_left_row = 0, top_left_col = 0, bottom_right_row = a.length - 1, bottom_right_col = a[0].length - 1;
        while(count < a.length*a[0].length){
            printDown(a, top_left_row, top_left_col, bottom_right_row);
            top_left_col++;
            printRight(a, bottom_right_row, top_left_col, bottom_right_col);
            bottom_right_row--;
            printUp(a, bottom_right_row, bottom_right_col, top_left_row);
            bottom_right_col--;
            printLeft(a, bottom_right_col, top_left_row, top_left_col);
            top_left_row++;
        }
        return;
    }

    private static void printLeft(int[][] a, int bottom_right_col, int top_left_row, int top_left_col) {

        int n = a.length, m = a[0].length;
        for(int i = top_left_row, j = bottom_right_col; count <n*m && j >= top_left_col; j--){
            System.out.println(a[i][j]);
            count++;
        }
        return;
    }

    private static void printUp(int[][] a, int bottom_right_row, int bottom_right_col, int top_left_row) {
        
        int n = a.length, m = a[0].length;
        for(int i = bottom_right_row, j = bottom_right_col; count <n*m && i >= top_left_row; i--){
            System.out.println(a[i][j]);
            count++;
        }
        return;
    }

    private static void printRight(int[][] a, int bottom_right_row, int top_left_col, int bottom_right_col) {

        int n = a.length, m = a[0].length;
        for(int i = bottom_right_row, j = top_left_col; count < n*m && j <= bottom_right_col; j++){
            System.out.println(a[i][j]);
            count++;
        }
        return;
    }

    private static void printDown(int[][] a, int top_left_row, int top_left_col, int bottom_right_row) {

        int n = a.length, m = a[0].length;
        for(int i = top_left_row, j = top_left_col; count < n*m && i <= bottom_right_row; i++){
            System.out.println(a[i][j]);
            count++;
        }  
        return;
    }
}
