package Patterns.Pattern_8;
import java.util.*;

//n = 5
//  				*	
//  			*		
//  		*			
//  	*				
//  *					

public class Pattern8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + j == n - 1){
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
