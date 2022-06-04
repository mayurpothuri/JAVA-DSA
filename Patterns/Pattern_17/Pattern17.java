package Patterns.Pattern_17;
import java.util.*;

//n = 5
//                  *
//                  *       *
//  *       *       *       *       *
//                  *       *
//                  *

public class Pattern17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        int stars = 1, spaces = n/2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < spaces; j++){
                if(i == n /2){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            for(int j = 0; j < stars; j++){
                System.out.print("*\t");
            }
            if(i < n/2){
                stars++;
            }
            else{
                stars--;
            }
            System.out.println();
        }
        return;
    }
}
