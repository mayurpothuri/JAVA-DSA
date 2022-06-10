package Recursion_and_Backtracking.NQueens;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] chess = new int[n][n];

        getNQueensPlaces(chess, "", 0);
        scanner.close();
        return;
    }

    //time complexity - T(n) = n*T(n - 1)
    //O(n!)
    private static void getNQueensPlaces(int[][] chess, String qsf, int row) {
        if(row == chess.length){
           System.out.println(qsf + ".");
           return; 
        }
        //for each row, we are checking when queen is placed at col, then using recursion
        //get the ans.
        //recursion faith - for given row and col, we know the answer.
        //so for all row and col, we can obtain full answer 
        for(int i = 0; i < chess.length; i++){
            if(chess[row][i] == 0 && isSafe(chess, row, i) == true){
                //pre area - [before recursion call]
                chess[row][i] = 1;//queen placed at [row, i]
                getNQueensPlaces(chess, qsf + row + "-" + i + ", ", row + 1);
                //post area - [after recursion call]
                chess[row][i] = 0;//after getting config setting of all possible
                //positions using [row, i], unplace queen at [row, i] to check other config settings
                //for other row and col
            }
        }
        return;
    }

    //down side checking is not required
    //down vertical, down diagonal are not required as we are keeping queens row wise in increasing order
    private static boolean isSafe(int[][] chess, int row, int col) {
        //row checking
        for(int i = row, j = 0; j < chess[0].length; j++){
            if(j != col && chess[i][j] == 1){
                return false;
            }
        }
        //column checking
        for(int i = 0, j = col; i < chess.length; i++){
            if(i != row && chess[i][j] == 1){
                return false;
            }
        }
        //right down diagonal
        // for(int i = row + 1, j = col + 1; i < chess.length && j < chess.length; i++, j++){
        //     if(chess[i][j] == 1){
        //         return false;
        //     }
        // }
        //left up diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        //right up diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        //left down diagonal
        // for(int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--){
        //     if(chess[i][j] == 1){
        //         return false;
        //     }
        // }
        return true;
    }
}
