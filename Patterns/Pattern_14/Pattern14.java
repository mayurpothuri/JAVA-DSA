package Patterns.Pattern_14;
import java.util.*;

//n = 3
//  3 * 1 = 3
//  3 * 2 = 6
//  3 * 3 = 9
//  3 * 4 = 12
//  3 * 5 = 15
//  3 * 6 = 18
//  3 * 7 = 21
//  3 * 8 = 24
//  3 * 9 = 27
//  3 * 10 = 30


public class Pattern14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        for(int i = 1; i <= 10; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
        }
        return;
    }
}
