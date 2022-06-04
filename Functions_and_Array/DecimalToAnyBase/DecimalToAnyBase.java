package Functions_and_Array.DecimalToAnyBase;
import java.util.*;

public class DecimalToAnyBase {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getDecimalToAnyBase(n, b));
        scanner.close();
        return;
    }

    //time complexity - O(d) where d => #digits in number n
    //O(log(n))
    private static int getDecimalToAnyBase(int n, int b) {
        int ans = 0, powOfTen = 1;
        while(n > 0){
            ans += (n%b)*(powOfTen);
            powOfTen *= 10;
            n/=b;
        }
        return ans;
    }
}
