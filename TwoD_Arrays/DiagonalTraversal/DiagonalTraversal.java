package TwoD_Arrays.DiagonalTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalTraversal {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        getDiagonalTraversal(a, n);
        br.close();
        return;
    }

    //time complexity - O(n*n)
    private static void getDiagonalTraversal(int[][] a, int n) {

        for(int j = 0; j < n; j++){
            for(int i = 0, k = j; i < n && k < n;){
                System.out.println(a[i][k]);
                i++;k++;
            }
        }
        return;
    }
}
