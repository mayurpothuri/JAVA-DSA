package Patterns.Pattern_9;
import java.util.*;

public class Pattern9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || i + j == n - 1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        return;
    }
}
