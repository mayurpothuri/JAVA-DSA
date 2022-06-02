package Getting_Started.CountDigits;

import java.util.Scanner;

public class CountDigits {

    //time complexity - O(d) where d = #digits. => O(log n)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n > 0){
            count++;
            n/=10;
        }
        System.out.println(count);
        scanner.close();
    }
}
