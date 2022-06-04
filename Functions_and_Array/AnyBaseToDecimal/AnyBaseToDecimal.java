package Functions_and_Array.AnyBaseToDecimal;
import java.util.*;

public class AnyBaseToDecimal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getAnyBaseToDecimal(n, b));
        scanner.close();
        return;
    }

    //time complexity - O(d) where d => #digits in number n
    //O(log(n))
    private static int getAnyBaseToDecimal(int n, int b) {
        int ans = 0, powOfBase = 1;
        while(n > 0){
            ans += (n%10)*(powOfBase);
            powOfBase *= b;
            n/=10;
        }
        return ans;
    }
}
