package Getting_Started.PrintDigits;
import java.util.*;

public class PrintDigits {

    public static void printDigits(int n){
        if(n <= 0){
            return;
        }
        printDigits(n/10);
        System.out.println(n%10);
        return;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 0){
            System.out.println(n);
        }
        else{
            printDigits(n);
        }
        scanner.close();
    }
}
