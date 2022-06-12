package Time_and_Space_Complexity.SortDates;

import java.util.Scanner;

public class SortDates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.next();
        }
        sortDates(a);
        display(a);
        scanner.close();
        return;
    }

    private static void display(String[] a) {

        for(String val : a){
            System.out.println(val);
        }
        return;
    }
    //O(n)
    private static void countSort(String[] arr,int div, int mod, int range) {
        // write your code here
        int[] freq = new int[range];//required to decide the length for stroing freq
        String[] result = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            //indices are naturally in sorted order
            //since non-negative numbers are only possilbe
            //which could be used as index -> for a[i] -> index in prefixSum is = [a[i]]
            //take the frequency of each a[i] with the help of prefixSum
            //hence simply prefixSum stores the frequencies of each a[i]
            freq[(Integer.parseInt(arr[i])/div)%mod]++;
        }
        //this is used because we need stable property -> if before sorting, e.g 3[1], 3[2] is there then after
        //after sorting also the previous order should be maintained -> 3[1], 3[2]
        //here we are calculating the cumulative sum of frequencies of a[i] stored in prefixSum
        for(int i = 1; i < freq.length; i++){
            freq[i] += freq[i - 1];
        }
        //as the cumulative sum of freq stored in prefixSum is 1 - based(we want 0 - based index), 
        //so the actual index for a[i] in new result array would be [prefixSum[a[i]] - 1]
        //i.e, for a[i] - > index in prefix => [a[i]] -> index in new result array => [prefixSum[a[i]] - 1]
        //this works because indices are sorted naturally, and since we are using freq of each a[i]
        //index with [a[i]] in prefixSum and where cumulative freq sum is stored then 
        //[prefixSum[a[i]] - 1](1 - based but we want 0 - based index) is the index for a[i] for sorted order
        for(int i = arr.length - 1; i >= 0; i--){
            result[freq[(Integer.parseInt(arr[i])/div)%mod] - 1] = arr[i];
            freq[(Integer.parseInt(arr[i])/div)%mod]--;
        }
        for(int i = 0; i < result.length; i++){
            arr[i] = result[i];
        }
        return;
    }
    //ddmmyyyy - input type
    //to get 'dd' -> divide ddmmyyyy by 1000000 [6 zeroes as total 8 digits are there] and take modulo 100
    //to get second 'mm' -> divide ddmmyyyy by 100000 [4 zeroes as total 7 digits are there] and take 
    //modulo 100
    //to get 'yyyy' -> divide ddmmyyyy by 1 and take modulo 10000[last 4 digits are years and that is needed]
    //time complexity - O(n)
    private static void sortDates(String[] a) {
        //days range - [0 to 31]
        countSort(a, 1000000, 100, 32);
        //months range - [0 to 12]
        countSort(a, 10000, 100, 13);
        //years range as per constraint - [0 to year 2500]
        countSort(a, 1, 10000, 2501);
        return;
    }
}
