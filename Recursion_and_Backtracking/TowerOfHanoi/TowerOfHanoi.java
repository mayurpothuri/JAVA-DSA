package Recursion_and_Backtracking.TowerOfHanoi;

import java.util.Scanner;

    //tower1 has n disks, tower2 and tower3 are empty initially.
    //move all the disks from tower1 to tower2 using tower 3 such that at every step
    //larger disks are at bottom and smaller disks relatively should be on top.
    //So have faith[recursion] that n - 1 disks from top to bottom will be 
    //transfered to tower3 using tower 2, then transfer the nth disk to tower2 and then
    //again by faith[recursion] transfer the n - 1 disks to tower2 using tower1.
public class TowerOfHanoi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tower1 = scanner.nextInt();
        int tower2 = scanner.nextInt();
        int tower3 = scanner.nextInt();

        getTowerOfHanoi(n, tower1, tower2, tower3);
        scanner.close();
        return;
    }

    //time complexity - O(2 power n)
    //T(n) = 2*T(n - 1); T(n - 1) = 2*T(n - 2); T(n - 2) = 2*T(n - 3)
    //T(n) = 2*[2*T(n - 2)]
    //T(n) = 2*[2*[2*T(n - 3)]]
    //.... => T(n) = 2 power n
    private static void getTowerOfHanoi(int n, int tower1, int tower2, int tower3) {
        if(n <= 0){
            return;
        }
        //pre area - [before both recursion calls]
        getTowerOfHanoi(n - 1, tower1, tower3, tower2);
        //in area - [after one recursion call and before another recursion call]
        System.out.println(n + "[" + tower1 + " -> " + tower2 + "]");
        getTowerOfHanoi(n - 1, tower3, tower2, tower1);
        //post area - [after both recursion calls]
        return;
    }
}
