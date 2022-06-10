package Recursion_and_Backtracking.KnightTour;

import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] chess = new int[n][n];
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        getKnightTour(chess, row, col, 1);
        scanner.close();
        return;
    }

    //time complexity - O(8*(n*n)) ==> O(n*n) roughly
    private static void getKnightTour(int[][] chess, int row, int col, int upcomingMove) {
    
        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] != 0){
            return;
        }
        //if #upcoming moves == #cells in chess board
        //then all moves are made by knight such that the entire chess board is covered.
        //so print the chess board config
        if(upcomingMove == chess.length*chess.length){
            chess[row][col] = upcomingMove;
            display(chess);
            chess[row][col] = 0;
            return;
        }
        //8 possible knight moves from given [row, col]
        //When moving from [row, col] to the possible 8 options give first precedence to (row - 2, col + 1) and 
        //move in clockwise manner to explore other options.
        chess[row][col] = upcomingMove;//potential move - place knight at [row, col]
        getKnightTour(chess, row - 2, col + 1, upcomingMove + 1);
        getKnightTour(chess, row - 1, col + 2, upcomingMove + 1);
        getKnightTour(chess, row + 1, col + 2, upcomingMove + 1);
        getKnightTour(chess, row + 2, col + 1, upcomingMove + 1);

        getKnightTour(chess, row + 2, col - 1, upcomingMove + 1);
        getKnightTour(chess, row + 1, col - 2, upcomingMove + 1);
        getKnightTour(chess, row - 1, col - 2, upcomingMove + 1);
        getKnightTour(chess, row - 2, col - 1, upcomingMove + 1);
        //post area - [after all recursive calls]
        chess[row][col] = 0;//after all such possible moves from [row, col], unplace the knight from [row, col]
        //to get other options
        return;
    }

    //O(n*n)
    private static void display(int[][] chess) {
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess.length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }
}
