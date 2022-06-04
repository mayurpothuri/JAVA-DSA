package Patterns.Pattern_5;
import java.util.*;

//n = 5
//          *	
//      *	*	*	
//  *	*	*	*	*	
//      *	*	*	
//          *	

public class Pattern5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
        return;
    }

    private static void printPattern(int n) {
        int spaces = n/2, stars = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < spaces; j++){
                System.out.print("\t");
            }
            for(int j = 0; j < stars; j++){
                System.out.print("*\t");
            }
            if(i < n/2){
                spaces--;
                stars += 2;
            }
            else{
                spaces++;
                stars -= 2;
            }
            System.out.println();
        }
        return;
    }
}
