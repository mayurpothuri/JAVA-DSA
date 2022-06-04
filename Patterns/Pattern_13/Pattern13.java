package Patterns.Pattern_13;
import java.util.*;
//n = 5
//  1
//  1       1
//  1       2       1
//  1       3       3       1
//  1       4       6       4       1
//  1       5       10      10      5       1

public class Pattern13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    //since nC(k + 1) = (nCk*(n - k))/(k + 1)
    //nC(k + 1) = n!/(n - (k + 1))!*(k + 1)!
    // = (n!*(n - k))/(n - k)!*(k + 1)*k!
    // = (nCk*(n - k))/(k + 1)
    private static void printPattern(int n) {

        int nCk_plus_1 = 1;
        for(int i = 0; i <=n; i++){
            nCk_plus_1 = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(nCk_plus_1 + "\t");
                nCk_plus_1 = nCk_plus_1*(i - j)/(j + 1);
            }
            System.out.println();
        }
        return;
    }

}
