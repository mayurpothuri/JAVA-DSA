package Functions_and_Array.AnyBaseToAnyBase;
import java.util.*;

//time complexity - O(d) where d => #digits in number n, as in asymptotic analysis, the constants are ignored[running O(d) two times].
//O(log(n))

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        getAnyBaseToAnyBase(n, b1, b2);
        scanner.close();
        return;
    }

    private static void getAnyBaseToAnyBase(int n, int b1, int b2) {

        int decimal = getAnyBaseToDecimal(n, b1);
        int baseNumber = getDecimalToAnyBase(decimal, b2);
        System.out.println(baseNumber);
        return;
    }

    private static int getDecimalToAnyBase(int decimal, int b2) {
        int ans = 0, powOfTen = 1;
        while(decimal > 0){
            ans += (decimal%b2)*(powOfTen);
            powOfTen *= 10;
            decimal/=b2;
        }
        return ans;
    }

    private static int getAnyBaseToDecimal(int n, int b1) {

        int ans = 0, powOfBase = 1;
        while(n > 0){
            ans += (n%10)*(powOfBase);
            powOfBase *= b1;
            n/=10;
        }
        return ans;
    }
}
