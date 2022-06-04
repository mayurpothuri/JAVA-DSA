package Patterns.Pattern_4;
import java.util.*;

//n = 5
//  *	*	*	*	*	
//	    *	*	*	*	
//		    *	*	*	
//			    *	*	
//				    *	


public class Pattern4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        int stars = n, spaces = 0;
        for(int i = 0; i < n; i++){

            for(int j = 0; j < spaces; j++){
                System.out.print("\t");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*\t");
            }
            spaces++;
            stars--;
            System.out.println();
        }
        return;
    }
}
