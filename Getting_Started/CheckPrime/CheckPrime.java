package Getting_Started.CheckPrime;
import java.util.*;

public class CheckPrime {
    //time complexity = O(sqrt(n))
    public static boolean checkPrime(int n) {
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
            if(checkPrime(n)){
                System.out.println("prime");
            }
            else{
                System.out.println("not prime");
            }
        }
        scanner.close();
    }
}
