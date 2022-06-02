package Getting_Started.PrintPrimesTillN;
import java.util.*;

public class PrimesTillN {

    public static void printPrimes(int low, int high) {

        boolean[] primes = new boolean[high + 1];
        primes[0] = true;
        primes[1] = false;
        for(int i = 2; i*i <= high; i++){
            if(primes[i]  == false){
                for(int j = 2*i; j <= high; j += i){
                    primes[j] = true;
                }
            }
        }

        for(int i = low; i <= high; i++){
            if(primes[i] == false){
                System.out.println(i);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        printPrimes(low, high);
        scanner.close();
    }
}
