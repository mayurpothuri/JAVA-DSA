package Functions_and_Array.AnyBaseAddition;
import java.util.*;

//base = 8
//n1 = 777
//n2 = 1
//result = 1000

public class AnyBaseAddition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println(getSum(b, n1, n2));
        scanner.close();
        return;
    }

    //time complexity - O(log(max(n1, n2)))
    //as we are iterating over digits of maximum number(n1, n2) and doing some constant operations.
    private static int getSum(int base, int n1, int n2) {
        int carry = 0, a = 0, b = 0, ans = 0, powOfTen = 1;
        while(n1 > 0 && n2 > 0){
            a = n1%10;
            b = n2%10;
            ans += ((a + b + carry)%base)*powOfTen;
            powOfTen *= 10;
            carry = (a + b + carry)/base;
            n1/=10;
            n2/=10;
        }
        while(n1 > 0){
            a = n1%10;
            ans += ((a + carry)%base)*powOfTen;
            powOfTen *= 10;
            carry = (a + carry)/base;
            n1/=10;

        }

        while(n2 > 0){
            b = n2%10;
            ans += ((b + carry)%base)*powOfTen;
            powOfTen *= 10;
            carry = (b + carry)/base;
            n2/=10;
        }
        if(carry > 0){
            ans += (carry%(base))*powOfTen;
        }
        return ans;
    }
}
