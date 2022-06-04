package Patterns.Pattern_12;
import java.util.*;

//n = 5
//  0	
//  1	1	
//  2	3	5	
//  8	13	21	34	
//  55	89	144	233	377

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        int prevSum = 0, currSum = 1, temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(prevSum + "\t");
                temp = currSum + prevSum;
                prevSum = currSum;
                currSum = temp;
            }
            System.out.println();
        }
        return;
    }
}
