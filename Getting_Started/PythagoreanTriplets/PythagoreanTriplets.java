package Getting_Started.PythagoreanTriplets;
import java.util.*;

public class PythagoreanTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if((a*a + b*b == c*c) || (b*b + c*c == a*a) || (c*c + a*a == b*b)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        scanner.close();
        return;
    }
}
