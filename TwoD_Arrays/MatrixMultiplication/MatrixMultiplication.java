package TwoD_Arrays.MatrixMultiplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixMultiplication {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] a1 = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a1[i][j] = Integer.parseInt(br.readLine());
            }
        }
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] a2 = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a2[i][j] = Integer.parseInt(br.readLine());
            }
        }

        getMultiplyTwoDArrays(a1, a2);
        br.close();
        return;
    }

    //time complexity - O(n*n*n) as three nexted loops are there and for each element, the summation of product terms are calculated.
    private static void getMultiplyTwoDArrays(int[][] a1, int[][] a2) {
        if(a1[0].length != a2.length){
            System.out.println("Invalid input");
            return;
        }
        int[][] prod = new int[a1.length][a2[0].length];
        for(int i = 0; i < prod.length; i++){
            for(int j = 0; j < prod[0].length; j++){
                for(int k = 0; k < a2.length; k++){
                    prod[i][j] += a1[i][k]*a2[k][j];
                }
            }
        }
        display(prod);
        return;
    }

    //time complexity - O(n*m)
    private static void display(int[][] prod) {

        for(int i = 0; i < prod.length; i++){
            for(int j = 0; j <prod[0].length; j++){
                System.out.print(prod[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}
