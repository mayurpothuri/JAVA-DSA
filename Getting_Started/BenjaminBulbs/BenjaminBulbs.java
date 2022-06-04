package Getting_Started.BenjaminBulbs;
import java.util.*;

//You are given n number of bulbs. They are all switched off. 
//A weird fluctuation in voltage hits the circuit n times. In the 1st fluctuation all bulbs are toggled, 
//in the 2nd fluctuation every 2nd bulb is toggled, in the 3rd fluctuation every 3rd bulb is toggled and so on. 
//You've to find which bulbs will be switched on after n fluctuations.

public class BenjaminBulbs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //so as per the problem, the bulbs which are in switched on state after n fluctuations, are the bulbs
        //whose factors are odd since the bulbs are initially in off state and in 1st state, the state of all bulbs are on. 
        //The numbers whose factors are odd are perfect squares as factors of a number comes in pair.
        //Eg - 1 -> [1][odd factots], 2 -> [1, 2][even factors], 3 - [1, 3][even factors], 4 - [1, 2, 4][odd factors],
        // 5 - [1, 5][even factors], 6 - [1, 2, 3, 6][even factors], so on....
        //time complexity - O(sqrt(n))
        for(int i = 1; i*i <= n; i++){
            System.out.println(i*i);
        }
        scanner.close();
        return;
    }
}
