package TwoD_Arrays.SearchInSortedTwoDArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchInSortedTwoDArrays {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int d = Integer.parseInt(br.readLine());
        isElementInTwoDArray(a, n, d);
        br.close();
        return;
    }

    //time complexity - O(n + m) - as one of the worst case could be to travel last col and then last row whole.
    private static void isElementInTwoDArray(int[][] a, int n, int d) {
        int i = 0, j = n - 1;
        while(i < n && j >= 0){
            if(a[i][j] == d){
                System.out.println(i + "\n" + j);
                return;
            }
            else if(d > a[i][j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println("Not Found");
        return;
    }
}
