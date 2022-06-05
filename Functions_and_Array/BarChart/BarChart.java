package Functions_and_Array.BarChart;
import java.util.*;

//5
//3 1 0 7 5
//  			*		
//  			*		
//  			*	*	
//  			*	*	
//  *			*	*	
//  *			*	*	
//  *	*		*	*	


public class BarChart {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        printBarChart(a);
        scanner.close();
        return;
    }

    //time complexity - O(n*n)
    private static void printBarChart(int[] a) {
        int max = getMaximum(a);
        for(int i = max; i >= 1; i--){
            for(int j = 0; j < a.length; j++){
                if(a[j] >= i){
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

    private static int getMaximum(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            max = a[i] > max ? a[i] : max;
        }
        return max;
    }
}
