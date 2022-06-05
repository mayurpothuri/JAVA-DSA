package Functions_and_Array.ReverseArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(br.readLine());
        }

        getReverseArray(a); 
        display(a);
        return;
    }

    private static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
      }

    //time complexity - O(n/2) ===> O(n)
    private static void getReverseArray(int[] a) {
        int i = 0, j = a.length - 1, temp = 0;
        while(i <= j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;j--;
        }
        return;
    }
}
