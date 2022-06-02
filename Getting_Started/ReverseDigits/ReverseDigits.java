package Getting_Started.ReverseDigits;
import java.util.*;

public class ReverseDigits {

    public static void reverseDigits(int n) {
        if(n < 10){
            System.out.println(n);
        }
        else{
            int reverseNumber = 0;
            while(n > 0){
                reverseNumber += n%10;
                reverseNumber *= 10;
                n/=10;
            }
            System.out.println(reverseNumber);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        reverseDigits(n);
        scanner.close();
    }
}
