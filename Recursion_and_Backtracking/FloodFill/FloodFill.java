package Recursion_and_Backtracking.FloodFill;

import java.util.Scanner;

//  all four moves are available make moves in the order 't', 'l', 'd' and 'r'
//  't' (1-step up), 
//  'l' (1-step left), 
//  'd' (1-step down) 
//  'r' (1-step right)
public class FloodFill {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] maze = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maze[i][j] = scanner.nextInt();
            }
        }

        floodFill(maze, 0, 0, "");
        scanner.close();
        return;
    }

    //time complexity - O(4 power(n*m)) as 4 recursive calls are made for n rows and m cols
    //O(n*m)
    static boolean[][] visited;
    private static void floodFill(int[][] maze, int row, int col, String asf) {

        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || visited[row][col] == true || maze[row][col] == 1){
            return;
        }
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(asf);
            return;
        }

        visited[row][col] = true;
        floodFill(maze, row - 1, col, asf + "t");//t - (1 step up)
        floodFill(maze, row, col - 1, asf + "l");//l - (1 step left)
        floodFill(maze, row + 1, col, asf + "d");//d - (1 step down)
        floodFill(maze, row , col + 1, asf + "r");//r - (1 step right)
        visited[row][col] = false;
        return;
    }
}
