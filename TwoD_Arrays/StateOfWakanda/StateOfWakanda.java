package TwoD_Arrays.StateOfWakanda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StateOfWakanda {
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

        getStateOfWakanda(a);
        br.close();
        return;
    }

    //time complexity - O(n*n)
    private static void getStateOfWakanda(int[][] a) {
        int count = 0, i = 0;
        for(int j = 0; j < a[0].length; j++){
            if(count%2 == 0){
                while(i < a.length){
                    System.out.println(a[i][j]);
                    i++;
                }
                i = a.length - 1;
            }
            else{
                while(i >= 0){
                    System.out.println(a[i][j]);
                    i--;
                }
                i = 0;
            }
            count++;
        }
        return;
    }
}
