package TwoD_Arrays.ExitPointInMatrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExitPointInMatrix {
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
        getExitPoint(a, n, m);
        br.close();
        return;
    }

    //time complexity - O(n*m) at worst we can travel all cells of n*m grid.
    private static void getExitPoint(int[][] a, int n, int m) {

        int i = 0, j = 0, direction = 0;
        while(true){
            if(i >= n || j >= m || i < 0 || j < 0){
                break;
            }
            if(a[i][j] == 1){
                direction = (direction + 1)%4;
            }
            if(direction == 0){
                j++;
            }
            else if(direction == 1){
                i++;
            }
            else if(direction == 2){
                j--;
            }
            else if(direction == 3){
                i--;
            }
            
        }
        i = i < 0 ? 0 : i;
        j = j < 0 ? 0 : j;
        i = i >= n ? n - 1 : i;
        j = j >= m ? m - 1 : j;
        System.out.println(i);
        System.out.println(j);
        return;
    }
}
