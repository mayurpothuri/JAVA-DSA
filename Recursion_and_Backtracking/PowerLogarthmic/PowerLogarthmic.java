package Recursion_and_Backtracking.PowerLogarthmic;

import java.util.Scanner;

public class PowerLogarthmic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(getPowerLogarthmic(x, n));
        scanner.close();
        return;
    }

    //time complexity - O(log(n))
    private static int getPowerLogarthmic(int x, int n) {

        if(n == 0){
            return 1;
        }
        int x1 = getPowerLogarthmic(x, n/2);
        //post area - [after recursion call]
        if(n%2 == 0){
            return x1*x1;
        }
        else{
            return x*x1*x1;
        }
    }
}
