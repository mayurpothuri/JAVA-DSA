package Patterns.Pattern_1;
import java.util.*;

//print below pattern
//n = 5

//*
//* * 
//* * *
//* * * *
//* * * * *

public class Pattern1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
        return;
    }
}
