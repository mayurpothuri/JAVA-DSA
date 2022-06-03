package Getting_Started.GcdLcm;
import java.util.*;

public class GcdLcm {

    //time complexity - O(log(min(a, b)))
    public static int calGcd(int a, int b) {
        if(a == 0){
            return b;
        }
        else if(b == 0){
            return a;
        }
        return calGcd(b%a, a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = calGcd(a, b);
        int lcm = (a*b)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
        scanner.close();
        return;
    }
}
