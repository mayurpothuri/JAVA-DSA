package Getting_Started.PrimeFactorize;
import java.util.*;

public class PrimeFactorize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        primeFactorize(n);
        optimizedPrimeFactorize(n);
        scanner.close();
    }

    //time complexity - O(sqrt(n)) roughly but it saves more iterations
    private static void optimizedPrimeFactorize(int n) {
        if(n < 1){
            return;
        }
        while(n%2 == 0){
            System.out.print(2 + " ");
            n/=2;
        }
        while(n%3 == 0){
            System.out.print(3 + " ");
            n/=3;
        }
        for(int i = 5; i*i <= n; i += 6){
            while(n%i == 0){
                System.out.print(i + " ");
                n/=i;
            }
            while(n%(i + 2) == 0){
                System.out.print((i + 2) + " ");
                n/=(i + 2);
            }
        }
        if(n > 3){
            System.out.println(n);
        }
        return;
    }

    //time complexity - O(sqrt(n)) roughly
    private static void primeFactorize(int n) {
        if(n < 1){
            return;
        }
        for(int i = 2; i * i <= n; i++){
            while(n%i == 0){
                System.out.print(i + " ");
                n/=i;
            }
        }
        if(n > 1){
            System.out.println(n);
        }
        return;
    }
}
