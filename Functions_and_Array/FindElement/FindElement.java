package Functions_and_Array.FindElement;
import java.util.*;

public class FindElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        System.out.println(findElement(a, d));
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static int findElement(int[] a, int d) {

        for(int i = 0; i < a.length; i++){
            if(a[i] == d){
                return i;
            }
        }
        return -1;
    }
}
