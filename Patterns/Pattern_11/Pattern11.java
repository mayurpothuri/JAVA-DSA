package Patterns.Pattern_11;
import java.util.*;

//n = 5
//  1	
//  2	3	
//  4	5	6	
//  7	8	9	10	
//  11	12	13	14	15	


public class Pattern11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        int count = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(count + "\t");
                count++;
            }
            System.out.println();
        }
        return;
    }
}
