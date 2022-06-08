package Recursion_and_Backtracking.PowerLinear;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(getPowerLinear(x, n));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    //calculating x power n
    private static int getPowerLinear(int x, int n) {
        if(n == 0){
            return 1;
        }
        else if(n <= 1){
            return x;
        }
        int x_n_minus_one_power = getPowerLinear(x, n - 1);
        //post area - [after recursion call]
        return x*x_n_minus_one_power;
    }
}
