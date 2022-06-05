package Functions_and_Array.AnyBaseSubtraction;
import java.util.*;

//base = 8
//n1 = 1212
//n2 = 236
//754

public class AnyBaseSubtraction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        getAnyBaseSubtraction(base, n1, n2);
        scanner.close();
        return;
    }

    //time complexity - O(log(max(n1, n2)))
    //roughly O(log(n))
    private static void getAnyBaseSubtraction(int base, int n1, int n2) {

        int borrow = 0, x = 0, y = 0, a = Math.max(n1, n2), b = Math.min(n1, n2), ans = 0, powOfTen = 1;
        while(a > 0 || b > 0){
            x = a%10;
            y = b%10;
            a/=10;
            b/=10;
            x += borrow;
            if(x >= y){
                borrow = 0;
            }
            else{
                borrow = -1;
                x += base;
            }
            ans += (x - y)*powOfTen;
            powOfTen *= 10;
        }
        System.out.println(ans);
        return;
    }
}
