package String_DynamicString_DynamicArray.RemovePrimes;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            al.add(scanner.nextInt());
        }
        getRemovePrimes(al);
        System.out.println(al);
        scanner.close();
        return;
    }

    //time complexity - O(n*sqrt(n))
    //as we are checking for each number whether it is prime or not, if prime then remove.
    private static void getRemovePrimes(ArrayList<Integer> al) {

        for(int i = al.size() - 1; i >= 0; i--){
            if(isPrime(al.get(i))){
                al.remove(i);
            }
        }
        return;
    }

    //this more improved version than O(sqrt(n))
    //we are iterating by 6[as lcm(2,3) = 6 also we are checking mod 2 and mod 3] jumps.
    //while jumping from i = 5, 5 + 6[11], 5 + 6 + 6[17], ... we also need to 7[5 + 2], 5 + 6 + 2[13], ....
    //hence in the loop, need to check n%i == 0 && n%(i + 2) == 0
    //time complexity - O(sqrt(n)) roughly but saves more iterations.
    //1 is neither prime nor composite
    private static boolean isPrime(Integer integer) {
        if(integer.intValue() == 1){
            return false;
        }
        else if(integer.intValue() == 2 || integer.intValue() == 3){
            return true;
        }
        else if(integer.intValue()%2 == 0){
            return false;
        }
        else if(integer.intValue()%3 == 0){
            return false;
        }
        else{
            for(int i = 5; i * i <=integer.intValue(); i += 6){
                if(integer.intValue()%i == 0 || integer.intValue()%(i + 2) == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
