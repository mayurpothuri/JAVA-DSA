package TwoD_Arrays.Rotate_Nine_Zero_Degree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateNineZeroDegree {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        getRotateMatrix(a, n);
        display(a);
        br.close();
        return;
    }

    private static void display(int[][] a) {

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    //time complexity - O(n*n) roughly as all cells are visited and outer "shell" to inner "shell", it is rotated by one.
    private static void getRotateMatrix(int[][] a, int n) {

        int row = 0, col = 0, count = 0;
        int[] temp = new int[4];
        while(true){
            for(int i = 0; i < n - 1 - col - row; i++){
                temp[0] = a[row][col + i];
                temp[1] = a[row + i][n - 1 - col];
                temp[2] = a[n - 1 - row][n - 1 - col - i];
                temp[3] = a[n - 1 - row - i][col];

                rotateArray(temp, 1);

                a[row][col + i] = temp[0];
                a[row + i][n - 1 - col] = temp[1];
                a[n - 1 - row][n - 1 - col - i] = temp[2];
                a[n - 1 - row - i][col] = temp[3];
                count += 4;
            }
            if(count >= n*n || count >= n*n - 1){
                break;
            }
            row++;
            col++;
        }
        return;
    }

    private static void rotateArray(int[] temp, int i) {
    
        getReverse(temp, 0, temp.length - i - 1);
        getReverse(temp, temp.length - i, temp.length - 1);
        getReverse(temp, 0, temp.length - 1);
        return;
    }

    private static void getReverse(int[] temp, int i, int j) {
        int x = 0;
        while(i < j){
            x = temp[i];
            temp[i] = temp[j];
            temp[j] = x;
            i++;
            j--;
        }
        return;
    }
}
