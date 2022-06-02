package Getting_Started.Fibonnaci;
import java.util.*;

public class PrintFibonnaci {

    
    //time complexity - O(n)
    public static void printFibonnaci(int n) {
        if(n < 1){
            System.out.println("not valid number");
        }
        else if(n == 1){
            System.out.println("0");
        }
        else if(n == 2){
            System.out.println("0");
            System.out.println("1");
        }
        else{
            System.out.println("0");
            System.out.println("1");
            int prevNumber = 0, currNumber = 1, temp;
            while(n > 2){
                temp = currNumber + prevNumber;
                System.out.println(temp);
                prevNumber = currNumber;
                currNumber = temp;
                n--;
            }
        }
        return;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printFibonnaci(n);
        scanner.close();
    }
}
