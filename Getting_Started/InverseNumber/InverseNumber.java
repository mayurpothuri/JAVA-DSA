package Getting_Started.InverseNumber;

import java.util.Scanner;

public class InverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        inverseNumber(n);
        scanner.close();
    }

    private static void inverseNumber(int n) {
        int ans = 0, count = 1;
        while(n > 0){
            ans += count*((int)Math.pow(10, (n%10 - 1)));
            count++;
            n/=10;
        }
        System.out.println(ans);
        return;
    }
}
