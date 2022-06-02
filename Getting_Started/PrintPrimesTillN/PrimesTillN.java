package Getting_Started.PrintPrimesTillN;
import java.util.*;

public class PrimesTillN {

    //multiples of 2's are crossed, then 3, then 5, so on.
    //n/2 + n/3 + n/5 + n/7 + .... < n/2 + n/3 + n/4 + n/5 + .....
    //n/2 + n/3 + n/5 + n/7 + .... < nlogn[loose bound]
    //but for n/2 + n/3 + n/5 + n/7 + .... ~ nloglogn[exact bound]
    //time complexity = O(nloglogn) but saves some more iterations
    //j = i*i is used instead of j = 2*i since i*(i - 1)[num before i*i], here (i - 1) is smaller than i and since the primes 
    //which are smaller are taken care of in previous loop checking for primes.
    public static void printPrimesEfficient(int low, int high) {

        boolean[] primes = new boolean[high + 1];
        primes[0] = primes[1] = true;
        for(int i = 2; i*i <= high; i++){
            if(primes[i]  == false){
                for(int j = i*i; j <= high; j += i){
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
    //time complexity = O(nloglogn)
    //multiples of 2's are crossed, then 3, then 5, so on.
    //n/2 + n/3 + n/5 + n/7 + .... < n/2 + n/3 + n/4 + n/5 + .....
    //n/2 + n/3 + n/5 + n/7 + .... < nlogn[loose bound]
    //but for n/2 + n/3 + n/5 + n/7 + .... ~ nloglogn[exact bound]
    public static void printPrimes(int low, int high) {

        boolean[] primes = new boolean[high + 1];
        primes[0] = primes[1] = true;
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
        printPrimesEfficient(low, high);
        scanner.close();
    }
}
