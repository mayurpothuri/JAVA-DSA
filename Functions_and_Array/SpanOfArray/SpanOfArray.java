package Functions_and_Array.SpanOfArray;
import java.util.*;
//get (max of array - min of Array)

public class SpanOfArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        getSpanOfArray(a);
        scanner.close();
        return;
    }

    //time complexity - O(n)
    private static void getSpanOfArray(int[] a) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            min = a[i] < min ? a[i] : min;
            max = a[i] > max ? a[i] : max;
        }
        System.out.println(max - min);
        return;
    }
}
