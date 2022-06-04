package Patterns.Pattern_19;
import java.util.*;

//n = 5
//  *	*	*		*	
//  		*		*	
//  *	*	*	*	*	
//  *		*			
//  *		*	*	*

public class Pattern19 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((i > n/2 && j == 0) || (i < n/2 && j == n - 1) || (i == 0 && j < n/2) || (i == n - 1 && j > n/2) 
                || j == n/2 || i == n/2){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        return;
    }
}
