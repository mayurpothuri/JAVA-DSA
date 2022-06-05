package Functions_and_Array.AnyBaseMultiplication;
import java.util.*;
//base = 8
//n1 = 234
//n2 = 76
//22710

public class AnyBaseMultiplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        getAnyBaseMultiplication(base, n1, n2);
        scanner.close();
        return;
    }

    //time complexity - O(log(n1)*log(n2)) roughly
    private static void getAnyBaseMultiplication(int base, int n1, int n2) {
        int partialAns = 0, digit1 = 0, digit2 = 0, carry = 0, powOfTen = 1, prod = 0, a = 0, ans = 0, p = 1;
        while(n2 > 0){
            a = n1;
            digit2 = n2%10;
            while(a > 0){
                digit1 = a%10;
                prod = digit1*digit2;
                partialAns += (((prod + carry)%base)*powOfTen);
                carry = (prod + carry)/base;
                powOfTen *= 10;
                a/=10;
            }
            if(carry > 0){
                partialAns = partialAns + carry*powOfTen;
                carry = 0;
            }
            ans = getAnyBaseAddition(base, partialAns*p, ans);
            partialAns = 0;
            p *= 10;
            powOfTen = 1;
            n2/=10;
        }
        System.out.println(ans);
        return;
    }

    private static int getAnyBaseAddition(int base, int partialSum, int ans) {

        int result = 0, carry = 0, digit1 = 0, digit2 = 0, powOfTen = 1;
        while(partialSum > 0 || ans > 0 || carry > 0){
            digit1 = partialSum%10;
            digit2 = ans%10;
            result += ((digit1 + digit2 + carry)%base)*powOfTen;
            carry = (digit1 + digit2 + carry)/base;
            powOfTen *= 10;
            partialSum/=10;
            ans/=10;
        }
        if(carry > 0){
            result += carry*powOfTen;
        }
        return result;
    }
}
