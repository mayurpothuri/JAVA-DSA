import java.util.*;

public class PrintZ{

    public static void printZ(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == n - 1){
                    System.out.print("*");
                }
                else if(i + j == n - 1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        return;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printZ(n);
        scanner.close();
    }//end of main method
}//end of class