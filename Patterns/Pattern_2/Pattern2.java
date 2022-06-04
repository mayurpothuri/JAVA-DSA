package Patterns.Pattern_2;
import java.util.*;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        for(int i = 0; i < n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print("*\t");
            }
            System.out.println();
        }
        return;
    }
}
