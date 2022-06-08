package Recursion_and_Backtracking.Factorial;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        System.out.println(getFactorial(n));
        scanner.close();
        return;
    }

    //time complexity - O(n) as we are going from n to 1 and at each step we are calculating product[constant time].
    private static int getFactorial(int n) {
        if(n <= 1){
            return 1;
        }
        int fact = getFactorial(n - 1);
        //post area [after recursion call]
        return n * fact;
    }
}
