package Patterns.Pattern_15;
import java.util.*;

//n = 5
//  		1	
//  	2	3	2	
//  3	4	5	4	3	
//  	2	3	2	
//  		1	

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        int spaces = n/2, stars = 1, count = 1, tempCount;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < spaces; j++){
                System.out.print("\t");
            }
            tempCount = count;
            for(int j = 0; j < stars; j++){
                System.out.print(tempCount + "\t");
                if(j < stars/2){
                    tempCount++;
                }
                else{
                    tempCount--;
                }
            }
            if(i < n/2){
                stars += 2;
                spaces--;
                count++;
            }
            else{
                stars -= 2;
                spaces++;
                count--;
            }
            System.out.println();
        }
        return;
    }
}
