package TwoD_Arrays.TwoD_Array_Display;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayDisplay {
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

        display(a);
        br.close();
        return;
    }

    //time complexity - O(n*n)
    private static void display(int[][] a) {
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}
