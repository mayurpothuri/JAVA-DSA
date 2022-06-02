package Getting_Started.CheckPrime;
import java.util.*;

public class CheckPrime {
    //this more improved version than O(sqrt(n))
    //we are iterating by 6[as lcm(2,3) = 6 also we are checking mod 2 and mod 3] jumps.
    //while jumping from i = 5, 5 + 6[11], 5 + 6 + 6[17], ... we also need to 7[5 + 2], 5 + 6 + 2[13], ....
    //hence in the loop, need to check n%i == 0 && n%(i + 2) == 0
    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        else if(n == 2 || n == 3){
            return true;
        }
        for(int i = 5; i*i <= n; i += 6){
            if(n%i == 0 || n%(i + 2) == 0){
                return false;
            }
        }
        return true;
    }
    //time complexity = O(sqrt(n))
    public static boolean checkPrime(int n) {
        if(n == 1){
            return false;
        }
        if(n == 2 || n == 3){
            return true;
        }
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        for(int i = 0; i < t; i++){
            n = scanner.nextInt();
            if(isPrime(n)){
                System.out.println("prime");
            }
            else{
                System.out.println("not prime");
            }
        }
        scanner.close();
    }
}
