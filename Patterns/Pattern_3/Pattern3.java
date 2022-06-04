package Patterns.Pattern_3;
import java.util.*;

//n = 5
//        *
//      * *
//    * * *
//  * * * *
//* * * * *

public class Pattern3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        int spaces = n - 1, stars = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < spaces; j++){
                System.out.print("\t");
            }
            for(int j = 0; j < stars; j++){
                System.out.print("*\t");
            }
            stars++;
            spaces--;
            System.out.println();
        }
        return;
    }
}
