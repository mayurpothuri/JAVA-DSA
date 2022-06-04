package Patterns.Pattern_10;
import java.util.*;

//n = 5
//  		*			
//  	*		*		
//  *				*	
//  	*		*		
//  		*		

public class Pattern10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {

        int right = n/2, left = n/2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + j == left || i + j == right){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
            if(i < n/2){
                right += 2;
            }
            else{
                left += 2;
            }
        }
        return;
    }
}
