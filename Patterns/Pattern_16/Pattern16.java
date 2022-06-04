package Patterns.Pattern_16;
import java.util.*;

//n = 5
//  1                                                               1
//  1       2                                               2       1
//  1       2       3                               3       2       1
//  1       2       3       4               4       3       2       1
//  1       2       3       4       5       4       3       2       1

public class Pattern16 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        int count = 1, tempCount, spaces = 2*n - 3, stars = 1;
        for(int i = 0; i < n; i++){
            tempCount = count;
            for(int j = 0; j < stars; j++){
                System.out.print(tempCount +"\t");
                tempCount++;
            }
            for(int j = 0; j < spaces; j++){
                System.out.print("\t");
            }
            tempCount--;
            if(i == n - 1){
                tempCount--;
                stars--;
            }
            for(int j = 0; j < stars; j++){
                System.out.print(tempCount + "\t");
                tempCount--;
            }
            spaces -= 2;
            stars++;
            System.out.println();
        }
        return;
    }
}
