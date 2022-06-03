package Getting_Started.RotateNumber;
import java.util.*;

public class RotateNumber {

    //time complexity - O(d) => #digits in number n.
    public static int countDigits(int n) {
        if(n < 10){
            return 1;
        }
        int count = 0;
        while(n > 0){
            count++;
            n/=10;
        }
        return count;
    }

    public static void rotateNumber(int n, int k) {

        int numOfDigits = countDigits(n);
        k = k%numOfDigits;
        if(k < 0){
            k += numOfDigits;
        }

        int r1 = (n%((int)Math.pow(10, k)))*((int)Math.pow(10, numOfDigits - k));
        int r2 = n/((int)Math.pow(10, k));
        System.out.println(r1 + r2);
        return;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        rotateNumber(n, k);
        scanner.close();
        return;
    }
}
