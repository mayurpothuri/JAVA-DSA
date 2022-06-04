package Patterns.Pattern_18;
import java.util.*;

//n = 5
//  *	*	*	*	*	
//  	*		*		
//  		*			
//  	*	*	*		
//  *	*	*	*	*

public class Pattern18 {
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
                if(i == 0 || i == j || i == n - 1 || i + j == n - 1 || (i > n/2 && i >= j && i + j >= n - 1)){
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
