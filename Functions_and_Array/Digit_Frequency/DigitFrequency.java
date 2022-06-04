package Functions_and_Array.Digit_Frequency;
import java.util.*;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int d = scanner.nextInt();
        getDigitFrequency(n, d);
        scanner.close();
        return;
    }

    //time complexity - O(d) where d => #digits in number n
    //O(log(n))
    private static void getDigitFrequency(int n, int d) {

        int count = 0;
        while(n > 0){
            if(n%10 == d){
                count++;
            }
            n/=10;
        }
        System.out.println(count);
        return;
    }
}
